package homework1;

public class Team {
    public String name;
    public String result;

    Participants [] participants = new Participants[4];

    public Team(Participants part1, Participants part2, Participants part3, Participants part4) {
        participants[0] = part1;
        participants[1] = part2;
        participants[2] = part3;
        participants[3] = part4;
    }

    public void showTeamResultInfo() {
        for (Participants participant : participants) {
            if (participant.result) {
                System.out.println("Участник: " + participant.name + ", результат: " + participant.result);
            }
        }
    }

    public void showTeamInfo() {
        for (Participants participant : participants) {
            System.out.println("Участник: " + participant.name);
        }
    }
}
