package Lead2Offer.sort;

public class BubbleSort {
    /**
     * ��������O(n^2),��õ������O(n)
     * @param arr
     * @return
     */
    public int[] solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        //ÿ���ҵ���󣬾�j-1
        for (int i = arr.length - 1; i > 0; --i) {
            boolean flag = false;
            for (int j = 0; j < i; j++) {
                //�Ż�ð������,�������û�н�����˵���Ƚ�����
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
