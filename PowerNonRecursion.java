package grace.shuati;

public class PowerNonRecursion {
    public int power(int x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        int ans = 1, base = x;

        while (n > 0) {
            if (n % 2 == 1) {
                ans *= base;
            }
            base = base * base;
            n = n / 2;
        }
        return ans;
    }
}
