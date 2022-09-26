package homework1;

public class Course {

    private Let[] exercises;

    public Course(Let[] ex) {
        exercises = ex;
    }

    public void doIt(Team team) {
        for (Participants p : team.participants) {
            for (Let l : exercises) {
                reducePower(p,l);
                if (p.power > 0) {
                    p.result = true;
                }
            }
        }
    }

    private void reducePower(Participants p, Let l) {
        switch (l) {
            case RUN:
                p.power -= 30;
                break;
            case CRAWL:
                p.power -= 10;
                break;
            case JUMP:
                p.power -= 20;
                break;
        }
    }
}
