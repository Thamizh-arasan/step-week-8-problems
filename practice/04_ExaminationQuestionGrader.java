import java.util.*;

public class ExaminationQuestionGrader {
    static abstract class Question {
        String correct, student;
        double points;

        Question(String correct, String student, double points) {
            this.correct = correct;
            this.student = student;
            this.points = points;
        }

        abstract double grade();
    }

    static class MCQ extends Question {
        MCQ(String c, String s, double p) { super(c, s, p); }
        double grade() { return student.equalsIgnoreCase(correct) ? points : 0; }
    }

    static class TF extends Question {
        TF(String c, String s, double p) { super(c, s, p); }
        double grade() { return student.equalsIgnoreCase(correct) ? points : 0; }
    }

    static class Essay extends Question {
        Essay(String c, String s, double p) { super(c, s, p); }

        double grade() {
            String[] keywords = correct.split(",");
            int found = 0;
            String answer = student.toLowerCase();

            for (String keyword : keywords) {
                if (answer.contains(keyword.trim().toLowerCase())) found++;
            }

            if (found >= 2) return points * 0.75;
            if (found == 1) return points * 0.50;
            return 0;
        }
    }

    static String clean(String text) {
        return text.replace(""", "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] parts = line.split(""");
            String type = parts[0].trim();

            String correct = clean(parts[3].trim());
            String student = clean(parts[5].trim());
            double points = Double.parseDouble(parts[6].trim());

            Question q;
            if (type.equals("MCQ")) q = new MCQ(correct, student, points);
            else if (type.equals("TF")) q = new TF(correct, student, points);
            else q = new Essay(correct, student, points);

            double score = q.grade();
            total += score;
            System.out.printf("%s: %.2f%n", type, score);
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}