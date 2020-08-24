package Lead2Offer.Recursive;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/6/11-11:04 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class Steps {

    public static int solution(int x){

        if(x==1||x==2||x==0){
            return x;
        }

        return solution(x-1)+solution(x-2)%1000000007;
    }

    /**
     * _____，取模后 f(43) = 701408733, f(44) = 134903163 , f(45) = 836311896, f(46) = 971215059没有溢出。
     *
     * 取模之后能够计算更多的情况，如 f(46)
     *
     * 这道题的测试答案与取模后的结果一致。
     *
     * 总结一下，这道题要模1000000007的根本原因是标准答案模了1000000007。
     * 不过大数情况下为了防止溢出，模1000000007是通用做法，原因见第一点。
     */

    public static void main(String[] args) {

        System.out.println(Integer.MAX_VALUE);
//        solution(45)>Integer.MAX_VALUE;所以取模%1000000007
//        System.out.println(solution(49));
        String strHex = Integer.toHexString(1000000007);
        System.out.println(" [十进制]---->[十六进制] " + strHex);
        System.out.println(String.format("%08x", 1000000007));
        int valueHex = 0x3b9aca07;
        System.out.println("int valueHex = 0x00001322 --> " + valueHex);


    }
}
