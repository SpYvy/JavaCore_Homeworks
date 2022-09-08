package homeworks.homework1;

public class Team {
    String teamName;
    private TeamMembers[] teamMembers;
    public Team(String teamName, TeamMembers[] members) {
        this.teamName = teamName;
        this.teamMembers = members;
    }
    public String getTeamName() {
        return teamName;
    }
    public TeamMembers[] getMembers(){
        return teamMembers;
    }
    public void teamInfo(){
        System.out.println("Участники команды " + teamName + ":");
        for (int i = 0; i < teamMembers.length; i++){
            System.out.println("Вид: " + teamMembers[i].getName() + "; Рост: " + teamMembers[i].getHeight() + "см; " +
                    "Скорость " + teamMembers[i].getSpeed() + "м/с; " + "Высота прыжка: " + teamMembers[i].getJumpHeight() + "см; " +
                    "Класс в школе: " + teamMembers[i].getGradeAtSchool() + ".");
        }
    }
}