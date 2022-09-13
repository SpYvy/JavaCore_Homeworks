package homeworks.homework1;

public class Main {
    public static void main(String[] args) {
        Course course = new Course(150, 20, 100, 5);

        TeamMembers[] teamArr = new TeamMembers[4];

        teamArr[0] = new TeamMembers ("Енот", 150, 15, 200, 7);
        teamArr[1] = new TeamMembers ("Лисица", 180, 10, 120, 4);
        teamArr[2] = new TeamMembers ("Волк", 190, 12, 80, 5);
        teamArr[3] = new TeamMembers ("Заяц", 150, 15, 200, 6);

        Team team = new Team("Звери", teamArr);

        team.teamInfo();

        String results = course.doIt(team);

        System.out.println(results);
        System.out.println(course.getPassedMembers());
        }
    }