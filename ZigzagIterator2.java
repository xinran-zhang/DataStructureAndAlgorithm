package grace.shuati;
import java.util.*;

public class ZigzagIterator2 {
    List<Iterator<Integer>> iterator;
    int turns;
    public ZigzagIterator2(List<List<Integer>> vecs) {
        turns = 0;
        iterator = new ArrayList<>();
        for (List<Integer> vec: vecs) {
            if (vec.size() > 0) {
                iterator.add(vec.iterator());
            }
        }
    }

    /*
     * @return: An integer
     */
    public int next() {
       int res = iterator.get(turns).next();
       if (iterator.get(turns).hasNext()) {
           turns = (turns + 1) % iterator.size();
       } else {
           iterator.remove(iterator.get(turns));
           if (iterator.size() > 0) {
               turns = turns % iterator.size();
           }
       }
       return res;
    }

    /*
     * @return: True if has next
     */
    public boolean hasNext() {
        return iterator.size() > 0;
    }
}
