package str;

import java.util.Stack;

/**
 * 判断字符串中的"()"、"[]"、"{}"是否匹配
 * 利用栈实现
 *
 * @author jiaxiong
 * @date 2019-03-22 16:06
 */
public class Match {

    public static boolean isMatch(String s) {
        Stack<Character> sc = new Stack<>();
        char[] array = s.toCharArray();

        for (char c : array) {
            if (c == '(') {
                sc.push(')');
            }
            if (c == '[') {
                sc.push(']');
            }
            if (c == '{') {
                sc.push('}');
            }
            if (c == ')' || c == ']' || c == '}') {
                if (sc.empty()) {
                    return false;
                }
                if (sc.pop() != c) {
                    return false;
                }
            }
        }
        // 如果为空表示匹配
        return sc.empty();
    }
}
