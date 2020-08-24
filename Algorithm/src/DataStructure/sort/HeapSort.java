package DataStructure.sort;

/**
 * 堆（二叉堆）可以视为一棵完全的二叉树
 * 这使得堆可以利用数组来表示
 * 二叉堆一般分为两种：最大堆和最小堆
 */

import java.util.Arrays;
import java.util.PriorityQueue;


/**
 * 大顶堆：arr[i] >= arr[2i+1] && arr[i] >= arr[2i+2]
 * 小顶堆：arr[i] <= arr[2i+1] && arr[i] <= arr[2i+2]
 */
public class HeapSort extends Sort {

    //数组arr[0,1,2,3,4,5,6]

    //数组arr[0,1,2,3,4,5,6]
    /**
     * 思路
     * 将数组按照索引进行向下遍历构造成大顶堆（顶元素最大）-->heapInsert
     * 然后将顶元素root和数组末尾交换，此时最后一个为最大，依次递减虚拟数组，
     * 重新heapify成越老越小的大顶堆，直到剩最后一个元素
     */
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //Step1:数组构造大顶堆
        //循环遍历数组，把元素依次插入构造的大顶堆，向下构造
        //但是每次insert都要走一次heapInsert排序流程去保证堆顶为最大
        for(int i=0;i<arr.length; i++){
            //这里heapinsert的思想因为是向下遍历构造，所以新元素会加在最后一个叶子
            // 节点，然后再向上回溯比较交换重构大顶堆->保证顶端是最大
            heapInsert(arr,i);
        }
        //step2: 交换堆顶和数组末尾位置，--size的虚拟数组重新构造大顶堆
        //重复step2，直到遍历到最后叶子节点
        //完成第一步，第二步进行第一次堆顶掉包交换：
        //调包一次大顶堆size减少一次（这时候的顶元素其实在叶节点的最后一个）
        int size = arr.length;
        swap(arr, 0, --size);
        //如果size还>0（还有元素）
        // 就要把减少了一个长度的虚拟数组重新构造成大顶堆（heapify）
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    public static void heapInsert(int[] arr, int index) {
        /**
         * (index - 1) / 2是父亲节点
         * 1.如果比父节点大就交换
         * 2.交换以后上面递进，index=(index - 1) / 2
         * 直到arr[index]<arr[(index - 1) / 2]或者arr[0]=arr[(0-1)]
         */

        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void heapify(int[] arr, int index, int size) {
        /**
         * heapify重构构造应该是往下递归的，(这时候顶元素已经是新的），现在拿新的往下递归
         * 每次往下递归，都要对比小子树的三个节点，
         * 先计算左节点是否超出现在的虚拟数组长度（left<size）-->这里长度size要和索引区分开
         * 如果超出虚拟数组长度size的
         * 先拿左节点（子树节点计算index * 2 + 1）
         */
        int left = index * 2 + 1;
        while (left < size) {
            //先对比二个子节点，拿到最大的节点的索引，再去和父节点index比较，最终拿到largest
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            //这里拿到了子树里面最大的元素索引
            largest = arr[largest] > arr[index] ? largest : index;
            //如果最大的就是index，结束循环，不然交换继续向下递归
            if (largest == index) {
                break;
            }
//            交换，传递位置
            swap(arr, largest, index);
            //继续向下，stack递归遍历（
            // 这里没有左右子树的概念是因为哪个节点出来了换位就基于哪个节点继续向下遍历。直到叶节点
            index = largest;
            left = index * 2 + 1;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1);
            Arrays.sort(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr);
        printArray(arr);

    }

}





