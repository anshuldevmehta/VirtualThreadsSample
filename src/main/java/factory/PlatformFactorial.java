package factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static utility.FactorialUtility.computeFactorialInRange;

public class PlatformFactorial implements FactorialThread
{
    public void performFactorial(int n, int numThreads)
    {
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        long[] result = new long[numThreads];
        // Divide task into subtasks for each thread
        int blockSize = n / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int start = i * blockSize + 1;
            int end = (i == numThreads - 1) ? n : (i + 1) * blockSize;
            int finalI = i;
            executor.submit(() -> {
                result[finalI] = computeFactorialInRange(start, end);
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
