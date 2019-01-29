package grace.shuati;
import java.util.*;

public class FirstUniqueNumberInStream {
    public int firstUniqueNumber(int[] nums, int number) {
        boolean terminate = false;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> uniqueNums = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (uniqueNums.contains(nums[i])) {
                    uniqueNums.remove(uniqueNums.indexOf(nums[i]));
                }
            } else {
                map.put(nums[i], 1);
                uniqueNums.add(nums[i]);
            }
            if (nums[i] == number) {
                terminate = true;
                break;
            }
        }
        if (uniqueNums.size() == 0 || !terminate) {
            return -1;
        }
        return uniqueNums.get(0);
    }
}
