package grace.shuati;
import java.util.*;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 */

/*
     * @param number: An integer
     * @return: nothing
     */
public class TwoSumDataStructureDesign {
    private Map<Integer, Integer> hash = null;

    public TwoSumDataStructureDesign() {
        hash = new HashMap<>();
    }

    public void add(int number) {
        if (hash.containsKey(number)) {
            hash.put(number, hash.get(number) + 1);
        } else {
            hash.put(number, 1);
        }
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */

    public boolean find(int value) {
        for (int k: hash.keySet()) {
            if (hash.containsKey(value - k)) {
                if (value - k == k) {
                    return hash.get(k) > 1;
                }
                return true;
            }
        }

        return false;
    }
}
