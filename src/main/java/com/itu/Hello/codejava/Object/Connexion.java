package src.main.java.com.itu.Hello.codejava.Object; // Package corrigé

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    public Connection getConnection() { // Méthode renommée pour respecter les conventions Java
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/db_s2_ETU003229?useSSL=false&allowPublicKeyRetrieval=true"; // URL corrigée
        String user = "ETU003229";
        String password = "yQeWaFrL";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Chargement du pilote MySQL
            connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Connexion réussie à la base de données");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur : pilote JDBC MySQL non trouvé.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur : connexion à la base de données échouée.");
            e.printStackTrace();
        }
        return connection;
    }

    // Méthode main pour tester (optionnelle)
    public static void main(String[] args) {
        Connexion connexion = new Connexion();
        Connection conn = connexion.getConnection();
        if (conn != null) {
            try {
                conn.close(); // Fermeture manuelle pour ce test
                System.out.println("Connexion fermée.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}