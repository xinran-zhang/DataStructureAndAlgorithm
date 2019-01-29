package grace.shuati;
import java.util.Iterator;
import java.util.*;

class NestedIterator implements Iterator<Integer> {
     public interface NestedInteger {
         public boolean isInteger();
         public Integer getInteger();
         public List<NestedInteger> getList();
     }

     Deque<Integer> intDeque;
     Deque<NestedInteger> deque;
    public NestedIterator(List<NestedInteger> nestedList) {
        intDeque = new ArrayDeque<>();
        deque = new ArrayDeque<>(nestedList);
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        if (!intDeque.isEmpty()) {
            return intDeque.pop();
        }
        if (deque.isEmpty()) {
            return null;
        }
        NestedInteger element = deque.pop();
        if (element.isInteger()) {
            return element.getInteger();
        } else {
            List<NestedInteger> list = element.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                deque.push(list.get(i));
            }
            return next();
        }
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        Integer ans = next();
        if (ans == null) {
            return false;
        }
        intDeque.push(ans);
        return true;
    }

    @Override
    public void remove() {}
}
