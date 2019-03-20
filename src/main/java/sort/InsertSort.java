package sort;

/**
 * Created by jiaxiong on 2019-03-20 10:43
 */
public class InsertSort {

    public static int[] insertSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        int current;
        //外层循环控制需要排序的趟数
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            //如果前一位(已排序的数据)比当前数据要大
            while (preIndex >= 0 && current < array[preIndex]) {
                //往后退一个位置，让当前数据与之前前位进行比较
                array[preIndex + 1] = array[preIndex];
                //不断往前，直到退出循环
                preIndex--;
            }
            //退出循环说明找到了合适的位置，将当前数据插入
            array[preIndex + 1] = current;
        }
        return array;
    }
}
