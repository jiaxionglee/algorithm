package sort;

/**
 * 选择排序
 * Created by jiaxiong on 2019-03-19 17:31
 */
public class SelectionSort {

    public static int[] selectionSort(int[] arrary) {
        if (arrary.length == 0) {
            return arrary;
        }
        for (int i = 0; i < arrary.length-1; i++) {
            int minIndex = i;
            for (int j = i; j < arrary.length; j++) {
                if (arrary[j] < arrary[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arrary[minIndex];
            arrary[minIndex] = arrary[i];
            arrary[i] = tmp;
        }
        return arrary;
    }
}
