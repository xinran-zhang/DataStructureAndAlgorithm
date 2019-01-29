package grace.shuati;
import java.util.*;

public class RecoverSortedArray {
    public void recoverRotatedSortedArray(List<Integer> nums) {
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                reverse(0, i, nums);
                reverse(i + 1, nums.size() - 1, nums);
                reverse(0, nums.size() - 1, nums);
            }
        }
    }

    private void reverse(int start, int end, List<Integer> nums) {
        while (start < end) {
            int tmp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, tmp);
            start++;
            end--;
        }
    }
}
