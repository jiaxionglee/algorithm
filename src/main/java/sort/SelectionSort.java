package sort;

/**
 * 选择排序
 * Created by jiaxiong on 2019-03-19 17:31
 */
public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        //外层循环控制需要排序的趟数
        for (int i = 0; i < array.length-1; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                //找到最小的数
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }
        return array;
    }
}
