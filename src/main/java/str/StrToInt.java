package str;

/**
 * 字符串转为整数
 * Created by jiaxiong on 2019-03-22 15:43
 */
public class StrToInt {

    public static int strToInt(String str) {
        //save result
        int result = 0;
        //save symbol
        int flag = 0;
        if (str.charAt(0) == '+') {
            flag = 1;
        }
        if (str.charAt(0) == '-') {
            flag = 2;
        }
        //开始遍历的位置
        int start = flag > 0 ? 1 : 0;
        for (int i = start; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int temp = str.charAt(i) - '0';
                result = result * 10 + temp;
            } else {
                //表示包含了非数字
                return 1;
            }
        }
        return flag > 1 ? -result : result;
    }
}
