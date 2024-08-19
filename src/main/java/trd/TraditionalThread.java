package trd;

/**
 * For those who have forgotten about old way of
 * writing threads, here is some nostalgia.
 */
public class TraditionalThread {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            int taskId = i;
            Thread thread = new Thread(() -> {
                System.out.println("Executing task " + taskId + " on native thread: " + Thread.currentThread().getName());
            });
            thread.start();
            thread.join();
        }
    }
}