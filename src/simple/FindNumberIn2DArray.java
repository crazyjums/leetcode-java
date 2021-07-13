package simple;

public class FindNumberIn2DArray {
    public static boolean solution(int target, int[][] matrix) {
        if (matrix == null)
            return false;
        int row = matrix.length;
        int col=0;
        if (row >= 1)
            col = matrix[0].length;
        /**
         * 从二维数据的右上角从左下角查询，每次可以排除一列或一行
         */
//        for (int i = col - 1; i > -1; i--) {
//            for (int j = 0; j < row; j++) {
//                if (matrix[j][i] == target)
//                    return true;
//                else {
//                    continue;
//                }
//            }
//        }
        /**
         * 从二维数据的左下角到右上角查询，每次可以排除一列或是一行
         */
        for (int i = 0; i < col; i++) {
            for (int j = row-1; j >-1 ; j--) {
                if (matrix[j][i]==target){
                    return true;
                }else
                    continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int[][] nu = {{1},{2}};
        int n = 18;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + solution(i, matrix));
        }

    }
}
