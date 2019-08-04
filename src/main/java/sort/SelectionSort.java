package sort;

/**
 * 选择排序
 * 算法实现基本描述：
 * 1）第一层循环从起始元素开始选到倒数第二个元素，主要是在每次进入的第二层循环之前，将外层循环的下标赋值给临时变量，
 * 2）第二层循环中，如果发现有比这个最小位置处的元素更小的元素，则将那个更小的元素的下标赋给临时变量，
 * 3）在第二层循环退出后，如果临时变量改变，则说明，有比当前外层循环位置更小的元素，需要将这两个元素交换.
 * <p>
 *
 * @author jiaxiong
 * @date 2019-03-19 17:31
 */
public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        //外层循环控制需要排序的趟数
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                //找到最小的数
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 将最小元素放到本次循环的前面
            int tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }
        return array;
    }
}
