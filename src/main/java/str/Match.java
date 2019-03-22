package str;

import java.util.Stack;

/**
 * Created by jiaxiong on 2019-03-22 16:06
 */
public class Match {

    private static boolean isMatch(String s) {
        Stack<Character> sc = new Stack<Character>();
        char[] array = s.toCharArray();

        for (char c : array) {
            if (c == '(')
                sc.push(')');
            if (c == '[')
                sc.push(']');
            if (c == '{')
                sc.push('}');
            if (c == ')' || c == ']' || c == '}') {
                if (sc.empty()) {
                    return false;
                }
                if (sc.pop() != c) {
                    return false;
                }
            }
        }
        return sc.empty();
    }
}
