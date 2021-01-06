package QuestionMet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Array2DMegre {

    /**
     * 时间复杂度：O(n\log n)O(nlogn)，其中 nn 为区间的数量。除去排序的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的 O(n\log n)O(nlogn)。
     * 空间复杂度：O(\log n)O(logn)，其中 nn 为区间的数量。这里计算的是存储答案之外，使用的额外空间。O(\log n)O(logn) 即为排序所需要的空间复杂度。
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
        //输入: [[1,3],[2,6],[8,10],[15,18]]
        //输出: [[1,6],[8,10],[15,18]]
        //将给定数组排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            //按照第一个排序
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });


        for (int i = 0; i < length; i++) {
            //后一个元素数组 的第一个元素
            int left = intervals[i][0];
            //前一个元素数组 的第二个元素
            int right = intervals[i][1];

            //前一个元素数组 的第二个元素大于后一个元素数组 的第一个元素，说明可以合并
            while (i + 1 < length && right >= intervals[i + 1][0]) {
                right = Math.max(intervals[i + 1][1], right);
                i++;
            }

            //合并后放入新的数组中
            arr[index][0] = left;
            arr[index++][1] = right;
        }

        //最后写入结果数组中
        int[][] res = new int[index][2];
        for (int i = 0; i < index; i++) {
            res[i][0] = arr[i][0];
            res[i][1] = arr[i][1];
        }

        return res;

    }
}
