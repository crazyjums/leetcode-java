package middle;


public class ExistWord {

    public boolean exist(char[][] board, String word) {
        if (board == null)
            return false;
        if (word == null)
            return false;
        int rows = board.length;
        int cols = board[0].length;
        return backTrack(board, word, rows, cols);
    }

    private boolean backTrack(char[][] board, String word, int rows, int cols) {
        boolean[][] used = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPath(0, word, i, j, rows, cols, used, board))
                    return true;
            }
        }
        return false;
    }

    /**
     * @param index：表示Word中的第index个字符
     * @param word：需要匹配的字符串
     * @param row：当前走到矩阵的第row行
     * @param col：当前走到矩阵的第col列
     * @param rows：矩阵的总行数
     * @param cols：矩阵的总列数
     * @param used：记录矩阵中哪些字符被使用过，哪些没有被使用过
     * @param board：矩阵本身
     * @return
     */
    private boolean hasPath(int index, String word, int row, int col, int rows, int cols, boolean[][] used, char[][] board) {
        //1.退出条件
        if (index == word.length())
            return true;

        //2.当前逻辑
        if (row < 0 || col < 0 || col >= cols || row >= rows)//如果下一个待搜索的字符的位置在矩阵之外，向上回溯
            return false;
        boolean isPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && word.charAt(index) == board[row][col] && !used[row][col]) {
            index++;//表示矩阵有需要匹配的字符串的第index个字符，然后匹配下一个
            used[row][col] = true;//并将矩阵中的该字符设为已经被访问过
            //3.向下递归  依次访问上下左右格子中的字符
            isPath = hasPath(index, word, row - 1, col, rows, cols, used, board) ||
                    hasPath(index, word, row + 1, col, rows, cols, used, board) ||
                    hasPath(index, word, row, col - 1, rows, cols, used, board) ||
                    hasPath(index, word, row, col + 1, rows, cols, used, board);
            //4.善后处理
            if (!isPath) {//如果上一个字符的下一个字符（四个方位）都没有字符串中需要匹配的字符，则再向上回溯
                --index;
                used[row][col] = false;
            }
        }

        return isPath;
    }


    public boolean exist2(char[][] board, String word) {
        if (board == null)
            return false;
        if (word == null)
            return false;
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (check(i, j, 0, word, used, board))
                    return true;
            }
        }
        return false;
    }

    private boolean check(int i, int j, int k, String word, boolean[][] used, char[][] board) {
        if (k == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        if (board[i][j] != word.charAt(k))
            return false;

        boolean isPath = false;
        if (i >= 0 && i < board.length && j >= 0 && j < board[0].length && !used[i][j] && board[i][j] == word.charAt(k)){
            used[i][j] = true;
            //向下递归
            isPath = check(i + 1, j, k + 1, word, used, board) ||
                    check(i - 1, j, k + 1, word, used, board) ||
                    check(i, j - 1, k + 1, word, used, board) ||
                    check(i, j + 1, k + 1, word, used, board);
            if (!isPath){ //如果没有该条路径，则向上回溯，
                --k;
                used[i][j] = false; //上一个位置设置没有被访问过
            }
        }
        return isPath;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String s = "ABCE";
        ExistWord existWord = new ExistWord();
        System.out.println(existWord.exist2(board, s));

    }
}
