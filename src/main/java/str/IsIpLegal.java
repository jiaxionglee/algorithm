package str;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 判断一个ip是否合法
 * ip地址范围：(1~255).(0~255).(0~255).(0~255)
 * <p>
 *
 * @author jiaxiong
 * @date 2019-04-10 10:16
 */
public class IsIpLegal {

    private static final int IP_MIN_LENGTH = 7;
    private static final int IP_MAX_LENGTH = 15;
    private static final char IP_SEPARATOR = '.';

    public static boolean isIpLegal(String str) {
        //1.检查ip是否为空
        if (str == null) {
            return false;
        }

        //2.检查ip长度，最短为：x.x.x.x(7位)，最长为：xxx.xxx.xxx.xxx(15位)
        if (str.length() < IP_MIN_LENGTH || str.length() > IP_MAX_LENGTH) {
            return false;
        }

        //3.输入字符串的首末字符是"."，则是非法IP
        if (str.charAt(0) == IP_SEPARATOR || str.charAt(str.length() - 1) == IP_SEPARATOR) {
            return false;
        }

        //4.按"."分割字符串后不是4个数字，则是非法IP
        String[] arr = str.split("\\.");
        if (arr.length != 4) {
            return false;
        }

        //5.对分割出来的每个字符串进行单独判断
        for (String subArr : arr) {
            //如果每个字符串不是一位字符，且以'0'开头，则是非法的IP，如：01.002.03.004
            if (subArr.length() > 1 && subArr.charAt(0) == '0') {
                return false;
            }
            //对每个字符串的每个字符进行逐一判断，如果不是数字0-9，则是非法的IP
            for (int j = 0; j < subArr.length(); j++) {
                if (subArr.charAt(j) < '0' || subArr.charAt(j) > '9') {
                    return false;
                }
            }
        }

        //6.把拆分的每一个字符串转换成数字，并判断是否在0~255范围之内
        for (int i = 0; i < arr.length; i++) {
            int temp = Integer.parseInt(arr[i]);
            if (i == 0) {
                if (temp < 1 || temp > 255) {
                    return false;
                }
            } else {
                if (temp < 0 || temp > 255) {
                    return false;
                }
            }
        }

        //7.最后，说明是合法的IP
        return true;
    }

    /**
     * 正则表达式判断
     */
    public static boolean isIpLegalReg(String ipStr) {

        String ipRegEx = "^([1-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))" +
                "(\\.([0-9]|([1-9][0-9])|(1[0-9][0-9])|(2[0-4][0-9])|(25[0-5]))){3}$";
        Pattern pattern = Pattern.compile(ipRegEx);
        Matcher matcher = pattern.matcher(ipStr);
        return matcher.matches();
    }
}
