import static sort.BubbleSort.bubbleSort_op;
import static  sort.BubbleSort.bubbleSort;

/**
 * Created by jiaxiong on 2019-03-19 14:03
 */
public class SortTest {

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 9, 1};
//        int[] arr = {1, 2, 3, 8, 6, 9};
//        int[] arr = {1, 2, 3, 6, 8, 9};
        System.out.print("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        bubbleSort(arr);
//        bubbleSort_op(arr);
        System.out.print("\n\n" + "排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
