package DataStructure.String;

/**
 * @author yangshu
 * @version 5.0.0
 * @created at 2019/9/6-2:26 PM
 * copyright @2019 Beijing Morong Information Techology CO.,Ltd.
 */
public class UnicodeDemo {
    public static void main(String[] args) {
        Character ch ='1';
        Character [] chs = {'1','1','1'};
        System.out.println("-------char");
        System.out.println(chs[1]);

        char[] charMap = new char[256];
        charMap[1] = (char) (11 + 1);
        System.out.println(charMap[1]);
        int a = charMap[1]+2;
        System.out.println(a);
    }
}
