package grace.shuati;
import java.util.*;


public class RandomizedSet {
    // nums used to maintain all inserted numbers (excluding removed ones)
    // map used to track of the inserted val exists
    Map<Integer, Integer> map;
    List<Integer> nums;
    Random rand;
    public RandomizedSet() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }

    /*
     * @param val: a value to the set
     * @return: true if the set did not already contain the specified element or false
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /*
     * @param val: a value from the set
     * @return: true if the set contained the specified element or false
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int pos = map.get(val);
        // swap the last one with the removed one
        if (pos < nums.size() - 1) {
            int lastNum = nums.get(nums.size() - 1);
            nums.set(pos, lastNum);
            map.put(lastNum, pos);
        }
        nums.remove(nums.size() - 1);
        map.remove(val);
        return true;
    }

    /*
     * @return: Get a random element from the set
     */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
