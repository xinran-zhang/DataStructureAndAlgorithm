package grace.shuati;

/**
 * Implement double sqrt(double x) and x >= 0.
 * Compute and return the square root of x.
 */

public class SqrtxII {
    public double sqrt(double x) {
        if (x == 0) {
            return 0;
        }
        double start = 0;
        double end = x;
        if (x < 1) {
            end = 1;
        }
        while (start  + 1e-12 < end) {
            double mid = start + (end - start) / 2;
            if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end <= x / end) {
            return end;
        }
        return start;
    }
}
