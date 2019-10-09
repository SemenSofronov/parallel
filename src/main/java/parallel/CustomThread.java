package parallel;

/**
 * @author sofronov
 * Created: 08.10.2019
 */
public class CustomThread extends Thread {
    private Thread thread;
    private String threadName;
    private Counter counter;

    CustomThread(String threadName, Counter counter) {
        this.threadName = threadName;
        this.counter = counter;
    }

    @Override
    public void start() {
        System.out.println("Thread " + threadName + " is started.");
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread " + threadName + " is running...");
        counter.displayCounter(threadName);
        System.out.println("Leaving " + threadName + " thread...");
    }

    public Thread getThread() {
        return thread;
    }
}
