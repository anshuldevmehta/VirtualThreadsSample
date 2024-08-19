package factory;

import static utility.FactorialUtility.computeFactorialInRange;

public class VirtualFactorial implements FactorialThread
{
    public void performFactorial(int n, int numThreads)
    {
        Thread[] threads = new Thread[numThreads];
        long[] result = new long[numThreads];
        // Divide task into subtasks for each thread
        int blockSize = n / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int start = i * blockSize + 1;
            int end = (i == numThreads - 1) ? n : (i + 1) * blockSize;
            int finalI = i;
            threads[i] = Thread.startVirtualThread(() -> {
                result[finalI] = computeFactorialInRange(start, end);
            });
        }
        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
