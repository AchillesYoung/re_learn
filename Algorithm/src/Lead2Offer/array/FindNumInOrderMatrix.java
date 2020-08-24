package Lead2Offer.array;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/6/9-11:21 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class FindNumInOrderMatrix {


    public static int searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return -1;
        }
        int m = 0;
        //n=0
        int n = matrix[0].length - 1;
        while (m<matrix.length&&n>=0){
            if(target>matrix[m][n]){
                n--;
            }else if(matrix[m][n] < target){
                m++;
            } else {
                return target;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [][] arr = new int[5][5];
        arr[0]=new int[]{1,4,7,11,15};
        arr[1]=new int[]{2,5,8,12,19};
        arr[2]=new int[]{3,6,9,16,22};
        arr[3]=new int[]{10,13,14,17,24};
        arr[4]=new int[]{18,21,23,26,30};
//        System.out.println(arr[4][0]);
        System.out.println(searchMatrix(arr, 13));


    }

}
