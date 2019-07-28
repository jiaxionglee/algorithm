package str;

/**
 * 最长公共前缀
 *
 * @author jiaxiong
 * @date 2019-07-28 14:33
 */
public class LongestCommonPrefix {

    private static boolean checkStrings(String[] strings) {
        if (strings == null || strings.length == 0) {
            return true;
        }
        for (String str : strings) {
            // 检查数组每一个元素值
            if (str == null || str.length() == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 1、判断数组是否合法
     * 2、查找最长公共子串：用第一个字符串的长度遍历查找
     */
    public static String longestCommonPrefix(String[] strings) {
        // 1、检查值不合法就返回空串
        if (checkStrings(strings)) {
            return "";
        }
        // 2、查找最长公共前缀
        int index = 0;
        for (int i = 0; i < strings[0].length(); i++) {
            char prefix = strings[0].charAt(index);
            for (String str : strings) {
                // 字符串长度等于循环次数时即最大长度所以退出
                if (str.length() == i || prefix != str.charAt(index)) {
                    return str.substring(0, index);
                }
            }
            index++;
        }
        return strings[0].substring(0, index);
    }

    public static void main(String[] args) {
        String[] strings = {"2leets", "2leet", "2leet", "2leeds"};
//        String[] strings = {"leets", "leetcode", "leet", null};
//        String[] strings = {};
//        String[] strings = null;
        System.out.println(longestCommonPrefix(strings));
    }
}
