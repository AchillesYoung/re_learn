package Lead2Offer.sort;

public class MergeSort {

    /**
     * O(N*logN)
     */
    public int[] mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        merge_sort_recursive(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * 递归的主体 O(logN)
     *
     * @return
     */
    public int[] merge_sort_recursive(int[] arr, int start, int end) {
        if (start == end) {
            return arr;
        }
        int mid = start + (start - end) >> 2;
        //这左边拍好序
        merge_sort_recursive(arr, start, mid);
        //这右边边拍好序
        merge_sort_recursive(arr, mid + 1, end);
        //现在做左右合并，整个有序, O(N)
        mergeProcess(arr, start, end, mid);
        return arr;
    }

    public int[] mergeProcess(int[] arr, int start, int end, int mid) {
        //必须借数组空间排序，不然就在一边排一边覆盖。
        int[] help = new int[end - start + 1];
        //长度是索引差+1记住
        int pointLeft = start;
        int pointRight = mid + 1;
        int i = 0;
        while (pointLeft <= mid && pointRight <= end) {
            //每次i都要加++，（pointLeft，pointRight）任一个++
            help[i++] = arr[pointLeft] < arr[pointRight] ? arr[pointLeft++] : arr[pointRight++];
        }
        while (pointLeft <= mid) {
            help[i] = arr[pointLeft];
        }
        while (pointRight <= end) {
            help[i] = arr[pointRight];
        }
        //这里需要copy到之前的数组
        for (i = 0; i < help.length; i++) {
            arr[start + i] = help[i];
        }
        return help;

    }
}
