package QuestionMet;

public class FindMatrix {
    /**
     * ˼· ��
     * �����½����һ��Ԫ�ؿ�ʼ�Ƚϣ����targetС�����Ԫ�����ϱ����������ұ���

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
