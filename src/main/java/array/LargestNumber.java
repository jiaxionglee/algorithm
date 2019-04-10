package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个数组，如 [7864, 284, 347, 7732, 8498]，
 * 现在需要将数组中的数字拼接起来，如按顺序依次拼接为：786428434777328498，
 * 数组中的数字拼接顺序可以任意，编写程序，返回「最大的可能拼出的数字」。（以上面数组为例，返回：849878647732347284）
 * <p>
 * Created by jiaxiong on 2019-04-10 10:31
 */
public class LargestNumber {

    public static String largestNumber(int[] nums) {
        List<String> numString = new ArrayList<>();
        for (int num : nums) {
            numString.add(String.valueOf(num));
        }
        numString.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        numString.forEach(s -> sb.append(s));
        // 如果字符串的第一个字符为0，就返回0
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
