package grace.shuati;
import java.util.*;

/**
 * Given a string, find all permutations of it without duplicates.
 */

public class StringPermutationII {
    public List<String> stringPermutation2(String str) {
        List<String> res = new ArrayList<>();
        if (str.length() == 0) {
            res.add("");
            return res;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[str.length()];
        dfs(chars, sb, visited, res);
        return res;
    }

    private void dfs(char[] chars, StringBuilder sb, boolean[] visited, List<String> res) {
        if (sb.length() == chars.length) {
            res.add(new StringBuilder(sb).toString());
        }

        for (int i = 0; i < chars.length; i++) {
            // remove duplicate - use a boolean array to track which num is visited
            if (visited[i] || (i > 0 && chars[i] == chars[i - 1]) && !visited[i - 1]) {
                continue;
            }
            sb.append(chars[i]);
            visited[i] = true;
            dfs(chars, sb, visited, res);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main (String[] args) {
        StringPermutationII sp = new StringPermutationII();
        sp.stringPermutation2("abb");
    }
}
