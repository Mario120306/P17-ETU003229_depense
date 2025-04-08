package src.main.java.com.itu.Hello.codejava.Controller;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.main.java.com.itu.Hello.codejava.Object.Connexion;
import src.main.java.com.itu.Hello.codejava.Object.User;
import jakarta.servlet.http.HttpSession;

public class VerifyUser extends HttpServlet{
    public void doPost(HttpServletRequest req ,HttpServletResponse res) throws ServletException ,IOException{
        String email =req.getParameter("email");
        String password = req.getParameter("password");
        try{
            Connexion connexion = new Connexion();
            connexion.getConnection();
            int id_user =User.verify_user(connexion.getConnection(), email, password);
            if(id_user > 0){
                HttpSession session=req.getSession();
                req.getSession().setAttribute("id_user", id_user);
                session.setAttribute("id_user", id_user);
                res.sendRedirect("acceuil.jsp");
            }else{
                res.sendRedirect("index.jsp");
            }
        }catch(Exception e){
            e.printStackTrace();    
        }
    }
}
