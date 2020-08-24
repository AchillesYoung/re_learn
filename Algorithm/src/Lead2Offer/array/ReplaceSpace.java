package Lead2Offer.array;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

/**
 * char转string 用stringOf。
 * char的字符范围有限，不能标示特殊字符
 *
 */
public class ReplaceSpace {

    public static String replaceSpace(String str) {
        int count = 0;
        for(int i = 0; i<str.length();i++){
            if(str.charAt(i)==' '){
                count++;
            }
        }
        System.out.println(count);
        String [] arr = new String[str.length()+count*2];
        char[] result = Arrays.copyOf(str.toCharArray(), str.length()+count*2);
        System.out.println(arr.length);
        int point =0;
        for(int i = 0; i<str.length();i++){
            if(str.charAt(i)==' ') {
                result[point]='%';
                result[++point]='2';
                result[++point]='0';
            }else {
                result[point] =  str.charAt(i);
            }
            point++;
        }

        return new String(result);
    }

    public static void main(String[] args) {
        String str = "We are happy.";

        System.out.println(replaceSpace(str));
    }



}
