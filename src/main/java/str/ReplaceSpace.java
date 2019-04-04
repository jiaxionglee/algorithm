package str;

/**
 * 替换空格
 * Created by jiaxiong on 2019-03-22 15:35
 */
public class ReplaceSpace {

    public static String replaceSpace(StringBuilder sb) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (String.valueOf(c).equals(" ")) {
                result.append("%20");
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
}
