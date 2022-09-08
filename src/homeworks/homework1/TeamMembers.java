package homeworks.homework1;

public class TeamMembers {
    private String name;
    private int height;
    private int speed;
    private int jumpHeight;
    private int gradeAtSchool;
    public TeamMembers(String name, int height, int speed, int jumpHeight, int gradeAtSchool) {
        this.name = name;
        this.height = height;
        this.speed = speed;
        this.jumpHeight = jumpHeight;
        this.gradeAtSchool = gradeAtSchool;
    }
    public String getName() {
        return name;
    }
    public int getHeight() {
        return height;
    }
    public int getSpeed() {
        return speed;
    }
    public int getJumpHeight() {
        return jumpHeight;
    }
    public int getGradeAtSchool() {
        return gradeAtSchool;
    }
}

