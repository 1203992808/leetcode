/**
 * @author syz
 * @date 2019-01-06 17:22
 */
/**
 * leetcode 191 二进制中1的个数
 * **/
public class Number_Of_1_bit {
    public static int f1 ( int n) {
        int res = 0;
        while (n != 0) {
            n = n&(n - 1);
            res++;
        }
        return res;
    }
    public static  int f2 (int n) {
        int res = 0;
        while (n != 0) {
            n -= n&(~n +1);
            res++;
        }
        return res;
    }
}
