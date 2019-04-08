package sort;

/**
 * 希尔排序
 * 原理：Shell排序法是对相邻指定距离(称为增量)的元素进行比较，并不断把增量缩小至1，完成排序。
 * <p>
 * Created by jiaxiong on 2019-04-02 17:29
 */
public class ShellSort {

    public static int[] shellSort(int[] array) {
        int d = array.length / 2;
        for (int inc = d; inc > 0; inc /= 2) {               // 循环的次数为增量缩小至1的次数
            for (int i = inc; i < array.length; ++i) {       // 循环的次数为第一个分组的第二个元素到数组的结束
                int j = i - inc;
                int temp = array[i];
                while (j >= 0 && array[j] > temp) {
                    array[j + inc] = array[j];
                    j = j - inc;
                }
                if ((j + inc) != i)        // 防止自我插入
                    array[j + inc] = temp; // 插入记录
            }
        }
        return array;
    }

}
