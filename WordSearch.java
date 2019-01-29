package grace.shuati;


public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean exist = helper(board, word, i, j, 0);
                    if (exist) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int x, int y, int startIndex) {
        if (startIndex == word.length()) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(startIndex)) {
            return false;
        }

        board[x][y] = '#';
        boolean exist = helper(board, word, x + 1, y, startIndex + 1) ||
                helper(board, word, x - 1, y, startIndex + 1) ||
                helper(board, word, x, y + 1, startIndex + 1) ||
                helper(board, word, x, y - 1, startIndex + 1);
        board[x][y] = word.charAt(startIndex);
        return exist;
    }
}
