
import java.util.Scanner;
public class Main{
    public static boolean isEmpty(String value){
        return value==null ||value.trim().isEmpty();
    }
    public static boolean isValidEmail(String email){
        return email.contains("@")&&email.contains(".");
    }
    public static boolean isValidPhone(String phone){
        return phone.matches("[0-9]{10}");
    }
        public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        StudentDAO studentDAO=new StudentDAO();
        while(true){
            System.out.println("/n==== STUDENT MANAGEMENT SYSTEM====");
            System.out.println("1.add student");
            System.out.println("2.view all students");
            System.out.println("3.search student by ID");
            System.out.println("4.update student ");
            System.out.println("5.delete student");
            System.out.println("6.exit");
            System.out.println("enter your choice: ");

            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    System.out.print("enter name: ");
                    String name=sc.nextLine();
                    while(isEmpty(name)){
                        System.out.println("name cannot be empty!");
                        System.out.print("enter name:");
                        name=sc.nextLine();
                    }
                    
                    System.out.print("enter email: ");
                    String email=sc.nextLine();
                    while(! isValidEmail(email)){
                        System.out.println("invalid email!please enter a valid email.");
                        System.out.println("enter email:");
                        email=sc.nextLine();
                    }

                    System.out.print("enter phone: ");
                    String phone=sc.nextLine();
                    while(!isValidPhone(phone)){
                        System.out.println("phone number must contain exactly 10 digits!");
                        System.out.println("enter phone:");
                        phone=sc.nextLine();
                    }

                    System.out.print("enter course: ");
                    String course=sc.nextLine();
                    while(isEmpty(course)){
                        System.out.println("course cannot be empty!");
                        System.out.println("enter course:");
                        course=sc.nextLine();
                    }

                    System.out.print("enter semester: ");
                    int semester=sc.nextInt();
                    while(semester<=0){
                        System.out.println("semester must be greater than 0!");
                        System.out.print("enter semester");
                        semester=sc.nextInt();
                    }
                
                    System.out.print("enter marks: ");
                    double marks=sc.nextDouble();
                    sc.nextLine();
                    while(marks<0||marks>100){
                        System.out.println("marks must be between 0 and 100.");
                        System.out.print("enter marks");
                        marks=sc.nextDouble();
                        sc.nextLine();
                    }
                    
                    studentDAO.addStudent(name,email,phone,course,semester,marks);
                    break;
                    case 2:
                        System.out.println("\n---all students---");
                        studentDAO.getAllStudents();
                        break;
                        case 3:
                            System.out.println("enter student id:");
                            int searchId=sc.nextInt();
                            sc.nextLine();

                            studentDAO.getStudentById(searchId);
                            break;
                        case 4:
                            System.out.println("----update student----");
                            System.out.println("student id");
                            int updateId=sc.nextInt();
                            sc.nextLine();
                            System.out.println("enter new name:");
                            String newName=sc.nextLine();
                            while(newName.trim().isEmpty()){
                                System.out.println("name cannot be empty!");
                                System.out.println("enter new name:");
                                newName=sc.nextLine();
                            }
                            System.out.println("enter new email:");
                            String newEmail=sc.nextLine();
                            while(!newEmail.matches("^A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
                                System.out.println("invalid email!");
                                System.out.println("enter new email:");
                                newEmail =sc.nextLine();
                            }
                            System.out.println("enter new phone");
                            String newPhone=sc.nextLine();
                            while(!newPhone.matches("\\d{10}")){
                                System.out.println("phone number must contain exactly 10 digits!");
                                System.out.println("enter new phone:");
                                newPhone=sc.nextLine();
                            }
                            System.out.println("enter new course:");
                            String newCourse=sc.nextLine();
                            while(newCourse.trim().isEmpty()){
                                System.out.println("course cannot be empty!");
                                System.out.println("enter new course:");
                                newCourse=sc.nextLine();
                            }
                            System.out.println("enter new semester:");
                            int newSemester=sc.nextInt();
                            while(newSemester<=0){
                                System.out.println("semester must be greater than 0!");
                                System.out.println("enter new semester:");
                                newSemester=sc.nextInt();
                            }
                            System.out.println("enter new marks");
                            double newMarks=sc.nextDouble();
                            sc.nextLine();
                            while(newMarks<0||newMarks>100){
                                System.out.println("marks must be between 0 and 100!");
                                System.out.println("enter new marks:");
                                newMarks=sc.nextDouble();
                                sc.nextLine();
                            }
                
                            studentDAO.updateStudent(newEmail, newPhone, newCourse, newSemester, newMarks);
                            break;
                        case 5:
                            System.out.println("enter student email to delete:");
                            String deleteEmail=sc.nextLine();
                            studentDAO.deleteStudent(deleteEmail);
                            break;
                        case 6:
                            System.out.println("thank you for using student management system!");
                            sc.close();
                            return;
                            
                            default:
                                System.out.println("invalid choice! please enter 1 to 6.");
                                break;
            }
        }
    }
}







