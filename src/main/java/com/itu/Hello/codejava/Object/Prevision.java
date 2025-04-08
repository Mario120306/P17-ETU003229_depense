package src.main.java.com.itu.Hello.codejava.Object;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Prevision {
    int id_prevision;
    String libelle;
    int montant_prevision;

    public Prevision(int id_prevision, String libelle, int montant_prevision) {
        this.id_prevision = id_prevision;
        this.libelle = libelle;
        this.montant_prevision = montant_prevision;
    }
    public int getId_prevision() {
        return id_prevision;
    }
    public void setId_prevision(int id_prevision) {
        this.id_prevision = id_prevision;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public int getMontant_prevision() {
        return montant_prevision;
    }
    public void setMontant_prevision(int montant_prevision) {
        this.montant_prevision = montant_prevision;
    }
    public void insert_Prevision(Connection base_connection) throws Exception{
        String sql="INSERT INTO prevision(libelle,montant_prevision) VALUES(?,?) ";
        try(PreparedStatement statement=base_connection.prepareStatement(sql)){
            statement.setString(1, this.getLibelle());
            statement.setInt(2, this.getMontant_prevision());
            System.out.println("Prevision inserer dans la base ");
            statement.executeUpdate();
        }catch(Exception e){
            throw e;
        }  
    }
    public  static List<Prevision> getAllprevision(Connection base_connection){
        List<Prevision> prevList=new ArrayList<>();
        String sql ="SELECT * FROM prevision";
        try(PreparedStatement statement=base_connection.prepareStatement(sql)){
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                int id_prevision = resultSet.getInt("id_prevision");
                String libelle =resultSet.getString("libelle");
                int montant_prevision=resultSet.getInt("montant_prevision");
                Prevision prevision=new Prevision(id_prevision, libelle, montant_prevision);
                prevList.add(prevision);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return prevList;
    }
     public static Prevision GetPrevisionById(int id,Connection base_connection){
        Prevision prevision =null;
        String sql ="SELECT * FROM  prevision WHERE id_prevision=?";
        try(PreparedStatement statement=base_connection.prepareStatement(sql)){
            statement.setInt(1, id);
            ResultSet resultSet=statement.executeQuery();
            while (resultSet.next()) {
                int id_prevision=resultSet.getInt("id_prevision");
                String libelle=resultSet.getString("libelle");
                int montant_prevision=resultSet.getInt("montant_prevision");
                prevision=new Prevision(id_prevision, libelle, montant_prevision);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return prevision;
    }
}
