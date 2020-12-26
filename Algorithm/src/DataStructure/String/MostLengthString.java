package DataStructure.String;

public class MostLengthString {

    public static int solution(String arr) {
        char[] chars = arr.toCharArray();
        int length = 0;
        int max = 0;
        for (int i = 0; i <= chars.length; i++) {
            if ( i == chars.length || chars[i] == ' '){
                max = length > max ? length : max;
                length = 0;
                continue;
            }
            length ++;
        }

        return max;
    }
}
