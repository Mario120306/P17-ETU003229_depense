package src.main.java.com.itu.Hello.codejava.Controller;

import java.io.IOException;
import java.util.List;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.main.java.com.itu.Hello.codejava.Object.Connexion;
import src.main.java.com.itu.Hello.codejava.Object.Prevision;
import jakarta.servlet.ServletException;

public class GetPrevision  extends HttpServlet{

    public void doGet(HttpServletRequest req,HttpServletResponse res)
    throws ServletException,IOException{
        Connexion connexion =new Connexion();
        List<Prevision> prevList=Prevision.getAllprevision(connexion.getConnection());
        req.setAttribute("prevList", prevList);
        req.getRequestDispatcher("insertDepense.jsp").forward(req,res);
    }
}
