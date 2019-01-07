/**
 * @Auther: syz
 * @Date: 2019/1/7 11:20
 * @Description:
 */
/**
 * leetcode 263 丑数I
 *编写一个程序判断给定的数是否为丑数
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 *
 * 示例 1:
 *
 * 输入: 6
 * 输出: true
 * 解释: 6 = 2 × 3
 * 示例 2:
 *
 * 输入: 8
 * 输出: true
 * 解释: 8 = 2 × 2 × 2
 * 示例 3:
 *
 * 输入: 14
 * 输出: false
 * 解释: 14 不是丑数，因为它包含了另外一个质因数 7。
 *
 * ***/
public class Ugly_Number_I {
    public static boolean f1 (int arr) {
        if (arr <= 0) {
            return false;
        }
        while (arr % 2 == 0) {
            arr = arr / 2 ;
        }
        while (arr % 3 == 0) {
            arr = arr / 3 ;
        }
        while (arr % 5 == 0) {
            arr = arr / 5 ;
        }
        return arr == 1 ;

    }
}
