package grace.shuati;

/**
 * Calculate the an % b where a, b and n are all 32bit integers.
 */

public class FastPower {
    public int fastPower(int a, int b, int n) {
        if (n == 0) {
            return 1 % b;
        }

        if (n == 1) {
            return a % b;
        }

        long tmp = fastPower(a, b, n / 2);
        tmp = ((tmp % b) * (tmp % b)) % b;
        if (n % 2 == 1) {
            tmp = (tmp * a) % b;
        }
        return (int) tmp;
    }
}
