package DataStructure.bit;

import org.junit.Test;

/**
 * TODO
 */
public class BitDemo {
    @Test
    public void check() {

        int n = 31231;
        if ((n & 1) == 1) {
            // n 是个奇数。
            System.out.println(n);
        }
    }
    @Test
    public void swap() {
//        利用异或的交换率和结合律
//        把（1）中的 x 带入 （2）中的 x，有
//                y = x^y = (x^y)^y = x^(y^y) = x^0 = x。 x 的值成功赋给了 y。
//        对于（3）,推导如下：
//        x = x^y = (x^y)^x = (x^x)^y = 0^y = y。
        int x = 3, y = 4;
        System.out.println(x + "_" + y);
        x = x ^ y;  // （1）
        y = x ^ y;  // （2）
        x = x ^ y;  // （3）
        System.out.println(x + "_" + y);
    }
    @Test
    public int find() {
        int [] arr = new int[5];
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            tmp = tmp ^ arr[i];
        }
        return tmp;
    }
}
