package grace.shuati;
import java.util.*;

public class WordSearchII {
    private static int[] dx = {1, 0 , 0 , -1};
    private static int[] dy = {0, 1, -1, 0};
    public List<String> wordSearchII(char[][] board, List<String> words) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> foundWordSet = new HashSet<>();
        Map<String, Boolean> prefixIsWord = prefixIsWord(words);

        // start from each position of the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                dfs(board, i, j, visited, String.valueOf(board[i][j]), prefixIsWord, foundWordSet);
                visited[i][j] = false;
            }
        }
        return new ArrayList<>(foundWordSet);
    }

    private void dfs(char[][] board, int x, int y, boolean[][] visited,
                     String word, Map<String, Boolean> prefixIsWord, Set<String> foundWordSet) {
        // foundWordSet is used to store all found words
        // prefixIsWord is a map that stores every prefix/word in the words list
        if (!prefixIsWord.containsKey(word)) {
            return;
        }
        if (prefixIsWord.get(word)) {
            foundWordSet.add(word);
        }

        for (int i = 0; i < 4; i++) {
            int adjx = x + dx[i];
            int adjy = y + dy[i];

            if (!inside(board, adjx, adjy) || visited[adjx][adjy]) {
                continue;
            }

            visited[adjx][adjy] = true;
            dfs(board, adjx, adjy, visited, word + board[adjx][adjy], prefixIsWord, foundWordSet);
            visited[adjx][adjy] = false;
        }
    }
    // use a map to store all prefixes and word in the words list
    private Map<String, Boolean> prefixIsWord(List<String> words) {
        Map<String, Boolean> map = new HashMap<>();
        for (String word: words) {
            for (int i = 0; i < word.length() - 1; i++) {
                if (!map.containsKey(word.substring(0, i + 1))) {
                    map.put(word.substring(0, i + 1), false);
                }
            }
            // if it is a word, boolean value is true
            map.put(word, true);
        }
        return map;
    }

    private boolean inside(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        return true;
    }
}
