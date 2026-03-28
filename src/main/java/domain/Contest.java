package domain;

import java.util.ArrayList;
import java.util.List;

public class Contest {
    private List<Car> participants = new ArrayList<>();
    private int attempt;
    private String[] winners;

    public Contest(String[] names, int attempt) {
        for (String name : names) {
            participants.add(new Car(name));
        }
        this.attempt = attempt;
    }

    public void startContest() {
        for (int i = 0; i < attempt; i++) {
            this.attemptOnce();
        }

        this.winners = findWinners(this.participants);
    }

    public void attemptOnce() {
        for (Car participant : participants) {
            participant.moveCarRandomly();
        }
        printResult();
    }

    private String[] findWinners(List<Car> participants) {
        int maxPosition = participants.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();

        return participants.stream()
                .filter(participant -> participant.getPosition() == maxPosition)
                .map(Car::getName)
                .toArray(String[]::new);
    }

    public void setParticipants(ArrayList<Car> participants) {
        this.participants = participants;
    }

    public String[] getParticipantsName() {
        String[] names = new String[this.participants.size()];

        for (int i = 0; i < this.participants.size(); i++) {
            names[i] = this.participants.get(i).getName();
        }

        return names;
    }

    public List<Car> getParticipants() {
        return this.participants;
    }

    public String[] getWinners() {
        return this.winners;
    }

    private void printResult() {
        for (Car participant : participants) {
            String name = participant.getName();
            System.out.print(name + " : ");
            printStatus(participant);
        }
        System.out.println();
    }

    private void printStatus(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
