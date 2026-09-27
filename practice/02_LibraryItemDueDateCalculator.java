import java.time.LocalDate;
import java.util.*;

public class LibraryItemDueDateCalculator {
    static abstract class LibraryItem {
        String title;
        LibraryItem(String title) { this.title = title; }
        abstract int getBorrowDays();
        LocalDate getDueDate() { return LocalDate.of(2023, 10, 26).plusDays(getBorrowDays()); }
    }

    static class Book extends LibraryItem {
        Book(String title) { super(title); }
        int getBorrowDays() { return 14; }
    }

    static class DVD extends LibraryItem {
        DVD(String title) { super(title); }
        int getBorrowDays() { return 7; }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) { super(title); }
        int getBorrowDays() { return 3; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(" ", 2);
            String type = parts[0];
            String title = parts[1].replace(""", "");
            LibraryItem item;

            if (type.equals("BOOK")) item = new Book(title);
            else if (type.equals("DVD")) item = new DVD(title);
            else item = new Magazine(title);

            System.out.println(item.title + ": " + item.getDueDate());
        }
    }
}