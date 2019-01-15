import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * @author syz
 * @date 2019-01-15 20:42
 */
/*leetcode 7 整数反转

给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
*
* **/
public class Reverse_Integer {
    public static int f1 (int x) {
        if (x > Math.pow(2,31) - 1 || x < -Math.pow(2,31)) {
            return 0;
        }
        try {
            String str = String.valueOf(x);
            boolean isPos = true;
            if (str.charAt(0) == '-') {
                isPos = false;
            }
            StringBuilder sb = new StringBuilder(str);
            if (isPos) {
                return Integer.valueOf(sb.reverse().toString());
            } else {
                if (x == - Math.pow(x,31)) {
                    return 0;
                }
                str = str.substring(1);
                sb = new StringBuilder(str);
                return Integer.valueOf(sb.reverse().toString()) * (-1);

        }
        }catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
