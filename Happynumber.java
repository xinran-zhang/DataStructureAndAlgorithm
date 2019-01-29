package grace.shuati;
import java.util.*;

/**
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

 Example: 19 is a happy number

 12 + 92 = 82
 82 + 22 = 68
 62 + 82 = 100
 12 + 02 + 02 = 1
 *
 */

// Option 1: using recursion
public class Happynumber {
    // using the hashset to track if res has appeared
    Set<Integer> output = new HashSet<>();

    public boolean isHappy(int n) {
        int res = 0;
        List<Integer> digit = new ArrayList<>();
        while (n > 0) {
            digit.add(n % 10);
            n = n / 10;
        }
        for (int i : digit) {
            res = res + i * i;
        }
        if (res == 1) return true;
        if (output.contains(res)) return false;
        output.add(res);
        return isHappy(res);
    }


// Option 2

    public boolean isHappy2(int n) {
        Set<Integer> output = new HashSet<>();

        while (n != 1) {
            if (output.contains(helper(n))) return false;
            output.add(n);
            n = helper(n);
        }
        return true;
    }

    public int helper(int n) {
        int res = 0;

        while (n > 0) {
            res += (n % 10) * (n % 10);
            n = n / 10;
        }
        return res;
    }

}