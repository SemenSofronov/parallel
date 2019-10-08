package parallel;

import java.io.*;
import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            System.out.println("Input n");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            FileWriter fileWriter = new FileWriter("output.txt");
            fileWriter.write("0");
            fileWriter.flush();
            fileWriter.close();

            new CustomThread("thread1", n).start();
            new CustomThread("thread2", n).start();

            BufferedReader br = new BufferedReader(new FileReader("output.txt"));
            String line = br.readLine();
            System.out.println(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
