import java.util.*;

public class CampusParkingChargeCalculator {
    static abstract class Vehicle {
        int hours;
        Vehicle(int h) { hours = h; }
        abstract double charge();
    }

    static class Bike extends Vehicle {
        Bike(int h) { super(h); }
        double charge() { return 10 * hours; }
    }

    static class Car extends Vehicle {
        Car(int h) { super(h); }
        double charge() { return 30 + 20 * (hours - 1); }
    }

    static class Truck extends Vehicle {
        Truck(int h) { super(h); }
        double charge() { return Math.max(100, 50 * hours); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            Vehicle vehicle;

            if (type.equals("BIKE")) vehicle = new Bike(hours);
            else if (type.equals("CAR")) vehicle = new Car(hours);
            else vehicle = new Truck(hours);

            double charge = vehicle.charge();
            total += charge;
            System.out.printf("%s: %.2f%n", type, charge);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}