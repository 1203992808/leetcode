/**
 * @author syz
 * @date 2018-12-30 19:24
 */

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;

/***
 * leetcode 88 格雷编码
 * 例如 2
 * {0,1,3,2}
 *二进制数转格雷码：首位1不变，后面剩余的位依次与前一位异或得到。
 * */
public class Gray_Code {
    public static ArrayList<Integer> f1 (int n) {
        ArrayList<Integer> result = new ArrayList();
        result.add(0);
        int cur = 0;
        for (int i = 0; i < n ; i++) {
            int change = 1 << i;
            cur = result.size() - 1;
            while (cur >= 0) {
                result.add(result.get(cur)^change);
                cur--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> result = f1(2);
        int i = 2;
    }
}
