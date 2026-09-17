public class Student {
    private int id;
    private String name;
    private String email;
    private String phone;
    private String course;
    private int semester;
    private double marks;
//CONSTRUCTOR FOR ADD STUDENT
    public Student(int id,String name,String email,String phone,String course,int semester,
        double marks){
            this.id=id;
            this.name=name;
            this.email=email;
            this.phone=phone;
            this.course=course;
            this.semester=semester;
            this.marks=marks;
        }
        
        //GET STUDENT ID
        public int getId(){
            return id;
        }
        //GET NAME
        public String getName(){
            return name;
        }
        //GET EMAIL
        public String getEmail(){
            return email;
        }
        //GET PHONE
        public String getPhone(){
            return phone;
        }
        //GET COURSE
        public String getCourse(){
            return course;
        }
        //GET SEMESTER
        public int getSemester(){
            return semester;
        }
        //GET MARKS
        public double getMarks(){
            return marks;
        }
    }
