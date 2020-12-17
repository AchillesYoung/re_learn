package Lead2Offer.sort;

public class HeapSort {

    /**
     * 构建大顶堆，然后后数组最后一位换位置
     */
    public int[] heap_sort(int[] unsorted_arry) {
        int size = unsorted_arry.length;
        if (unsorted_arry == null || size < 2) {
            return unsorted_arry;
        }

        //step1：先把原始数组构建第一次大顶堆，后续再交换重做
        //循环遍历数组，把元素依次插入构造的大顶堆，向下构造
        for (int i = 0; i < size; ++i) {
            heap_insert(unsorted_arry, i);
        }
        //step2：现在数组的头节点是最大，swap一下，数组变小再次构建，这次不是insert了，因为只是堆头变了
        swap(unsorted_arry, 0, --size);
        while (size > 0) {
            //这里传的是size，不是end，索引要size-1
            heapify(unsorted_arry, 0, size);
            //先赋值再--
            swap(unsorted_arry, 0, --size);
        }
        return unsorted_arry;
    }

    /**
     * 来算树子节点索引
     * index/2 = parent
     * index * 2 + 1 = leftChild, index * 2 + 2 = rightChild
     * 0-1-2-3-4-5-6
     * //      0
     * //  1       2
     * //3   4  5     6
     */
    private void heap_insert(int[] arr, int index) {
        //第一次"数组构建堆过程"构建过程全是在加子节点，根据数组->树的对应索引，所以忽略该叶节点后续子节点
        //所以这里只需和父节点比较，循环往上
        while (arr[index] >= arr[(index - 1) >> 1]) {
            swap(arr, index, (index - 1) >> 1);
            //继续交换比较索引，这时候该父节点和爷节点比较
            index = (index - 1) >> 1;
        }
    }

    /**
     * heapify重构构造应该是往下递归的，(这时候顶元素已经是新的），现在拿新的往下递归
     * 每次往下递归，都要对比小子树的三个节点，
     * 先计算左节点是否超出现在的虚拟数组长度（left<size）-->这里长度size要和索引区分开
     * 如果超出虚拟数组长度size的
     * 先拿左节点（子树节点计算index * 2 + 1）
     */
    public void heapify(int[] arr, int index, int size) {
        /**
         * heapify重构构造应该是往下递归的，(这时候顶元素已经是新的），现在拿新的往下递归
         * 每次往下递归，都要对比小子树的三个节点，
         * 先计算左节点是否超出现在的虚拟数组长度（left<size）-->这里长度size要和索引区分开
         * 如果超出虚拟数组长度size的
         * 先拿左节点（子树节点计算index * 2 + 1）
         */
        int left = index * 2 + 1;
        //这里判断子节点索引 left <= size -1
        while (left <= size - 1) {
            //两次比较拿到三个节点最大值索引
            int largest = left + 1 <= size - 1 && arr[left + 1] >arr[left] ? left+1 : left;
            //先对比二个子节点，拿到最大的节点的索引，再去和父节点index比较，最终拿到largest
            //这里拿到了子树里面最大的元素索引
            largest = arr[largest] > arr[index] ? largest : index;
            //如果最大的就是index，结束循环，不然交换继续向下递归
            if (largest == index) {
                break;
            }
            //这里子节点大了，要交换父节点，向下传递
            swap(arr, largest, index);
            //继续向下，stack递归遍
            // 这里没有左右子树的概念是因为哪个节点出来了换位就基于哪个节点继续向下遍历。直到叶节点
            index = largest;
            //算下更新left去判断是否下次会越界
            left = index * 2 + 1;
        }

    }

    private void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

}
