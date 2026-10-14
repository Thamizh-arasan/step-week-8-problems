import java.time.LocalDate;
import java.util.*;

public class StreamingPlanRenewalReminder {
    static abstract class Plan {
        String name;
        LocalDate startDate;

        Plan(String name, LocalDate startDate) {
            this.name = name;
            this.startDate = startDate;
        }

        abstract int validityDays();

        LocalDate renewalDate() {
            return startDate.plusDays(validityDays());
        }
    }

    static class Basic extends Plan {
        Basic(String n, LocalDate d) { super(n, d); }
        int validityDays() { return 30; }
    }

    static class Standard extends Plan {
        Standard(String n, LocalDate d) { super(n, d); }
        int validityDays() { return 90; }
    }

    static class Premium extends Plan {
        Premium(String n, LocalDate d) { super(n, d); }
        int validityDays() { return 365; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());
            Plan plan;

            if (type.equals("BASIC")) plan = new Basic(name, date);
            else if (type.equals("STANDARD")) plan = new Standard(name, date);
            else plan = new Premium(name, date);

            System.out.println(name + ": " + plan.renewalDate());
        }
    }
}