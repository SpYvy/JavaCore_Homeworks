package homeworks.homework1;

public class Course {
    String result;
    public String passedMembers = "Прошли дистанцию:\n";
    private int minHeight;
    private int hundredMeterRunTime;
    private int highJump;
    private int difficultyLevel;

    public Course(int minHeight, int hundredMeterRunTime, int highJump, int difficultyLevel) {
        this.minHeight = minHeight;
        this.hundredMeterRunTime = hundredMeterRunTime;
        this.highJump = highJump;
        this.difficultyLevel = difficultyLevel;
    }
    public String getPassedMembers() {
        return passedMembers;
    }
    public String doIt (Team team) {
        result = "Команда " + team.getTeamName() + '\n';
        for (TeamMembers teamMembers : team.getMembers()) {
            result += "Участник: " + teamMembers.getName() + '\n';
            int height = teamMembers.getHeight();
            int speed = teamMembers.getSpeed();
            int jumpHeight = teamMembers.getJumpHeight();
            int gradeAtSchool = teamMembers.getGradeAtSchool();
            if ((testWaterPark(height)) && (testRun(speed)) && (testHighJump(jumpHeight)) && (mathTest(gradeAtSchool))) {
                result += "Участник успешно прошел дистанцию. \n";
                passedMembers += teamMembers.getName() +"\n";
            }
        }
        return result;
    }
    private boolean testWaterPark(int height){ // Допущен ли участник по росту на горку в аквапарке
        if(height >= minHeight){
            result += "Участник допущен на горку." + '\n';
            return true;
        } else {
            result += "Участник не допущен на горку по росту и не проходит дистанцию.\n" + "\n";
            return false;
        }
    }
    private boolean testRun(int speed){ // Смог ли участник пробежать 100 метров менее чем за время указанное в конструкторе в Main
        if((100/speed) <= hundredMeterRunTime){
            result += "Участник успешно пробежал стометровку за " + (100/speed) + " секунд." + '\n';
            return true;
        } else {
            result += "Участник не пробежал стометровку. Ему понадобилось " + (100/speed) + " секунд. Он не проходит дистанцию.\n" + "\n";
            return false;
        }
    }
    private boolean testHighJump(int jumpHeight){ // Смог ли участник прыгнуть выше препятствия
        if(jumpHeight > highJump){
            result += "Участник успешно перепрыгнул препятствие." + '\n';
            return true;
        } else {
            result += "Участник не смог перепрыгнуть препятствие и не проходит дистанцию.\n" + "\n";
            return false;
        }
    }
    private boolean mathTest(int gradeAtSchool){ // Если участник учится в 5 классе и выше в школе, он сможет сдать контрольную по математике
        if(gradeAtSchool >= difficultyLevel){
            result += "Участник справился с контрольной по математике." + '\n';
            return true;
        } else {
            result += "Участник списывал и дисквалифицирован. Он не проходит дистанцию.\n" + "\n";
            return false;
        }
    }
}