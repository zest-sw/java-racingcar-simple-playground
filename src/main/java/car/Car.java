package car;

import java.util.Random;

public class Car {
    private String name;
    private int position = 0;

    Random random = new Random();

    public Car(String CarName) {
        this.name = CarName;
    }

    public void moveCar(int inputValue){

        if (inputValue<0){
            throw new RuntimeException("자동차 이동 인자가 0보다 작습니다.");
        }
        if (inputValue>9){
            throw new RuntimeException("자동차 이동 인자가 9보다 큽니다.");
        }

        if (inputValue >= 4){
            position++;
        }
    }

    public void moveCarRandomly(){
        int randomValue = getRandomValue();
        moveCar(randomValue);
    }

    private int getRandomValue(){
        return random.nextInt(9);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String carName){
        this.name = carName;
    }

    public int getPosition(){
        return this.position;
    }



}
