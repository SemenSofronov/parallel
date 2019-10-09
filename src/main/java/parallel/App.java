package parallel;

import java.io.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int n = 0;

        File file = new File("out.txt");
        try {
            System.out.println("Input n");
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();

            FileWriter fileWriter = new FileWriter(file, false);
            String str = "0";
            fileWriter.write(str);
            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Counter counter = new Counter(n, file);

        CustomThread thread1 = new CustomThread("thread1", counter);
        CustomThread thread2 = new CustomThread("thread2", counter);

        thread1.start();
        thread2.start();

        try {
            thread1.getThread().join();
            thread2.getThread().join();
            Scanner scanner = new Scanner(file);
            System.out.println(scanner.nextInt());
        } catch (InterruptedException e) {
            System.out.println("Threads interrupted.");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
