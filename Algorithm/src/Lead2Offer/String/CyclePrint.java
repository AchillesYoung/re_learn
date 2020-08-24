package Lead2Offer.String;

/**
 * 转圈打印矩阵
 */


public class CyclePrint {

    /**
     * 传入的是个矩阵，坐标还没有定义，矩阵可以当作(0,0)开始到(row,column)
     *
     * @param matrix
     */
    public static void spiralOrderPrint(int[][] matrix) {
//        定义开始和结束坐标
        int sR = 0;
        int sC = 0;
        int eR = matrix.length - 1;
        int eC = matrix[0].length - 1;
        //定义内旋转边界，并进行自加减
        while (sR <= eR && sC <= eC) {
            printEdge(matrix, sR++, sC++, eR--, eC--);
        }
    }

    public static void printEdge(int[][] matrix, int sR, int sC, int eR, int eC) {
        //考虑极端情况，最后只剩下一行/或者一列/或者单个
        //1.如果只有一行，就是sR==eR
        if (sR == eR) {
            for (int i = sC; i <= eC; i++) {
                System.out.print(matrix[sR][i] + " ");
            }
        } else if (eC == sC) {
            //2.如果只有一列
            for (int i = sR; i < eR; i++) {
                System.out.print(matrix[i][sC] + " ");
            }
        } else {
            //3.没有特殊情况，正常四边循环,这个时候不用指针，这样来回循环乱！！！
            //启用2个指针
            int curC = sC;
            int curR = sR;
            while (curC != eC) {
                System.out.print(matrix[sR][curC] + " ");
                curC++;
            }
            while (curR != eR) {
                System.out.print(matrix[curR][eC] + " ");
                curR++;
            }
            while (curC != sC) {
                System.out.print(matrix[eR][curC] + " ");
                curC--;
            }
            while (curR != sR) {
                System.out.print(matrix[curR][sC] + " ");
                curR--;
            }
        }

/**        错误示范
 for(int i=sC;i<eC;i++){
 //
 //            System.out.println(matrix[sR][i]);
 //        }
 //        for(int j=sR;j<eR;j++){
 //            System.out.println(matrix[j][eC]);
 //
 //        }
 //        for(int x=sC+1;x>0;x--){
 //            System.out.println(matrix[eR][x]);
 //        }
 //        for(int x=+1;x>0;x--){
 //        System.out.println(matrix[eR][x]);}
 **/


    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},
                {13, 14, 15, 16}};
        spiralOrderPrint(matrix);

    }
}
