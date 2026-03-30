package domain;

import java.util.Random;

public class Car {
    private String name;
    private int position;

    Random random = new Random();

    public Car(String CarName) {
        validateCarName(CarName);
        this.name = CarName;
    }

    private static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new RuntimeException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void moveCar(int inputValue) {

        if (inputValue < 0) {
            throw new IllegalArgumentException("자동차 이동 인자가 0보다 작습니다.");
        }
        if (inputValue > 9) {
            throw new IllegalArgumentException("자동차 이동 인자가 9보다 큽니다.");
        }

        if (inputValue >= 4) {
            position++;
        }
    }

    public void moveCarRandomly() {
        int randomValue = getRandomValue();
        moveCar(randomValue);
    }

    private int getRandomValue() {
        return random.nextInt(9);
    }

    public String getName() {
        return this.name;
    }
    
    public int getPosition() {
        return this.position;
    }


}
