package grace.shuati;
import java.util.*;
/**
 * Given an array S of n integers, are there elements a, b, c in S
 * such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */


public class ThreeSum {
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0 || numbers[i] != numbers[i - 1]) {
                int start = i + 1, end = numbers.length - 1;
                while (start < end) {
                    if (numbers[start] + numbers[end] == - numbers[i]) {
                        List<Integer> res = Arrays.asList(numbers[i], numbers[start], numbers[end]);
                        result.add(res);
                        while (start < end && numbers[start] == numbers[start + 1]) {
                            start++;
                        }
                        while (start < end && numbers[end] == numbers[end - 1]) {
                            end--;
                        }
                        start++;
                        end--;
                    }
                    else if (numbers[start] + numbers[end] > - numbers[i]) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }

}
