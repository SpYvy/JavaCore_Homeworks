package homeworks.homework9;

import java.util.*;

import static homeworks.homework9.Course.courseNames;
import static homeworks.homework9.Student.getStudentsByCourse;

public class Main {
    static ArrayList<Course> coursesList = new ArrayList<>();

    public static void main(String[] args) { // Заполняю coursesList из массива courseNames
        for (String str : courseNames) {
            Course course = new Course(str);
            coursesList.add(course);
        }
        List<Student> studentList = getListOfStudents(100);  // Получить список студентов

        List<Course> courseDistinct = studentList.stream()                // Получить уникальные курсы студентов
                .flatMap(student -> student.getStudentCourses().stream())
                .distinct()
                .toList();
        System.out.println(courseDistinct.toString().replace("[", "").replace("]", ""));

        System.out.println("\n*********************************************************");

        List<Student> mostInquisitive = studentList.stream()               // Получить список самых любознательных
                .sorted((student1, student2) -> student2.getStudentCourses().size() - student1.getStudentCourses().size())
                .limit(3)
                .toList();
        System.out.println(mostInquisitive.toString().replace("[", "").replace("]", ""));

        System.out.println("\n*********************************************************");

        System.out.println(
                getStudentsByCourse(studentList, coursesList.get(12)) // Все студенты изучающие парапсихологию
        );
    }
    private static List<Student> getListOfStudents(int studentsQuantity) {
        Random random = new Random();
        ArrayList<Student> resultList = new ArrayList<>();
        for (int i = 0; i < studentsQuantity; i++) {        // Создаю студентов
            ArrayList<Course> courses = new ArrayList<>();
            for (int h = 0; h < coursesList.size(); h++) {  // Каждому студенту раздаю курсы
                if (random.nextInt(100) < 20) {       // C 20% шансом присваиваю курс студенту
                    courses.add(coursesList.get(h));
                }
            }
            if (courses.size() == 0) i--; // Если студент не получил курс, цикл проходит еще раз
            else resultList.add(new Student("Student" + i, courses));
        }
        return resultList;
    }
}
