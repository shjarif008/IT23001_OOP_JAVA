import java.io.*;
import java.util.*;
import java.text.*;

public class JarifGame {
    public static void main(String[] args) throws Exception {
        Scanner take = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String user = take.nextLine();

        System.out.println("Select a difficulty level: ");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");

        int difficulty = take.nextInt();
        int total = 0;
        if (difficulty == 1) {
            total = 5;
        } else if (difficulty == 2) {
            total = 10;
        } else if (difficulty == 3) {
            total = 15;
        } else {
            System.out.println("Invalid choice. Please restart the program.");
            System.exit(1);
        }

        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        StringBuilder content = new StringBuilder();
        int ch;
        while ((ch = reader.read()) != -1) {
            content.append((char) ch);
        }
        reader.close();

        String[] maths = content.toString().split(",");
        if (maths.length < total) {
            System.out.println("Not enough expressions in the file for the selected difficulty level.");
            System.exit(1);
        }

        int score = 0;
        for (int i = 0; i < total; i++) {
            String math = maths[i].trim();
            System.out.print("What is " + math + "? ");
            int ans1 = take.nextInt();

            try {
                int ans2 = fetch(math);
                if (ans1 == ans2) {
                    score++;
                }
            } catch (Exception e) {
                System.out.println("Error processing the expression: " + math);
                System.exit(1);
            }
        }

        System.out.println("\n" + user + ", your final score is: " + score + "/" + total);
        fileWriter(user, difficulty, score, total);
    }

    private static int fetch(String math) {
        char operator = ' ';
        int num1 = 0, num2 = 0;

        for (char c : math.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operator = c;
                String[] parts = math.split("\\" + operator);
                num1 = Integer.parseInt(parts[0].trim());
                num2 = Integer.parseInt(parts[1].trim());
                break;
            }
        }

        return switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> throw new IllegalArgumentException("Invalid operator in expression: " + math);
        };
    }

    private static void fileWriter(String user, int difficulty, int score, int total) throws Exception {
        SimpleDateFormat stuff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curDate = stuff.format(new Date());
        String record = user + ", " + fetch2(difficulty) + ", " + score + "/" + total + ", " + curDate + "\n";
        FileWriter writer = new FileWriter("output.txt", true);
        writer.write(record);
        writer.close();
    }

    private static String fetch2(int difficulty) {
        switch (difficulty) {
            case 1: return "Easy";
            case 2: return "Medium";
            case 3: return "Hard";
            default: return "Unknown";
        }
    }
}
