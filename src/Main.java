public class Main {

    public static void main(String[] args) {
        Car car1 = new Car("A");
        Car car2 = new Car("B");
        Car car3 = new Car("C");

        Thread thread1 = new Thread(car1);
        Thread thread2 = new Thread(car2);
        Thread thread3 = new Thread(car3);

        System.out.println("Distance 100KM");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}