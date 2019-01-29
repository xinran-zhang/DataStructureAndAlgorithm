package grace.shuati;

public class Decodeways {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        int[] memo = new int[len + 1];
        memo[0] = 1;
        memo[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) != '0') memo[i] = memo[i - 1];
            int tmp = Integer.valueOf(s.substring(i - 2, i));
            if (tmp <=26 && tmp >=10) memo[i] += memo[i - 2];
        }
        return memo[len];
    }
}
