/**
 * @author jiaxiong
 * @date 2019-03-28 10:26
 */
public class Print {

    public static void arrPrint(int i, int[] arr) {
        System.out.print("\n" + "第" + i + "次排序结果：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
