package grace.shuati;
import java.util.*;

public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> i;
    Iterator<Integer> j;
    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
        j = null;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return j.next();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext()) {
            j = i.next().iterator();
        }
        return j != null && j.hasNext();
    }

    @Override
    public void remove() {}
}
