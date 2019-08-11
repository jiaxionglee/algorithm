package other;

/**
 * 1~9999数列中数字3出现的次数。用递推方法解出。
 *
 * @author jiaxiong
 * @date 2019-08-04 16:34
 */
public class CountNumTimes {

    /*
    1位数： 0～9，1个
    0~99之间：共有10个0~9（解释0～9，10～19，。。。90～99），故有10*1=10次，而十位为1的有10次，共10+10=20次
    0~999之间：共有10个0~99（解释0～99，100～199，。。。900～999），故有10*20=200次，而百位为1的有100次，共200+100=300次
    0~9999之间：共有10个0~999（解释0～999，1000～1999，。。。9000～9999），故有10*300=3000次，而千位为1的有1000次，共3000+1000=4000次
    依此类推

    f(1)=1
    f(2)=10*f(1)+10
    f(3)=10*f(2)+100
    .
    .
    .
    f(n)=10*f(n-1)+10的n-1次方
    */

    /**
     * 统计非0数字在9，99，999，...，之间出现的次数
     */
    public static int countNumTimes(int number) {
        if (number < 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return 10 * countNumTimes(number - 1) + (int) Math.pow(10, number - 1);
    }

    /*
    1位数： 0～9，1个
    0~99之间：1+9=10
    0~999之间：1+9 + 个位数（9*10）+十位数（9*10）=190
    0~9999之间：190 + 个位数（9*100）+ 十位数（9*100）+百位数（9*100）=2890
    依此类推

    f(1)=1
    f(2)=f(1)+(2-1)*9*1
    f(3)=f(2)+(3-1)*9*10
    f(4)=f(3)+(4-1)*9*100
    .
    .
    .
    f(n)=f(n-1)+(n-1)*9*(10的n-2次方)
    */

    /**
     * 统计数字0在9，99，999，...，之间出现的次数
     */
    public static int countZeroTimes(int number) {
        if (number < 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        int pow = (int) Math.pow(10, number - 2);
        return countZeroTimes(number - 1) + (number - 1) * 9 * pow;
    }

    public static int countDigitNumber(int num) {
        return String.valueOf(num).length();
    }

    public static void main(String[] args) {
        int num = 99999;
        System.out.println(countDigitNumber(num));
        System.out.println(countNumTimes(countDigitNumber(num)));
        System.out.println(countZeroTimes(countDigitNumber(num)));
    }
}
