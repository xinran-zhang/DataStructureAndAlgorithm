package grace.shuati;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class WordSearchIILeetcode {
    private static int[] dx = {1, 0 , 0 , -1};
    private static int[] dy = {0, 1, -1, 0};
    public List<String> findWords(char[][] board, String[] words) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return new ArrayList<>();
        }

        Set<String> foundWords = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        Map<String, Boolean> prefixIsWord = prefixIsWord(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                dfs(board, visited, i, j, String.valueOf(board[i][j]), prefixIsWord, foundWords);
                visited[i][j] = false;
            }
        }
        return new ArrayList<>(foundWords);
    }

    private void dfs(char[][] board, boolean[][] visited, int x, int y, String word,
                     Map<String, Boolean> prefixIsWord, Set<String> foundWords) {
        if (!prefixIsWord.containsKey(word)) {
            return;
        }
        if (prefixIsWord.get(word)) {
            foundWords.add(word);
        }

        for (int i = 0; i < 4; i++) {
            int adjx = x + dx[i];
            int adjy = y + dy[i];

            if (!insideBoard(board, adjx, adjy) || visited[adjx][adjy]) {
                continue;
            }

            visited[adjx][adjy] = true;
            dfs(board, visited, adjx, adjy, word + board[adjx][adjy], prefixIsWord, foundWords);
            visited[adjx][adjy] = false;
        }
    }

    private Map<String, Boolean> prefixIsWord(String[] words) {
        Map<String, Boolean> map = new HashMap<>();
        for (String word: words) {
            for (int i = 0; i < word.length() - 1; i++) {
                if (!map.containsKey(word.substring(0, i + 1))) {
                    map.put(word.substring(0, i + 1), false);
                }
            }
            map.put(word, true);
        }
        return map;
    }

    private boolean insideBoard(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        return true;
    }
}
