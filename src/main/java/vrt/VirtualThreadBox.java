package vrt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class demonstrates the naive way of creating
 * virtual threads, not too different from platform threads
 * I guess.
 */
public class VirtualThreadBox
{
    public static void main(String[] args) {

        try(ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor())
        {
            executor.submit(() -> {
                System.out.println("Running task in a virtual thread: " + Thread.currentThread().getName());
            });

            executor.shutdown();
        }
    }
}
