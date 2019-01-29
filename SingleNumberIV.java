package grace.shuati;
import java.util.*;

public class SingleNumberIV {
    public int getSingleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if ((mid - start) % 2 == 1 && nums[mid] == nums[mid - 1]) {
                start = mid + 1;
            } else if ((mid - start) % 2 == 1 && nums[mid] == nums[mid + 1]) {
                end = mid - 1;
            } else if ((mid - start) % 2 == 0 && nums[mid] == nums[mid - 1]) {
                end = mid;
            } else if ((mid - start) % 2 == 0 && nums[mid] == nums[mid + 1]) {
                start = mid;
            } else if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]){
                return nums[mid];
            }
        }
        if (nums[start] == nums[end] || (start >= 1 && nums[start] == nums[start - 1])) {
            return nums[end];
        }
        return nums[start];
    }
}
