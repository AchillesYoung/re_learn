package QuestionMet;

/**
 * 开关灯问题:有n个人和n盏灯，
 * 第一个人开所有的灯，
 * 第二个人按所有2的倍数的灯的开关，
 * 第三个人按所有3的倍数的灯的开关，依此类推，求最后多少盏灯亮着
 * 解法：按奇数次则亮，偶数次则灭，所以因子数为奇数亮，
 * 所以平方数亮，即求n内平方数个数，
 * 为(int)sqrt(n),如n=16，根号16=4,所以平方数有1*1,2*2,3*3,4*4，即1、4、9、16四个。
 */
public class TurnOnLight {
    int bulbSwitch(int n) {
        if (n == 1)
            return 1;
        int result = 1;
        while (true) {
            if (result * result > n)
                break;
            result++;
        }
        return result - 1;
    }
}
