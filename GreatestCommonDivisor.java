package grace.shuati;

public class GreatestCommonDivisor {
    public int gcd(int big, int small) {
        if (small != 0) {
            return gcd(small, big % small);
        }
        return big;
    }
}
