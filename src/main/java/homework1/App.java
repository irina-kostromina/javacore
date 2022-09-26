package homework1;

public class App {

    public static void main(String[] args) {
        Team team = new Team(new Participants("Participants1", 50), new Participants("Participants2", 100), new Participants("Participants3",80), new Participants("Participants4", 70));
        Course course = new Course(new Let[]{Let.RUN, Let.CRAWL, Let.RUN, Let.JUMP, Let.RUN});
        course.doIt(team);
        team.showTeamResultInfo();
    }
}
