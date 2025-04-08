package src.main.java.com.itu.Hello.codejava.Controller;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.main.java.com.itu.Hello.codejava.Object.Connexion;
import src.main.java.com.itu.Hello.codejava.Object.User;
import java.io.PrintWriter;

public class New_user extends HttpServlet{
    public void doPost(HttpServletRequest req ,HttpServletResponse res)
    throws ServletException ,IOException{

            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            Connexion connexion = new Connexion();
            PrintWriter out = res.getWriter();
            res.setContentType("text/html");
            out.println(name);
            out.println(email);
            try{
                connexion.getConnection();
                User user = new User(0, name, email, password);
                user.insert_user(connexion.getConnection());
                res.sendRedirect("inscription.jsp");
            }catch(Exception e){
                e.printStackTrace();
                out.print(e);
            }
            finally{
                try{
                    connexion.getConnection().close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
    }
}
