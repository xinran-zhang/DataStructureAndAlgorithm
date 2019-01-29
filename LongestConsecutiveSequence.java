package grace.shuati;
import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        Set<Integer> nums = new HashSet<>();
        for (int i = 0; i < num.length; i++) {
            nums.add(num[i]);
        }
        int longest = 0;
        for (int i = 0; i < num.length; i++) {
            int lowerBound = num[i] - 1;
            while (nums.contains(lowerBound)) {
                // avoid memory limit exceed
                nums.remove(lowerBound);
                lowerBound--;
            }
            int upperBound = num[i] + 1;
            while (nums.contains(upperBound)) {
                nums.remove(upperBound);
                upperBound++;
            }
            longest = Math.max(longest, upperBound - lowerBound - 1);
        }
        return longest;
    }
}
