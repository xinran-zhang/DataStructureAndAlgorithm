package grace.shuati;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return 2147483647
 */

// double divisor until it is greater than or equal to the dividend
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // check corner cases
        if (divisor == 0) {
            if (dividend >= 0) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        if (dividend == 0) {
            return 0;
        }
        // check if it will overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int result = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)) {
                shift++;
            }
            a -= (b << (shift - 1));
            result += (1 << (shift - 1));
        }
        if (isNegative) return -result;
        return result;
    }
}
