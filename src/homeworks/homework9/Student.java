package homeworks.homework9;
import java.util.List;

public class Student {
    private String name;
    List<Course> courses;
    public Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    @Override
    public String toString() {
        return ("\nСтудент " + name + " учится на курсах: " + courses.toString().replace("[", "").replace("]", ""));
    }
    public static List<Student> getStudentsByCourse(List<Student> std, Course crs){
        List<Student> students = std.stream()
                .filter(student -> student.getStudentCourses().contains(crs))
                .toList();
        return students;
    }

    private String getName() {
        return name;
    }
    
    List<Course> getStudentCourses(){
        return courses;
    };
}

