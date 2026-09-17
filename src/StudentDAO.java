import java.sql.ResultSet;
import java.sql.PreparedStatement;
import  java.sql.SQLException;
import java.sql.Connection;

public class StudentDAO {

    //add student
    public void addStudent(String name,String email,String phone,String course,int semester,double marks){
        String sql="INSERT INTO students"+"(name,email,phone,course,semester,marks)"+"VALUES(?,?,?,?,?,?)";
        try(Connection con=DBConnection.getConnection();
    PreparedStatement pst=con.prepareStatement(sql)){
        pst.setString(1,name);
        pst.setString(2,email);
        pst.setString(3,phone);
        pst.setString(4,course);
        pst.setInt(5,semester);
        pst.setDouble(6,marks);
        int rows=pst.executeUpdate();
        if(rows>0){
            System.out.println("student added successfully!");
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    }
    //view all students
    public void getAllStudents(){
        String sql="SELECT*FROM students";
        try(Connection con=DBConnection.getConnection();
    PreparedStatement ps=con.prepareStatement(sql);
    ResultSet rs=ps.executeQuery()){
        while(rs.next()){
            System.out.println("ID: "+rs.getInt("id"));
            System.out.println("Name: "+rs.getString("name"));
            System.out.println("Email: "+rs.getString("email"));
            System.out.println("Phone:"+rs.getString("phone"));
            System.out.println("Course: "+rs.getString("course"));
            System.out.println("Semester: "+rs.getInt("semester"));
            System.out.println("Marks: "+rs.getDouble("marks"));
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    }
    //search student by id
    public void getStudentById(int id){
        String sql="SELECT *FROM students WHERE id=?";
        try(Connection con=DBConnection.getConnection();
    PreparedStatement ps=con.prepareStatement(sql)){
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
            if(rs.next()){
                System.out.println("/n---student details---");
                System.out.println("ID: "+rs.getInt("id"));
                System.out.println("Name:"+rs.getString("name"));
                System.out.println("Email: "+rs.getString("email"));
                System.out.println("Phone: "+rs.getString("phone"));
                System.out.println("Course: "+rs.getString("course"));
                System.out.println("Semester: "+rs.getInt("semester"));
                System.out.println("Marks: "+rs.getDouble("marks"));
            }else{
                System.out.println("no student found with ID: "+id);
            }
    }catch(SQLException e){
        System.out.println("unable to search for the student.");
        System.out.println("database error: "+e.getMessage());
    }
    }
    //update student
    public void updateStudent(String email,String phone,String course,int semester,double marks){
        String sql="UPDATE students SET"+"name=?, "+"email=?, "+"phone=?, "+"course=?, "+"semester=?, "+"marks=? "+"WHERE id=?";
        try(Connection con=DBConnection.getConnection();
    PreparedStatement pst=con.prepareStatement(sql)){
        pst.setString(1,email);
        pst.setString(2,phone);
        pst.setString(3,course);
        pst.setInt(4,semester);
        pst.setDouble(5,marks);
        
        int rows=pst.executeUpdate();
        if(rows>0){
            System.out.println("student updated successfully!");
        }else{
            System.out.println("no student found !");
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    }
    //delete student
    public void deleteStudent(String email){
        String sql="DELETE FROM student WHERE email=?";
        try(Connection con=DBConnection.getConnection();
    PreparedStatement pst=con.prepareStatement(sql)){
        pst.setString(1,email);
        int rows=pst.executeUpdate();
        if(rows>0){
            System.out.println("student deleted successfully!!");
        }else{
            System.out.println("student not found");
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
    }
}