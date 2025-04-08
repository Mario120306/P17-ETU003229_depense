package src.main.java.com.itu.Hello.codejava;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class VoirCouleur extends HttpServlet{
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException { 
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        Cookie[] cookies =req.getCookies();
        String Couleur=null;
        if(cookies!=null){
            for(int i=0;i<cookies.length;i++){
                if(cookies[i].getName().equals("couleur")){
                    Couleur =cookies[i].getValue();
                }
            }
        }
        if(Couleur == null){
                out.println("vous devez choisir une couleur");
        }
        else {
            out.println("vous avez choisi la couleur   "+Couleur);
        }
    
    }

}
