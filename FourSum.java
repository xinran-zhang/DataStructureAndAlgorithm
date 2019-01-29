package grace.shuati;
import java.util.*;
import java.util.function.IntToDoubleFunction;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 */

// two for loop
// point is how to avoid duplicate
public class FourSum {
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (numbers == null || numbers.length <= 3) {
            return res;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 3; i++) {
            // avoid duplicate in a
            if (i != 0 && numbers[i] == numbers[i - 1]) continue;
            for (int j = i + 1; j < numbers.length - 2; j++) {
                // avoid duplicate in b
                if (j != i + 1 && numbers[j] == numbers[j - 1]) continue;
                int start = j + 1, end = numbers.length - 1;
                while (start < end) {
                    if (numbers[i] + numbers[j] + numbers[start] + numbers[end] == target) {
                        List<Integer> fourSum = new ArrayList<>(Arrays.asList(numbers[i], numbers[j], numbers[start], numbers[end]));
                        res.add(fourSum);
                        start++;
                        end--;
                        // avoid duplicate in c and d
                        while (start < end && numbers[start] == numbers[start - 1]) {
                            start++;
                        }
                        while (start < end && numbers[end] == numbers[end + 1]) {
                            end--;
                        }
                    } else if (numbers[i] + numbers[j] + numbers[start] + numbers[end] > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }

        return res;
    }
}
