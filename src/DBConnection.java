import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection(){
        Connection connection=null;
        try{
            String url = "jdbc:mysql://localhost:3306/student_management";
            String username="root";
            String password="MYSQL@1234";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection(url,username,password);
            System.out.println("database connected successfully!");
        }catch(Exception e){
            System.out.println("database connection failed!");
            e.printStackTrace();
        }
        return connection;
    }
    public static void main(String[]args){
        getConnection();
    }
}
