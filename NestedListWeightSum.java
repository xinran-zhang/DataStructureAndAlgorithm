package grace.shuati;
import java.util.*;

public class NestedListWeightSum {
    public interface NestedInteger {
       // @return true if this NestedInteger holds a single integer,
       // rather than a nested list.
       public boolean isInteger();
       // @return the single integer that this NestedInteger holds,
       // if it holds a single integer
       // Return null if this NestedInteger holds a nested list
       public Integer getInteger();

      // @return the nested list that this NestedInteger holds,
      // if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
    }
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            if (nestedList.get(i).isInteger()) {
                sum += nestedList.get(i).getInteger() * depth;
            } else {
                sum += helper(nestedList.get(i).getList(), depth + 1);
            }
        }
        return sum;
    }
}
