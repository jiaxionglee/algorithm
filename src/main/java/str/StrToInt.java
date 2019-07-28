package str;

/**
 * 字符串转为整数
 *
 * @author jiaxiong
 * @date 2019-03-22 15:43
 */
public class StrToInt {

    private static final char POSITIVE = '+';
    private static final char NEGATIVE = '-';

    public static int strToInt(String str) {
        // save result
        int result = 0;
        // save symbol
        int flag = 0;
        if (str.charAt(0) == POSITIVE) {
            flag = 1;
        }
        if (str.charAt(0) == NEGATIVE) {
            flag = 2;
        }
        // 开始遍历的位置
        int start = flag > 0 ? 1 : 0;
        for (int i = start; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int temp = str.charAt(i) - '0';
                result = result * 10 + temp;
            } else {
                // 表示包含了非数字
                return 1;
            }
        }
        return flag > 1 ? -result : result;
    }

    /**
     * 利用API函数实现
     */
    public static int strToIntApi(String str) {
        return Integer.valueOf(str);
    }

    public static void main(String[] args) {
        String s = "+12312312";
        System.out.println("使用库函数转换：" + strToIntApi(s));
        int res = StrToInt.strToInt(s);
        System.out.println("使用自己写的方法转换：" + res);
    }
}
