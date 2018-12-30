/**
 * @author syz
 * @date 2018-12-30 19:50
 */
/**
 *letcode 461 汉明距离
 *两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

 给出两个整数 x 和 y，计算它们之间的汉明距离。

 注意：
 0 ≤ x, y < 231.

 示例:

 输入: x = 1, y = 4

 输出: 2

 解释:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 上面的箭头指出了对应二进制位不同的位置。
 *
 * **/
public class Hanming_Distance {
    public static int f1 (int x,int y) {
        int diff = x^y;
        int count = 0;
        while (diff != 0) {
            diff &= (diff - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(f1(1,4));
    }
}
