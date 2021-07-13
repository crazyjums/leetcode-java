package middle;

import java.util.HashSet;

public class Exist {
    private int row;
    private int col;
    private int[][] next = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

    public boolean exist(char[][] board, String word) {
        this.row = board.length;
        if (board == null || this.row == 0) return false;
        this.col = board[0].length;
        boolean[][] used = new boolean[this.row][this.col];
        int len = 0;//表示遍历到Word中的即len个字符
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                //分别从数组中每个字符开始查找
                if (dfs(board, used, len, word, i, j)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] used, int len, String word, int i, int j) {
        if (i < 0 || i >= this.row || j < 0 || j >= this.col || board[i][j] != word.charAt(len)||used[i][j]) {
            return false;
        }
        if (len == word.length() - 1) {
            return true;
        }
        boolean hasPath = false;
        if (!used[i][j] && board[i][j] == word.charAt(len)) {
            used[i][j] = true;
            hasPath = dfs(board, used, len + 1, word, i + 1, j) ||
                    dfs(board, used, len + 1, word, i, j + 1) ||
                    dfs(board, used, len + 1, word, i, j - 1) ||
                    dfs(board, used, len + 1, word, i - 1, j);
            if (!hasPath) {
                used[i][j] = false;
            }
        }
        return hasPath;
    }


    public static void main(String[] args) {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        char[][] board = {{'a', 'a'}};
        String word = "aaa";
        Exist exist = new Exist();
        System.out.println(exist.exist(board, word));
    }
}
