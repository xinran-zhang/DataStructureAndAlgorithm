package grace.shuati;

// bit manipulation
public class PowBitOperation {
    public double myPow(double x, int n) {
        return pow(x, (long) n);
    }

    private double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            x = 1 / x;
            n = - n;
        }

        double res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x;
            }
            x *= x;
            n = n >> 1;
        }
        return res;
    }
}
