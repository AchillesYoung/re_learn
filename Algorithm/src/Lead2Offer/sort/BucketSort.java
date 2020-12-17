package Lead2Offer.sort;

import java.util.HashMap;
import java.util.Map;

public class BucketSort {
    /**
     * ��������ķ�������ȻͰ����ʱ�临�Ӷ�Ϊ���ԣ�
     * �ǲ��Ǿ������������š��鲢����ʱ�临�Ӷ�ΪO(nlogn)�������㷨�أ�
     * ���Ƿ񶨵ģ�Ͱ�����Ӧ�ó���ʮ���Ͽ���
     * ���ȣ�����Ӧ�÷ֲ��ȽϾ��ȡ���һ�ֽϻ���������������ȫ�������ֵ�һ��Ͱ�
     * ��ôͰ�����ʱ�临�Ӷ��ǲ��Ǿ��˻���O(nlogn)���أ�
     * ��Σ�Ҫ���������Ӧ�ú����׷ֳ�m��Ͱ��ÿ��ͰҲӦ���д�С˳��
     */

    public void bucket_sort(int[] arr, int valueRange) {
        if(arr.length < 2 || arr == null ){
            return;
        }
        Map<Integer, Integer> bucketMap = new HashMap<>();//���˼·����
        //����Ӧ�������飬��������ֵ����������Ǹ�ֵ�ĸ���
        int[] bucket = new int[valueRange + 1];
        for (int i = 0; i < arr.length; ++i) {
            bucket[arr[i]]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; ++i) {
            while (bucket[i]-- > 0) {
                arr[index++] = i;
            }
        }

    }
}
