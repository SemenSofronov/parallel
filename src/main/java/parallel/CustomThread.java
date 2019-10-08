package parallel;

import java.io.*;

/**
 * @author sofronov
 * Created: 08.10.2019
 */
public class CustomThread extends Thread {
    private Thread t;
    private String threadName;
    private Integer result;

    CustomThread(String threadName, Integer result) {
        this.threadName = threadName;
        this.result = result;
    }

    @Override
    public void run() {
        if (t == null) {
            t = new Thread(this);
        }

        try {
            synchronized (this) {
                while()
                BufferedReader br = new BufferedReader(new FileReader("output.txt"));
                String line = br.readLine();

                FileWriter fw = new FileWriter("output.txt");
                Integer previousValue = Integer.valueOf(line);

                if (previousValue >= result) {
                    this.interrupt();
                }
                Integer newValue = previousValue + 1;

                System.out.println("previous value : " + previousValue + " new value : " + newValue + "thread name : " + threadName);
                fw.write(newValue);

                fw.flush();
                fw.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File does not exists!");
        }

    }
}
