package grace.shuati;

/**
 * There is a building of n floors. If an egg drops from the k th floor or above,
 * it will break. If it's dropped from any floor below, it will not break.
 * You're given two eggs, Find k while minimize the number of drops for the worst case.
 * Return the number of drops in the worst case.
 */

public class DropEggs {
    public int dropEggs(int n) {
        long ans = 0;
        for (int i = 1; ; ++i) {
            ans += (long)i;
            if (ans >= (long)n)
                return i;
        }
    }
}
