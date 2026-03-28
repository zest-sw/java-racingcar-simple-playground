package domain;

import utils.ContestIOManager;
import utils.applicationIOMangager.UserInput;

import java.util.ArrayList;
import java.util.List;

public class Contest {
    private List<Car> participants = new ArrayList<>();
    private int attempt;
    private String[] winners;
    private ContestIOManager iOManager = new ContestIOManager();

    public Contest(UserInput userInput) {

        String[] names = userInput.getParticipants();

        for (String name : names) {
            participants.add(new Car(name));
        }
        this.attempt = userInput.getAttempt();
    }

    public void startContest() {
        iOManager.printStart();
        for (int i = 0; i < attempt; i++) {
            this.attemptOnce();
        }

        this.winners = findWinners(this.participants);
    }

    public void attemptOnce() {
        for (Car participant : participants) {
            participant.moveCarRandomly();
        }
        iOManager.printResult(participants);
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

    public String[] getParticipantsName() {
        String[] names = new String[this.participants.size()];

        for (int i = 0; i < this.participants.size(); i++) {
            names[i] = this.participants.get(i).getName();
        }

        return names;
    }

    public String[] getWinners() {
        return this.winners;
    }


}
