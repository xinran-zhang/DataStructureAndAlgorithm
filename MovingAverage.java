package grace.shuati;
import java.util.*;

public class MovingAverage{
    // use queue, first in first out -> sliding window
    int size;
    double sum;
    Queue<Integer> queue;
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
        this.sum = 0;
    }


    public double next(int val) {
        if (queue.size() < size) {
            queue.offer(val);
            sum += val;
        } else if (queue.size() == size){
            int dropVal = queue.poll();
            queue.offer(val);
            sum = sum - dropVal + val;
        }
        return sum / queue.size();
    }
}
