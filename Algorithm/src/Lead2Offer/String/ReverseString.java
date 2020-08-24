package Lead2Offer.String;

/**
 * TODO
 *
 * @author yangshu
 * @version 5.0.0
 * @created at 2020/5/29-11:51 AM
 * copyright @2020 Beijing Morong Information Techology CO.,Ltd.
 */
public class ReverseString {


    public static String reverse(String str){
        if(null==str){
            return null;
        }
        if(str.length()<2){
            return str;
        }
        //不用额外的空间,双指针移动互换
        char [] chArr = str.toCharArray();
        int l = 0, r = str.length() - 1;

        while (l<r){
            char temp = chArr[l];
            chArr[l]=chArr[r];
            chArr[r]=temp;
            l++;
            r--;

        }
        return new String(chArr);
    }

    public static void main(String[] args) {
        String test="private AgwRutExtMapper agwRutExtMapper! spotyuvjvvjh1221";
        System.out.println(reverse(test));
    }
}
