package grace.shuati;
import java.util.*;

public class PreviousPermutation {
    public List<Integer> previousPermuation(List<Integer> nums) {
        // (start from end)find the number that is greater than its previous number -> nums.get(n)
        if (nums.size() <= 1) {
            return nums;
        }
        int n = nums.size() - 1;
        while (n >= 1 && nums.get(n) >= nums.get(n - 1)) {
            n--;
        }
        reverse(nums, n, nums.size() - 1);
        // find a number that is smaller than nums.get(n - 1) from n to nums.size - 1
        if (n >= 1) {
            int smallerIndex = n;
            while (nums.get(smallerIndex) >= nums.get(n - 1)) {
                smallerIndex++;
            }
            swap(nums, n - 1, smallerIndex);
        }
        return nums;
    }

    private void swap(List<Integer> nums, int start, int end) {
        int tmp = nums.get(start);
        nums.set(start, nums.get(end));
        nums.set(end, tmp);
    }

    private void reverse(List<Integer> nums, int start, int end) {
        if (start > end) return;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}
