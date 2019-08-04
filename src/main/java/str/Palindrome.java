package str;

import java.util.HashSet;

/**
 * 回文串
 *
 * @author jiaxiong
 * @date 2019-07-28 16:00
 */
public class Palindrome {
    /**
     * 最长回文串,解法1
     */
    public int longestPalindrome(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int count = 0;
        char[] chars = s.toCharArray();
        HashSet<Character> hashSet = new HashSet<Character>();
        for (char element : chars) {
            // 如果集合中没有该字符就保存
            if (!hashSet.contains(element)) {
                hashSet.add(element);
            } else {
                hashSet.remove(element);
                count++;
            }
        }
        return hashSet.isEmpty() ? count * 2 : count * 2 + 1;
    }

    /**
     * 最长回文串解法2
     * leetcode 官方解题，https://leetcode-cn.com/problems/longest-palindrome/solution/zui-chang-hui-wen-chuan-by-leetcode/
     */
    public int longestPalindrome1(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int ans = 0;
        for (int v : count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 验证回文串
     */
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    /**
     * 验证回文串，aba,abca都是回文串，支持最多删除一个字符
     */
    public boolean validPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
            }
            left++;
            right--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 验证回文串
     */
    public boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            if ((chars[left]) != chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 回文链表
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        // todo
        return false;
    }

    public static void main(String[] args) {
        System.out.println("=======最长回文串========");
        String s = "abc";
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.longestPalindrome(s));
        System.out.println("=======验证回文串========");
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(palindrome.isPalindrome(s1));
        String s2 = "race a car";
        System.out.println(palindrome.isPalindrome(s2));
        System.out.println("=======验证回文串2========");
        String s3 = "tebbem";
        String s4 = "abca";
        System.out.println(palindrome.validPalindrome(s3));
        System.out.println(palindrome.validPalindrome(s4));
        System.out.println("=======验证回文串========");
        int x = 1;
        System.out.println(palindrome.isPalindrome(x));
    }
}
