package grace.shuati;

import java.util.ArrayList;
import java.util.List;

/**
 * Giving a string with number from 1-n in random order, but miss 1 number.Find that number.
 */


public class FindTheMissingNumberII {
    private int missingNum = -1;
    public int findMissing2(int n, String str) {
        // compare 1/2 elements combination in str, if it is in the range of 1 - n, mark the visited as true
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;

        dfs(str, visited, 0, n);
        return missingNum;
    }

    private void dfs(String str, boolean[] visited, int startIndex, int n) {
        if (missingNum != -1) {
            return;
        }
        // this means we have went through the entire str, loop through the visited and find the one that's not visited
        if (startIndex == str.length()) {
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    missingNum = i;
                    return;
                }
            }
        }
        // if the string starts with 0, it is not a valid num
        if (str.charAt(startIndex) == '0') {
            return;
        }
        // checking 1 char and 2 chars separately
        for (int i = 1; i <= 2; i++) {
            if (i <= str.length()) {
                int num = Integer.parseInt(str.substring(0, i));
                if (num > 0 && num <= n && !visited[num]) {
                    visited[num] = true;
                    dfs(str.substring(i, str.length()), visited, startIndex, n);
                    visited[num] = false;
                }
            }
        }
    }
}
