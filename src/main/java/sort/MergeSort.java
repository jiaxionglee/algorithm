package sort;

/**
 * 归并排序
 * 实现算法基本描述：
 * 1）申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
 * 2）设定两个指针，最初位置分别为两个已经排序序列的起始位置
 * 3）比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
 * 4）重复步骤3直到某一指针超出序列尾
 * 5）最后将另一序列剩下的所有元素直接复制到合并序列尾
 * <p>
 *
 * @author jiaxiong
 * @date 2019-04-01 17:52
 */
public class MergeSort {

    /**
     * 二路归并原理：将两个有序表合并和一个有序表
     * <p>
     * a
     * s  第一个有序表的起始下标
     * m  第二个有序表的起始下标
     * t  第二个有序表的结束下标
     */
    private static void merge(int[] a, int s, int m, int t) {
        int[] tmp = new int[t - s + 1];
        int i = s, j = m, k = 0;
        while (i < m && j <= t) {
            if (a[i] <= a[j]) {
                tmp[k] = a[i];
                k++;
                i++;
            } else {
                tmp[k] = a[j];
                j++;
                k++;
            }
        }
        while (i < m) {
            tmp[k] = a[i];
            i++;
            k++;
        }
        while (j <= t) {
            tmp[k] = a[j];
            j++;
            k++;
        }
        System.arraycopy(tmp, 0, a, s, tmp.length);
    }

    /**
     * a
     * len  每次归并的有序集合的长度
     */
    public static void mergeSort(int[] a, int len) {
        int size = a.length;
        int mid = size / (len << 1);
        int c = size & ((len << 1) - 1);
        // 归并到只剩一个有序集合的时候结束算法
        if (mid == 0) {
            return;
        }
        // 进行一趟归并排序
        for (int i = 0; i < mid; ++i) {
            int s = i * 2 * len;
            merge(a, s, s + len, (len << 1) + s - 1);
        }
        // 将剩下的数和倒数一个有序集合归并
        if (c != 0) {
            merge(a, size - c - 2 * len, size - c, size - 1);
        }
        // 递归执行下一趟归并排序
        mergeSort(a, 2 * len);
    }
}
