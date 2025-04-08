package src.main.java.com.itu.Hello.codejava.Object;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class User {
    int id_user;
    String name;
    String mail;
    String pasword;
    
    public User(int id_user, String name, String mail, String pasword) {
        this.id_user = id_user;
        this.name = name;
        this.mail = mail;
        this.pasword = pasword;
    }
    public int getId_user() {
        return id_user;
    }
    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPasword() {
        return pasword;
    }
    public void setPasword(String pasword) {
        this.pasword = pasword;
    }
    public void insert_user(Connection base_connection)throws Exception{
        String sql ="INSERT INTO user(user_name,user_mail,user_password) VALUES (?,?,?)";
        try(PreparedStatement statement = base_connection.prepareStatement(sql)){
                statement.setString(1,this.getName());
                statement.setString(2, this.getMail());
                statement.setString(3,this.getPasword());
                System.out.println("Utilisateur inserer dans la base ");
                statement.executeUpdate();
        }catch(Exception e){
            throw e;
        }
    }
    public static int verify_user(Connection base_Connection , String user_mail ,String user_password){
        User user =null ;
        String sql = "SELECT * FROM user WHERE user_mail = ? AND user_password = ?";
        try(PreparedStatement statement = base_Connection.prepareStatement(sql)){
            statement.setString(1, user_mail);
            statement.setString(2, user_password);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){ 
                user = new User(resultSet.getInt("id_user"), resultSet.getString("user_name"), resultSet.getString("user_mail"), resultSet.getString("user_password"));
                return user.getId_user();
            }else{
                return -1;
            }
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    }
    
}