import java.util.*;

public class PublicTransportFareCalculator {
    static abstract class Transport {
        double distance;
        Transport(double distance) { this.distance = distance; }
        abstract double calculateFare();
    }

    static class Bus extends Transport {
        Bus(double d) { super(d); }
        double calculateFare() { return Math.min(10, 2 + 0.10 * distance); }
    }

    static class Train extends Transport {
        Train(double d) { super(d); }
        double calculateFare() { return 3 + 0.15 * distance; }
    }

    static class Metro extends Transport {
        double factor;
        Metro(double d, double f) { super(d); factor = f; }
        double calculateFare() { return (1.50 + 0.20 * distance) * factor; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            Transport transport;

            if (type.equals("BUS")) transport = new Bus(distance);
            else if (type.equals("TRAIN")) transport = new Train(distance);
            else transport = new Metro(distance, sc.nextDouble());

            double fare = transport.calculateFare();
            total += fare;
            System.out.printf("%s: %.2f%n", type, fare);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}