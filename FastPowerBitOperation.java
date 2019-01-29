package grace.shuati;


public class FastPowerBitOperation {
    public int fastPower(int a, int b, int n) {
        if (n == 0) {
            return 1 % b;
        }
        if (n == 1) {
            return a % b;
        }

        long res = 1;
        long tmp = a;

        while (n > 0) {
            if ((n & 1) == 1) {
                res = ((res % b) * (tmp % b)) % b;
            }
            tmp = (tmp  * tmp) % b;
            n = n >> 1;
        }
        return (int)res % b;
    }
}
