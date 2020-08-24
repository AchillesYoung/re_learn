package Lead2Offer.String;

import java.util.HashMap;

/**
 * 剑指offer: 字符流中第一个不重复的字符,请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如:
 * 当从字符流中只读出前两个字符”go”时，第一个只出现一次的字符是”g”。当从该字符流中读出前六个字符“google”时，第一个只出现一次的字符是”l”。
 */
public class FirstAppearOnce {
    /**
     * stream流插入哈希表
     */
    HashMap<Character, Integer> hashMap = new HashMap();//用来后面insert计算出现次数用
    StringBuffer str = new StringBuffer();//用来后边findFirstAppear遍历的时候用

    public void insert(char next) {
        str.append(next);
        if (hashMap.containsKey(next)) {
            hashMap.put(next, hashMap.get(next) + 1);
        } else {
            hashMap.put(next, 1);
        }
    }

    public Character findFirstAppear() {

        for (int i = 0; i < str.length(); i++) {
            if (hashMap.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        FirstAppearOnce firstAppearOnce = new FirstAppearOnce();
        String str = "googleeelf";
        for (int i = 0; i < str.length(); i++) {
            firstAppearOnce.insert(str.charAt(i));
            System.out.println(firstAppearOnce.str);
            System.out.println(firstAppearOnce.findFirstAppear());
        }
    }
}
