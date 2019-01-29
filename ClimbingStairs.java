package grace.shuati;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int last = 1, lastLast = 1;
        int cur = 0;
        for (int i = 2; i <=n; i++) {
            cur = last + lastLast;
            lastLast = last;
            last = cur;
        }
        return cur;
    }
}
