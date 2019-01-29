package grace.shuati;
import java.util.*;

// use memoization to avoid MLE
public class WordBreakIII {
    public int wordBreak3(String s, Set<String> dict) {
        int n = s.length();
        String lowerS = s.toLowerCase();

        Set<String> lowerDict = new HashSet<String>();
        for(String str : dict) {
            lowerDict.add(str.toLowerCase());
        }
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = i; j < n;j++){
                String sub = lowerS.substring(i, j + 1);
                if(lowerDict.contains(sub)){
                    dp[i][j] = 1;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                for(int k = i; k < j; k++){
                    dp[i][j] += (dp[i][k] * dp[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }



//    int count = 0;
//    public int wordBreak3(String s, Set<String> dict) {
//        if (s.length() == 0 || dict == null || dict.size() == 0) {
//            return 0;
//        }
//        s = s.toLowerCase();
//        Set<String> lowerDict = new HashSet<>();
//        for (String str: dict) {
//            lowerDict.add(str.toLowerCase());
//        }
//        dfs (s, lowerDict, 0);
//        return count;
//    }
//
//    private void dfs(String s, Set<String> dict, int startIndex) {
//        if (startIndex == s.length()) {
//            count++;
//        }
//
//        for (int i = startIndex; i < s.length(); i++) {
//            String word = s.substring(startIndex, i + 1);
//            if (dict.contains(word)) {
//                dfs(s, dict, i + 1);
//            }
//        }
//    }
}
