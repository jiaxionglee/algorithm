package str;

/**
 * @author jiaxiong
 * @date 2019-08-04 19:03
 */
public class DeleteSubString {

    /**
     * 删除字符串a中包含的字符串b，举例 输入a = “asdw”,b = “sd” 返回 字符串 “aw”
     */
    public static String deleteSubString(String str, String sub) {
        StringBuilder stringBuilder = new StringBuilder();

        // 当原始字符串或者子串为null时，返回空串
        if (str == null || sub == null) {
            return stringBuilder.toString();
        }
        // 当原始字符串或者子串长度为0时，返回原始字符串
        if (sub.length() == 0 || str.length() == 0) {
            return stringBuilder.append(str).toString();
        }
        // 当原始字符串长度小于子串长度时，返回原始字符串
        if (str.length() < sub.length()) {
            return stringBuilder.append(str).toString();
        }
        for (int i = 0; i < str.length(); i++) {
            if (i + sub.length() > str.length()) {
                stringBuilder.append(str.substring(i, str.length()));
                break;
            }
            if (!str.substring(i, (i + sub.length())).equals(sub)) {
                stringBuilder.append(str.substring(i, i + 1));
            } else {
                i = i + sub.length() - 1;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("==============a为null，b为null，a.length()<b,.length()=========");
        System.out.println("".equals(deleteSubString("", null)));
        System.out.println("".equals(deleteSubString(null, "")));
        System.out.println("".equals(deleteSubString(null, null)));
        System.out.println("ab".equals(deleteSubString("ab", "abcd")));
        System.out.println("=============a匹配不到b============");
        System.out.println("".equals(deleteSubString("", "")));
        System.out.println("a".equals(deleteSubString("a", "")));
        System.out.println("ab".equals(deleteSubString("ab", "")));
        System.out.println("================a匹配到b部分一次==================");
        System.out.println("ab".equals(deleteSubString("ab", "ac")));
        System.out.println("cab".equals(deleteSubString("cab", "ac")));
        System.out.println("ba".equals(deleteSubString("ba", "ac")));
        System.out.println("================a匹配到b部分一次后，成功匹配到b=================");
        System.out.println("ac".equals(deleteSubString("acab", "ab")));
        System.out.println("a".equals(deleteSubString("aab", "ab")));
        System.out.println("================a完整匹配到b一次==================");
        System.out.println("".equals(deleteSubString("a", "a")));
        System.out.println("".equals(deleteSubString("ab", "ab")));
        System.out.println("b".equals(deleteSubString("bab", "ab")));
        System.out.println("bc".equals(deleteSubString("babc", "ab")));
        System.out.println("==============a匹配到b一次，第二次部分匹配到b=============");
        System.out.println("a".equals(deleteSubString("aba", "ab")));
        System.out.println("ca".equals(deleteSubString("abca", "ab")));
        System.out.println("ca".equals(deleteSubString("caba", "ab")));
        System.out.println("cca".equals(deleteSubString("cabca", "ab")));
        System.out.println("====================================================");
        System.out.println("==================a匹配到b多次=====================");
        System.out.println("".equals(deleteSubString("aaaaaaaa", "a")));
        System.out.println("".equals(deleteSubString("abababababab", "ab")));
        System.out.println("b".equals(deleteSubString("aaaabaaaa", "a")));
        System.out.println("b".equals(deleteSubString("baaaaaaaa", "a")));
        System.out.println("b".equals(deleteSubString("aaaaaaaab", "a")));
        System.out.println("===================随机测试=======================");
        System.out.println("".equals(deleteSubString("asdwwdaaa", "wd")));
        System.out.println("".equals(deleteSubString("123d2e231", "0")));
        System.out.println("".equals(deleteSubString("测试000", "测试")));
        System.out.println("".equals(deleteSubString("\n", "")));
        System.out.println("====================有重叠============================");
        System.out.println("".equals(deleteSubString("ababa", "aba")));
        System.out.println("cccc".equals(deleteSubString("ccababacc", "aba")));
        System.out.println("".equals(deleteSubString("abcabca", "abca")));
        System.out.println("==============一次截取后仍然包含目标字段================");
        System.out.println("".equals(deleteSubString("aabb", "ab")));
    }
}
