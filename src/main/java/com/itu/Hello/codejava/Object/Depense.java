package src.main.java.com.itu.Hello.codejava.Object;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Depense {
    int id_depense;
    int id_prevision;
    int montant_depense;
    public Depense(int id_depense, int id_prevision, int montant_depense) {
        this.id_depense = id_depense;
        this.id_prevision = id_prevision;
        this.montant_depense = montant_depense;
    }
    public int getId_depense() {
        return id_depense;
    }
    public void setId_depense(int id_depense) {
        this.id_depense = id_depense;
    }
    public int getId_prevision() {
        return id_prevision;
    }
    public void setId_prevision(int id_prevision) {
        this.id_prevision = id_prevision;
    }
    public int getMontant_depense() {
        return montant_depense;
    }
    public void setMontant_depense(int montant_depense) {
        this.montant_depense = montant_depense;
    }
    public void insert_Depense(Connection base_connection)throws Exception{
        String sql ="INSERT INTO depense (id_prevision,montant_depense) VALUES(?,?)";
        try(PreparedStatement statement=base_connection.prepareStatement(sql)){
            statement.setInt(1, this.getId_prevision());
            statement.setInt(2, this.getMontant_depense());
            System.out.println("Depense Inserer avec succes");
            statement.executeUpdate();
        }catch(Exception e){
            throw e;
        }
    }
    public static  int sumDepense(Connection base_connection,int id_prevision){
        String sql="SELECT SUM(montant_depense) as somme  FROM depense WHERE id_prevision=?";
        int somme=0;
        try(PreparedStatement statement =base_connection.prepareStatement(sql)){
            statement.setInt(1, id_prevision);
            ResultSet resultSet=statement.executeQuery();
            if(resultSet.next()) {
                somme=resultSet.getInt("somme");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return somme;
    }
}
