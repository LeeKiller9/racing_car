import java.util.Map;
import java.util.Random;

public class Car implements Runnable {
    private String nameCar;
    public static int DISTANCE = 100;

    public static int STEP = 2;

    public Car(String nameCar) {
        this.nameCar = nameCar;
    }

    @Override
    public void run() {
        int runDistance = 0;

        int speed;
        long startTime = System.currentTimeMillis();
        while (runDistance < DISTANCE) {
            try {
                speed = (new Random()).nextInt(20);
                runDistance += speed;
                String log = "|";
                int percentRace = (runDistance * 100) / DISTANCE;
                for (int i = 0; i < DISTANCE; i++) {
                    if (percentRace >= i + STEP) {
                        log += "=";
                    } else if (percentRace >= i && percentRace < i + STEP) {
                        log += "o";
                    } else {
                        log += "-";
                    }
                }
                log += "|";
                System.out.println("\nCar " + this.nameCar + ": " + log + " - " + Math.min(DISTANCE, runDistance) + " KM");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Car " + this.nameCar + " broken.");
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Car " + this.nameCar + " Finish in " + (endTime - startTime) / 1000 + "s");
    }
}
