package grace.shuati;

public class FirstBadVersion {
    public int findFirstBadVersion(int n) {
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid) == false) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (isBadVersion(start) == true) {
            return start;
        }
        return end;
    }


    private boolean isBadVersion(int  n) {
        return true;
    }
}
