package Lead2Offer.sort;

public class BubbleSort {
    /**
     * 看起来是O(n^2),最好的情况是O(n)
     * @param arr
     * @return
     */
    public int[] solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        //每轮找到最大，就j-1
        for (int i = arr.length - 1; i > 0; --i) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                //优化冒泡排序,如果这轮没有交换就说明比较完了
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
        return arr;
    }

    private void swap(int[] arr, int j, int i) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    private void swapBit(int[] arr, int j, int i) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
