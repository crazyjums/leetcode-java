package secondTime;

public class Find {

    public boolean Find(int target, int[][] array) {
        if (array == null)
            return false;
        int rows = array.length;
        if (rows==0)
            return false;
        int cols = 0;
        if (rows>=1)
            cols = array[0].length;
        if (cols==0)
            return false;
        int row = 0, col = cols-1;
        while (row < rows && col > -1) {
            if (array[row][col] == target)
                return true;
            else if (target > array[row][col]) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3, 4},
                {3, 5, 6, 7},
                {8, 9, 10, 12},
                {16, 18, 19, 20}
        };
        int [][]b={{-5}};
        System.out.println(new Find().Find(-5, b));
    }
}
