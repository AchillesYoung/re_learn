package QuestionMet;

import java.util.HashMap;
import java.util.Map;

public class FindOddsOccurInArray {

    //���ֻ��һ������������
    //ʹ�����
    public static int getNum (int[] nums) {
        int res = 0;

        for (int  num : nums) {
            res ^= num;
        }
        return res;
    }
    /**
     * ʹ��hash
     * */
    public static int singleNumber_1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(Integer num : nums) {
            if(map.get(num) != null) {
                map.put(num, map.get(num)+1);
            }else {
                map.put(num, 1);
            }
        }
        int result = -1;
        for(Integer key : map.keySet()) {
            if(map.get(key)%2 != 0) {
                result = key;
            }

        }
        return result;
    }
    //����ж��
}
