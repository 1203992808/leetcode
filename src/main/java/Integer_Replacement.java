/**
 * @Auther: syz
 * @Date: 2019/1/2 11:44
 * @Description:
 */
/** leetcode 397 整数替换
 * 给定一个正整数 n，你可以做如下操作：
 *
 * 1. 如果 n 是偶数，则用 n / 2替换 n。
 * 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 * n 变为 1 所需的最小替换次数是多少？
 *
 * 示例 1:
 *
 * 输入:
 * 8
 *
 * 输出:
 * 3
 *
 * 解释:
 * 8 -> 4 -> 2 -> 1
 * 示例 2:
 *
 * 输入:
 * 7
 *
 * 输出:
 * 4
 *
 * 解释:
 * 7 -> 8 -> 4 -> 2 -> 1
 * 或
 * 7 -> 6 -> 3 -> 2 -> 1
 *
 * **/
public class Integer_Replacement {
    public static int f1 (int n) {
        if ( n == Integer.MAX_VALUE) {
            return 32;
        }
        if (n <= 1) {
            return 0;
        }
        if ((n & 1) == 0) {
            return 1 + f1(n/2);
        } else {
            return  1 + Math.min(f1(n - 1),f1(n +1));
        }
    }
    public static int f2 (int n) {
        if (n == Integer.MAX_VALUE) {
            return 32;
        }
        if (n <= 1) {
            return 0;
        }
        int count = 0;
        while (n != 1) {
            if ((n & 1) == 0) {
                n = n/2;
                count++;
            } else {
                if (n == 3) {
                    n = 2;
                } else if (countZero(n - 1)> countZero(n + 1)){
                    n--;

                } else {
                    n++;
                }
                count++;
            }
        }
        return count;

    }
    public static int countZero(int n) {
        int count = 0;
        while ((n & 1) == 0) {
            count++;
            n = n>>1;
        }
        return count;
    }
}
