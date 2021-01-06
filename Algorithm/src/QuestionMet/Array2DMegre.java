package QuestionMet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Array2DMegre {

    /**
     * ʱ�临�Ӷȣ�O(n\log n)O(nlogn)������ nn Ϊ�������������ȥ����Ŀ���������ֻ��Ҫһ������ɨ�裬������Ҫ��ʱ�俪��������� O(n\log n)O(nlogn)��
     * �ռ临�Ӷȣ�O(\log n)O(logn)������ nn Ϊ��������������������Ǵ洢��֮�⣬ʹ�õĶ���ռ䡣O(\log n)O(logn) ��Ϊ��������Ҫ�Ŀռ临�Ӷȡ�
     * @param intervals
     * @return
     */
    public int[][] mergeAdvanced(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }


    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        int[][] arr = new int[length][2];
        int index = 0;
        //����: [[1,3],[2,6],[8,10],[15,18]]
        //���: [[1,6],[8,10],[15,18]]
        //��������������
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            //���յ�һ������
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });


        for (int i = 0; i < length; i++) {
            //��һ��Ԫ������ �ĵ�һ��Ԫ��
            int left = intervals[i][0];
            //ǰһ��Ԫ������ �ĵڶ���Ԫ��
            int right = intervals[i][1];

            //ǰһ��Ԫ������ �ĵڶ���Ԫ�ش��ں�һ��Ԫ������ �ĵ�һ��Ԫ�أ�˵�����Ժϲ�
            while (i + 1 < length && right >= intervals[i + 1][0]) {
                right = Math.max(intervals[i + 1][1], right);
                i++;
            }

            //�ϲ�������µ�������
            arr[index][0] = left;
            arr[index++][1] = right;
        }

        //���д����������
        int[][] res = new int[index][2];
        for (int i = 0; i < index; i++) {
            res[i][0] = arr[i][0];
            res[i][1] = arr[i][1];
        }

        return res;

    }
}
