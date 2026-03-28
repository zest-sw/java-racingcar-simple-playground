package utils.applicationIOMangager;

public class UserInput {
    private String[] participants;
    private int attempt;

    public void setParticipants(String[] participants) {
        this.participants = participants;
    }

    public String[] getParticipants() {
        return participants;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public int getAttempt() {
        return attempt;
    }
}
