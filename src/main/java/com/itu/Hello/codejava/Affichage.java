package src.main.java.com.itu.Hello.codejava;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Affichage extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        if(req.getParameter("couleur").isEmpty()){
                out.print("vous n'avez pas encore choisi  le couleur ");
        }
        else if(req.getParameter("couleur")!=null){
                out.print("vous avez choisiz votre couleur");
                Cookie cookies =new Cookie("couleur",req.getParameter("couleur"));
                res.addCookie(cookies);
        }
        }
}