package Lead2Offer.BitOperator;

/**
 * @author yangshu
 */
public class OddTimesNum {
    /**
     * 如果有两个数获得的结果 eO 肯定是 eO = a^b,此题的关键就在于如何分别得到 a，b 这两个数。
     * 我们应该想到，任何不相同的两个除了跟自己异或外，不可能每一个位都相同，
     * 也就是说不相同的两个数 a b 异或得到结果二进制表示上肯定有一位为 1,这是关键
     * 没思路。。。
     * 这时需要拿 eOhasOne = 0 再异或遍历一次数组，但是需要忽略与 rightOne 相与等于 0 的数。
     * 因为相与等于 0 则代表了这个数肯定是两个数中第 k 位不为 1的那个。最终得到的 eOhasOne 就是 a b 中第 k 为为 1 的那个。
     */
    public static void printOddTimesNum(int[] arr) {
        int eO = 0;
        int eOhasOne = 0;

        for (int cur : arr) {
            eO = eO ^ cur;
        }

        int rightOne = eO & (~eO + 1);
        for (int cur : arr) {
            if ((rightOne & cur) != 0) {
                eOhasOne = eOhasOne ^ cur;
            }
        }
    // eOhasOne ^ eO =  7^4^7 = 4;  eOhasOne = 7
        System.out.println("eOhasOne = " + eOhasOne + "  " + (eOhasOne ^ eO));
    }

    public static void main(String[] args) {
       int [] arr1 = {2,1,3,3,2,1,4,7};
       printOddTimesNum(arr1);
    }
}
