package grace.shuati;

public class Sqrtx {
    public int sqrt(int x) {
        if (x == 0) {
            return 0;
        }

        int start = 0, end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end  == x / end) {
            return end;
        }
        return start;
    }
}
