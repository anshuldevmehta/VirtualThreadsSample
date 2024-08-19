package vrt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static constants.Constants.*;

class PlatformVsVirtualThreadMiniPerformanceComparoTest {

    private final String HIGH_NUMBER_OF_FACTORIAL_TASKS ="20000000";
    private final String SMALL_NUMBER_OF_FACTORIAL_TASKS ="200";

    @BeforeEach
    void setUp() {
    }


    //@Test
    //@Order(1)
    void executeFactorialTasksPlatformOnlyUsingTenThreads() throws InterruptedException {
        PlatformVsVirtualThreadMiniPerformanceComparo.main(new String[]{HIGH_NUMBER_OF_FACTORIAL_TASKS,"10",PLATFORM});
    }


    //@Test
    //@Order(2)
    void executeFactorialTasksVirtualOnlyUsingTenThreads() throws InterruptedException {
        PlatformVsVirtualThreadMiniPerformanceComparo.main(new String[]{HIGH_NUMBER_OF_FACTORIAL_TASKS,"10",VIRTUAL});
   }

    @Test
    @Order(1)
    void executeHighNumberOfFactorialTasksPlatformAndVirtualUsingTwoThreads() throws InterruptedException {
        PlatformVsVirtualThreadMiniPerformanceComparo.main(new String[]{HIGH_NUMBER_OF_FACTORIAL_TASKS,"2",BOTH});
    }

    @Test
    @Order(2)
    void executeHighNumberOfFactorialTasksPlatformAndVirtualUsingTenThreads() throws InterruptedException {
        PlatformVsVirtualThreadMiniPerformanceComparo.main(new String[]{HIGH_NUMBER_OF_FACTORIAL_TASKS,"10",BOTH});
    }

    @Test
    @Order(3)
    void executeHighNumberOfFactorialTasksPlatformAndVirtualUsingHundredThreads() throws InterruptedException {
        PlatformVsVirtualThreadMiniPerformanceComparo.main(new String[]{HIGH_NUMBER_OF_FACTORIAL_TASKS,"100",BOTH});
    }

    @Test
    @Order(4)
    void executeHighNumberOfFactorialTasksPlatformAndVirtualUsingOneThousandThreads() throws InterruptedException {
        PlatformVsVirtualThreadMiniPerformanceComparo.main(new String[]{HIGH_NUMBER_OF_FACTORIAL_TASKS,"1000",BOTH});
    }

    @Test
    @Order(5)
    void executeHighNumberOfFactorialTasksPlatformAndVirtualUsingTenThousandThreads() throws InterruptedException {
        PlatformVsVirtualThreadMiniPerformanceComparo.main(new String[]{HIGH_NUMBER_OF_FACTORIAL_TASKS,"10000",BOTH});
    }


  //  @Test
  //  @Order(6)
    void executeLowNumberOfFactorialTasksPlatformAndVirtualUsingTwoThreads() throws InterruptedException {
        PlatformVsVirtualThreadMiniPerformanceComparo.main(new String[]{SMALL_NUMBER_OF_FACTORIAL_TASKS,"2",BOTH});
    }

   // @Test
   // @Order(7)
    void executeLowNumberOfFactorialTasksPlatformAndVirtualUsingTenThreads() throws InterruptedException {
        PlatformVsVirtualThreadMiniPerformanceComparo.main(new String[]{SMALL_NUMBER_OF_FACTORIAL_TASKS,"10",BOTH});
    }

   // @Test
  //  @Order(8)
    void executeLowNumberOfFactorialTasksPlatformAndVirtualUsingHundredThreads() throws InterruptedException {
        PlatformVsVirtualThreadMiniPerformanceComparo.main(new String[]{SMALL_NUMBER_OF_FACTORIAL_TASKS,"100",BOTH});
    }

   // @Test
   // @Order(9)
    void executeLowNumberOfFactorialTasksPlatformAndVirtualUsingOneThousandThreads() throws InterruptedException {
        PlatformVsVirtualThreadMiniPerformanceComparo.main(new String[]{SMALL_NUMBER_OF_FACTORIAL_TASKS,"1000",BOTH});
    }

    //@Test
   // @Order(10)
    void executeLowNumberOfFactorialTasksPlatformAndVirtualUsingTenThousandThreads() throws InterruptedException {
        PlatformVsVirtualThreadMiniPerformanceComparo.main(new String[]{SMALL_NUMBER_OF_FACTORIAL_TASKS,"10000",BOTH});
    }

}