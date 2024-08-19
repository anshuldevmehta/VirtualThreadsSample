package vrt;

import factory.FactorialThreadFactory;
import org.apache.commons.lang3.StringUtils;

import static constants.Constants.*;

public class PlatformVsVirtualThreadMiniPerformanceComparo
{
    public static void main(String[] args) throws InterruptedException {

        int n=1000000000;
        int numThreads=1000;
        String threadMechanismToUse = BOTH;
        if(args.length==3) {
            n = (null != args[0] && StringUtils.isNumeric(args[0])) ? Integer.parseInt(args[0]) : n; // Number for which factorial is to be calculated
            numThreads = (null != args[1] && StringUtils.isNumeric(args[1])) ? Integer.parseInt(args[1]) : numThreads; // Number of threads
            threadMechanismToUse = StringUtils.isNotBlank(args[2]) ? args[2] : threadMechanismToUse;
        }

        System.out.println("Number Of Factorials To Perform For This Round Of Tests:"+n);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n\n");

        // Benchmark traditional threads
        switch (threadMechanismToUse) {

            case PLATFORM:
                long platformStartTime = System.currentTimeMillis();
                FactorialThreadFactory.getInstance().getThread(PLATFORM).performFactorial(n, numThreads);
                long platformEndTime = System.currentTimeMillis();
                long traditionalTime = platformEndTime - platformStartTime;
                System.out.println("Platform Threads Execution Time: " + traditionalTime + " ms using "+numThreads+ " threads");
                break;
            case VIRTUAL:
                long virtualStartTime = System.currentTimeMillis();
                FactorialThreadFactory.getInstance().getThread(VIRTUAL).performFactorial(n, numThreads);
                long virtualEndTime = System.currentTimeMillis();
                long virtualTime = virtualEndTime - virtualStartTime;
                System.out.println("Virtual Threads Execution Time: " + virtualTime + " ms using "+numThreads+ " threads");
                break;

            default:
                long startTime = System.currentTimeMillis();
                FactorialThreadFactory.getInstance().getThread(PLATFORM).performFactorial(n, numThreads);
                long endTime = System.currentTimeMillis();
                traditionalTime = endTime - startTime;
                // Benchmark virtual threads
                startTime = System.currentTimeMillis();
                FactorialThreadFactory.getInstance().getThread(VIRTUAL).performFactorial(n, numThreads);
                endTime = System.currentTimeMillis();
                virtualTime = endTime - startTime;
                // Print results
                System.out.println("Platform Threads Execution Time: " + traditionalTime + " ms using "+numThreads+ " threads");
                System.out.println("Virtual Threads Execution Time: " + virtualTime + " ms using "+numThreads+ " threads");
                System.out.println("Performance Difference: " + (traditionalTime - virtualTime) + " ms using "+numThreads+" threads\n\n");
        }
    }


 }


