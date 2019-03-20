package sort;

/**
 * 冒泡排序
 * Created by jiaxiong on 2019-03-19 08:25
 */
public class BubbleSort {

    //基本冒泡排序
    public static int[] bubbleSort(int[] array) {
        //外层循环控制排序趟数，-1少循环一次
        for (int i = 0; i < array.length - 1; i++) {
            //内层循环控制每一趟排序多少次
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    //优化后的冒泡排序
    public static int[] bubbleSort_op(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            int temp;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            //没有发生数据交换的时候退出循环；
            if (flag) {
                break;
            }
        }
        return array;
    }

}
