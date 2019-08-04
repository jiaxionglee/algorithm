package sort;

/**
 * 冒泡排序
 * 算法实现基本描述：
 * 1）比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2）对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 3）针对所有的元素重复以上的步骤，除了第一个。
 * 4）持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * <p>
 *
 * @author jiaxiong
 * @date 2019-03-19 08:25
 */
public class BubbleSort {

    /**
     * 基本冒泡排序
     */
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

    /**
     * 优化后的冒泡排序
     */
    public static int[] bubbleSort2(int[] array) {
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
