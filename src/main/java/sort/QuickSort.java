package sort;

/**
 * Created by jiaxiong on 2019-03-20 11:14
 */
public class QuickSort {

    public static int[] quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return array;
        }
        int i = start;
        int j = end;
        int baseval = array[start];
        while (i < j) {
            //从右往左找
            while (i < j && array[j] >= baseval) {
                j--;
            }
            if (i < j) {
                array[i] = array[j];
                i++;
            }
            //从左往右找
            while (i < j && array[i] < baseval) {
                i++;
            }
            if (i < j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = baseval;
        quickSort(array, start, i - 1);
        quickSort(array, i + 1, end);
        return array;
    }
}
