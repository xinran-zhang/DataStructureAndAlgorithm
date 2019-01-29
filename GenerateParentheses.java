package grace.shuati;
import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        dfs(res, "", n, n);
        return res;
    }

    private void dfs(List<String> res, String curParen, int leftParen, int rightParen) {
        if (leftParen == 0 && rightParen == 0) {
            res.add(curParen);
            return;
        }

        if (leftParen > 0) {
            dfs(res, curParen + "(", leftParen - 1, rightParen);
        }

        if (rightParen > 0 && leftParen < rightParen) {
            dfs(res, curParen + ")", leftParen, rightParen - 1);
        }
    }
}
