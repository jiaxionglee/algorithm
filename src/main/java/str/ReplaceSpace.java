package str;

/**
 * 替换空格
 *
 * @author jiaxiong
 * @date 2019-03-22 15:35
 */
public class ReplaceSpace {

    /**
     * 常规方法
     */
    public static String replaceSpace(StringBuilder sb) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            // 取出单个字符
            char c = sb.charAt(i);
            if (" ".equals(String.valueOf(c))) {
                // 如果是空格就追加替换后的字符
                result.append("%20");
            } else {
                // 不是空格就直接追加
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * 利用API函数实现
     */
    public static String replaceSpace2(StringBuilder sb) {
        return sb.toString().replace(" ", "%20");
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("we are employee");
        System.out.println(replaceSpace2(sb));
        System.out.println(replaceSpace(sb));
    }
}
