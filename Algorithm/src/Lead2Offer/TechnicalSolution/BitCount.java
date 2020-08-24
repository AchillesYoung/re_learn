package Lead2Offer.TechnicalSolution;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/6/11-3:20 PM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class BitCount {
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(-2));

        String strHex = Integer.toBinaryString(-1);
        System.out.println(strHex);
        System.out.println(Integer.toBinaryString(1));

    }
}
