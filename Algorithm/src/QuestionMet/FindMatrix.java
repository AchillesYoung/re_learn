package QuestionMet;

public class FindMatrix {
    /**
     * 思路 ：
     * 从左下角最后一个元素开始比较，如果target小于这个元素向上遍历否则向右遍历

     */

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] >target)
                col++;
            else if (matrix[row][col] <target)
                row--;
            else
                return true;
        }
        return false;
    }
}
