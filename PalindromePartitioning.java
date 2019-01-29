package grace.shuati;
import java.util.*;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        List<String> substrings = new ArrayList<>();
        if (s == null) return results;
        if (s.length() == 0) {
            results.add(substrings);
            return results;
        }
        if (s.length() == 1) {
            substrings.add(s);
            results.add(substrings);
            return results;
        }

        dfs(s, substrings, results);
        return results;
    }

    private void dfs(String s, List<String> substrings, List<List<String>> results) {
        if (s.equals("")) {
            results.add(new ArrayList<>(substrings));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            if (!isPanlindrome(s.substring(0, i))) {
                continue;
            }
            substrings.add(s.substring(0, i));
            dfs(s.substring(i, s.length()), substrings, results);
            substrings.remove(substrings.size() - 1);
        }
    }

    private boolean isPanlindrome(String str) {
        if (str == null) return false;
        if (str.length() <= 1) return true;
        int start = 0, end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
