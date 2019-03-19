package sort;

/**
 * Created by jiaxiong on 2019-03-19 08:25
 */
public class BubbleSort {

    private static void all(int i, int[] arr) {
        System.out.print("\n" + "第" + i + "次排序结果：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    //基本冒泡排序
    public static int[] bubbleSort(int[] arr) {
        //外层循环控制排序趟数，-1少循环一次
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环控制每一趟排序多少次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            all(i, arr);
        }
        return arr;
    }

    //优化后的冒泡排序
    public static int[] bubbleSort_op(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flag = true;
            int temp;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            }
            //没有发生数据交换的时候退出循环；
            if (flag) {
                break;
            }
            all(i, arr);
        }
        return arr;
    }

}
