import java.util.*;

public class DeliveryFeeCalculator {
    static abstract class Delivery {
        double weight, distance;
        Delivery(double weight, double distance) {
            this.weight = weight;
            this.distance = distance;
        }
        abstract double calculateFee();
    }

    static class Standard extends Delivery {
        Standard(double w, double d) { super(w, d); }
        double calculateFee() { return 5 + 0.50 * weight + 0.10 * distance; }
    }

    static class Express extends Delivery {
        Express(double w, double d) { super(w, d); }
        double calculateFee() { return 15 + 1.00 * weight + 0.20 * distance; }
    }

    static class International extends Delivery {
        double customs;
        International(double w, double d, double c) {
            super(w, d); customs = c;
        }
        double calculateFee() { return 25 + 2.00 * weight + 0.50 * distance + customs; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double distance = sc.nextDouble();
            Delivery delivery;

            if (type.equals("STANDARD")) {
                delivery = new Standard(weight, distance);
            } else if (type.equals("EXPRESS")) {
                delivery = new Express(weight, distance);
            } else {
                delivery = new International(weight, distance, sc.nextDouble());
            }

            double fee = delivery.calculateFee();
            total += fee;
            System.out.printf("%s: %.2f%n", type, fee);
        }

        System.out.printf("Total: %.2f%n", total);
    }
}