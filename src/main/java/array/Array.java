package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数组
 *
 * @author jiaxiong
 * @date 2019-04-10 10:31
 */
public class Array {

    private static final char ZERO = '0';

    /**
     * 给出一个数组，如 [7864, 284, 347, 7732, 8498]，
     * 现在需要将数组中的数字拼接起来，如按顺序依次拼接为：786428434777328498，
     * 数组中的数字拼接顺序可以任意，编写程序，返回「最大的可能拼出的数字」。（以上面数组为例，返回：849878647732347284）
     */
    public static String largestNumber(int[] nums) {
        List<String> numString = new ArrayList<>();
        for (int num : nums) {
            numString.add(String.valueOf(num));
        }
        numString.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder sb = new StringBuilder();
        for (String s : numString) {
            sb.append(s);
        }
        // 如果字符串的第一个字符为0，就返回0
        if (sb.charAt(0) == ZERO) {
            return "0";
        }
        return sb.toString();
    }

    /**
     * 旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
     * 示例:
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     */
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        // 旋转所有元素
        reverse(nums, 0, nums.length - 1);
        // 反转前k个元素
        reverse(nums, 0, k - 1);
        // 反转后面nums.length-k个元素
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int component = target - nums[i];
            if (map.containsKey(component)) {
                return new int[]{map.get(component), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] nums = {7864, 284, 347, 7732, 8498};
        System.out.println("==============largestNumber=================");
        System.out.println(largestNumber(nums));
        System.out.println("==============rotate===============");
        rotate(nums, 2);
        for (int num : nums) {
            System.out.println(num);
        }
        System.out.println("==============twoSum===============");
        int[] num = {2, 7, 11, 15};
        int target = 9;
        for (int inum : twoSum(num, target)) {
            System.out.println(inum);
        }

    }
}
