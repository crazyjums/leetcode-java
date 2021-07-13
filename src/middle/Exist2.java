package middle;

public class Exist2 {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null || word.length() == 0) return true;
        boolean[][] used = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, used, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] used, int index, int x, int y) {
        if (index == word.length())
            return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index))
            return false;

        boolean isPath = false;
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !used[x][y] && word.charAt(index) == board[x][y]) {
            used[x][y] = true;
            isPath = dfs(board, word, used, index + 1, x + 1, y) ||
                    dfs(board, word, used, index + 1, x - 1, y) ||
                    dfs(board, word, used, index + 1, x, y - 1) ||
                    dfs(board, word, used, index + 1, x, y + 1);
            if (!isPath) {
                used[x][y] = false;
                index --;
            }
        }
        return isPath;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}
        };
        String a = "ABCCED";
        System.out.println(new Exist2().exist(board, a));
    }
        
}
