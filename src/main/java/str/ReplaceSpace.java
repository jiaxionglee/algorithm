package str;

/**
 * 替换空格
 * Created by jiaxiong on 2019-03-22 15:35
 */
public class ReplaceSpace {

    public static String replaceSpace(StringBuilder sb) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);                  // 取出单个字符
            if (String.valueOf(c).equals(" ")) {    // 如果是空格就追加替换后的字符
                result.append("%20");
            } else {
                result.append(c);                   // 不是空格就直接追加
            }
        }
        return result.toString();
    }

    // 利用系统函数实现
    public static String replaceSpace2(StringBuilder sb) {
        return sb.toString().replace(" ", "%20");
    }
}
