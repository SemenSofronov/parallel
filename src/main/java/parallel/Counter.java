package parallel;

import java.io.*;
import java.util.Scanner;

/**
 * @author sofronov
 * Created: 09.10.2019
 */
public class Counter {
    private Integer n;
    private final File file;

    public Counter(Integer n, File file) {
        this.n = n;
        this.file = file;
    }

    public void displayCounter(String threadName) {
        try {
            Integer line;
            Integer newValue;
            do {

                synchronized (file) {
                    Scanner scanner = new Scanner(file);
                    line = scanner.nextInt();

                    if (line >= n) {
                        break;
                    }

                    Integer previousValue = line;
                    newValue = previousValue + 1;

                    System.out.println("previous value : " + previousValue + " new value : " + newValue + " thread name : " + threadName);

                    FileWriter fw = new FileWriter(file, false);
                    fw.write(String.valueOf(newValue));
                    fw.flush();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            } while (true);


        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File does not exists!");
        }
    }
}
