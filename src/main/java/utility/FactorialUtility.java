package utility;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FactorialUtility
{
    public static long computeFactorialInRange(int start, int end) {
        long factorial = 1;
        for (int i = start; i <= end; i++) {
            factorial *= i;
        }
        return factorial;
    }
}
