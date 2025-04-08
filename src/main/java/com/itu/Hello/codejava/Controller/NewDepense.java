package src.main.java.com.itu.Hello.codejava.Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.main.java.com.itu.Hello.codejava.Object.Connexion;
import src.main.java.com.itu.Hello.codejava.Object.Depense;
import src.main.java.com.itu.Hello.codejava.Object.Prevision;

public class NewDepense extends HttpServlet {
    public void doPost(HttpServletRequest req , HttpServletResponse res)
    throws ServletException ,IOException{
        int montant_depense=Integer.parseInt(req.getParameter("montant_depense"));
        int id_prevision =Integer.parseInt(req.getParameter("id_prevision"));
        Connexion connexion=new Connexion();
        try{
            Depense depense=new Depense(0, id_prevision, montant_depense);
            Prevision prevision=Prevision.GetPrevisionById(id_prevision,connexion.getConnection());
            int somme=Depense.sumDepense(connexion.getConnection(), id_prevision);
            int somme_Total=montant_depense+somme;
            if(prevision.getMontant_prevision() < somme_Total){
                System.out.println("Montant insuffisante");
            }else{
                depense.insert_Depense(connexion.getConnection());
            }
            res.sendRedirect("insertDepense.jsp");
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
