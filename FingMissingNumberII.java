package grace.shuati;

public class FingMissingNumberII {
    int missingNum = -1;
    public int findMissing2(int n, String str) {
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        dfs(str, n, visited, 0);
        return missingNum;
    }

    private void dfs(String str, int n, boolean[] visited, int startIndex) {
        if (missingNum != -1) {
            return;
        }

        if (str.length() == startIndex) {
            for (int i = 0; i < visited.length; i++) {
                if (!visited[i]) {
                    missingNum = i;
                    return;
                }
            }
        }

        if (str.charAt(startIndex) == '0') {
            return;
        }

        for (int i = 1; i <= 2; i++) {
            if (i <= str.length()) {
                int num = Integer.parseInt(str.substring(0, i));
                if (num > 0 && num <= n && !visited[num]) {
                    visited[num] = true;
                    dfs(str.substring(i), n, visited, startIndex);
                    visited[num] = false;
                }
            }
        }
    }
}
