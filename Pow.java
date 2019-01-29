package grace.shuati;

/**
 * Implement pow(x, n).
 */

public class Pow {
    public double myPow(double x, int n) {
        return helper(x, (long) n);
    }

    private double helper(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = - n;
        }
        double pow = helper(x, n / 2);
        if (n % 2 == 0) {
            return pow * pow;
        }
        return pow * pow * x;
    }
}
