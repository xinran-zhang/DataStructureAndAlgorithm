package grace.shuati;
import java.util.*;

/**
 * Remove the minimum number of invalid parentheses in order to
 * make the input string valid. Return all possible results.
 */

public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0) {
            return res;
        }

        dfs(s, res, 0, '(', ')');
        return res;
    }

    private void dfs(String s, List<String> res, int startIndex, char leftP, char rightP) {
        int delta = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == leftP) {
                delta++;
            } else if (c == rightP) {
                delta--;
            }

            if (delta == -1) {
                for (int j = startIndex; j <= i; j++) {
                    if (s.charAt(j) == rightP && (j == startIndex || s.charAt(j - 1) != rightP)) {
                        dfs(s.substring(0, j) + s.substring(j + 1), res, j, leftP, rightP);
                    }
                }
                return;
            }
        }

        // reverse the String to check if left parentheses is more than right parentheses
        if (leftP == '(') {
            dfs(new StringBuilder(s).reverse().toString(), res, 0, rightP, leftP);
        } else {
            res.add(new StringBuilder(s).reverse().toString());
        }
    }
}
