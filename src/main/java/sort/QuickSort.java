package sort;

/**
 * 快速排序
 * 算法实现基本描述：
 * 1）设置两个变量i、j，排序开始的时候：i=0，j=N-1；
 * 2）以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
 * 3）从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]和A[i]的值交换；
 * 4）从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于等于key的A[i]，将A[i]和A[j]的值交换；
 * 5）重复第3、4步，直到i=j。
 * Created by jiaxiong on 2019-03-20 11:14
 */
public class QuickSort {

    public static int[] quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        int i = start;
        int j = end;
        int baseVal = array[start];
        while (i < j) {
            //从右往左找
            while (i < j && array[j] >= baseVal) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            //从左往右找
            while (i < j && array[i] < baseVal) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = baseVal;
        //递归调用，把baseVal前面的完成排序
        quickSort(array, start, i - 1);
        //递归调用，把baseVal后面的完成排序
        quickSort(array, i + 1, end);
        return array;
    }
}
