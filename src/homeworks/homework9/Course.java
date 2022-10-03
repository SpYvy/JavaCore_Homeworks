package homeworks.homework9;

public class Course {
    private String courseName;
    public Course(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return (courseName);
    }
    static String[] courseNames = {
            "Математика", "Астрология", "Алхимия", "Уфология", "Фотография", "Музыка", "Квантовая физика", "Теология", "История", "Химия", "Биология",
            "Лингвистика", "Парапсихология", "Психология", "Робототехника"
    };
}
