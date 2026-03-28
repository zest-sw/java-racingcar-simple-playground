package utils;

import domain.Car;

import java.util.List;

public class ContestIOManager {

    private void printStatus(Car car) {
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printResult(List<Car> participants) {
        for (Car participant : participants) {
            String name = participant.getName();
            System.out.print(name + " : ");
            printStatus(participant);
        }
        System.out.println();
    }

    public void printStart() {
        System.out.println("실행 결과");
    }

}
