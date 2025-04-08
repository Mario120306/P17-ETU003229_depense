package src.main.java.com.itu.Hello.codejava.Controller;

import java.io.IOException;
import java.rmi.ServerException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.main.java.com.itu.Hello.codejava.Object.Connexion;
import src.main.java.com.itu.Hello.codejava.Object.Prevision;

public class NewPrevision extends HttpServlet{
    public void doPost(HttpServletRequest req ,HttpServletResponse res)
    throws ServerException,IOException{
        String libelle=req.getParameter("libelle");
        int montant_prevision=Integer.parseInt(req.getParameter("montant_prevision"));
        Connexion connexion =new Connexion();
        try{
            connexion.getConnection();
            Prevision prevision=new Prevision(0, libelle, montant_prevision);
            prevision.insert_Prevision(connexion.getConnection());
            res.sendRedirect("acceuil.jsp");
        }catch(Exception e){
            e.printStackTrace();
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
