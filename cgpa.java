import java.util.Scanner;

public class cgpa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ID: ");
        String id = sc.nextLine();

        System.out.print("No. of Courses: ");
        int n = sc.nextInt();
        
        int c = 0, m = 0, max = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("C" + i + ":");

            System.out.print("Credit (Max 3): ");
            int cr = sc.nextInt();
            c += cr;

            System.out.print("CT (Max 30): ");
            int ct = sc.nextInt();

            System.out.print("AT (Max 10): ");
            int at = sc.nextInt();

            System.out.print("FE (Max 60): ");
            int fe = sc.nextInt();

            m += (ct + at + fe);
            max += 100;
        }

        double cgpa = (m / (double) max) * 4;
        String grade = g(cgpa);

        System.out.println("\nID: " + id);
        System.out.println("Credits: " + c);
        System.out.println("CGPA: " + String.format("%.2f", cgpa));
        System.out.println("Grade: " + grade);
    }

    public static String g(double cgpa) {
        if (cgpa >= 3.7) return "A+";
        if (cgpa >= 3.3) return "A";
        if (cgpa >= 3.0) return "A-";
        if (cgpa >= 2.7) return "B+";
        if (cgpa >= 2.3) return "B";
        if (cgpa >= 2.0) return "B-";
        return "C";
    }
}
