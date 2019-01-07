import java.util.Map;

/**
 * @Auther: syz
 * @Date: 2019/1/7 11:24
 * @Description:
 */
/*
 leetcode 264 丑数II
* 编写一个程序，找出第 n 个丑数。

丑数就是只包含质因数 2, 3, 5 的正整数。

示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
说明:

1 是丑数。
n 不超过1690。
*
* **/
public class Ugly_Number_II {
    public static int f1 (int n) {
        int[] help = new int[n];
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        help[0] = 1;
        int index = 1;
        while (index < n) {
            help[index] = Math.min(help[i2] * 2,Math.min(help[i3]* 3,help[i5]* 5));
            if (help[index] == help[i2] *2) {
                i2++;
            }
            if (help[index] == help[i3] *3) {
                i3++;
            }
            if (help[index] == help[i5] *5) {
                i5++;
            }
            index++;
        }
        return help[--index];
    }

    public static void main(String[] args) {
        System.out.println(f1(4));
    }

}
