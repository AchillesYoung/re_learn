package Lead2Offer.String;

/**
 * TODO
 剑指offer: 左旋转字符串
 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class StringRotate {

    public boolean rotateStringEqual(String A, String B) {
        //长度不同肯定不是，
        return A.length() == B.length() && (A+A).contains(B);
    }

    public String LeftRotateString(String str,int n) {
        int len = str.length();
        if(len <2){
            return str;
        }
        n = n % len;
        String s1 = str.substring(n, len);
        String s2 = str.substring(0, n);
        return s1+s2;
    }

}
