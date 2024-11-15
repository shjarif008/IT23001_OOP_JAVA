import java.util.*;
import java.io.*;

public class sum {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner take = new Scanner(new File("input.txt"));
        PrintWriter write = new PrintWriter(new File("output.txt"));

        while (take.hasNext()) {
            int n = take.nextInt();
            write.print((n * (n + 1)) / 2 + " ");
        }
        take.close();
        write.close();
    }
}