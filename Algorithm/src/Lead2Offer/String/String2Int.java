package Lead2Offer.String;

/**
 * TODO
 * 剑指offer:
 * 把字符串转换成整数 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class String2Int {

    public static int StrToInt(String str) {
        if (str.length() == 0) {
            return 0;

        }
        int flag = 0;
        if (str.charAt(0) == '+') {
            flag = 1;

        } else if (str.charAt(0) == '-') {
            flag = 2;
        }
//            有符号位start=1
        int start = flag > 0 ? 1 : 0;
        long res = 0;
        while (start < str.length()) {
            if (str.charAt(start) > '9' || str.charAt(start) < '0'){
                //不是数字是字符
                return 0;
            }
            res = res * 10 + (str.charAt(start) - '0');
            start++;
        }
        return flag == 2 ? -(int) res : (int) res;
    }


    public static void main(String[] args) {
        int res = StrToInt("-222")+1;
        System.out.println(res);
    }
}
