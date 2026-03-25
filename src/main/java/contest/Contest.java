package contest;

import car.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Contest {
    private List<Car> participants = new ArrayList<>();
    private int attempt;
    private List<String> winners;

    public Contest(String[] names,int attempt){
        for (String name : names){
            participants.add(new Car(name));
        }
        this.attempt = attempt;
    }

    void startContest(){
        for(int i=0;i<attempt;i++){
            this.attemptOnce();
        }

        this.winners = findWinners(this.participants);


    }

    private void attemptOnce(){
        for (Car participant:participants){
            participant.moveCarRandomly();
        }
    }

    private List<String> findWinners(List<Car> participants){
        int maxPosition = participants.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();

        return participants.stream()
                .filter(participant -> participant.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void setParticipants(ArrayList<Car> participants){
        this.participants = participants;
    }

    public String[] getParticipantsName(){
        String[] names = new String[this.participants.size()];

        for (int i = 0; i < this.participants.size(); i++) {
            names[i] = this.participants.get(i).getName();
        }

        return names;
    }

    public List<String> getWinners(){
        return this.winners;
    }


}
