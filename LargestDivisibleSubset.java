package grace.shuati;
import java.util.*;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> divisible = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            divisible.add(Arrays.asList(nums[i]));
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && divisible.get(j).size() + 1 > divisible.get(i).size()) {
                    divisible.set(i, new ArrayList<>(divisible.get(j)));
                    divisible.get(i).add(nums[i]);
                }
            }
        }
        int maxSize = 0;
        int index = 0;
        for (int i = 0; i < divisible.size(); i++) {
            if (divisible.get(i).size() > maxSize) {
                maxSize = divisible.get(i).size();
                index = i;
            }
        }
        return divisible.get(index);
    }

    public static void main(String[] args) {
        LargestDivisibleSubset subset = new LargestDivisibleSubset();
        subset.largestDivisibleSubset(new int[]{1, 2, 3});
    }
}
