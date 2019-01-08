import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: syz
 * @Date: 2019/1/8 09:57
 * @Description:
 */
/**
 * leetcode 386 字典序排序
 *
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 *
 * 例如，
 *
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 *
 * 请尽可能的优化
 *
 * 解法参考：https://www.cnblogs.com/tengdai/p/9281127.html
 *
 * **/
public class Lexicographical_Numbers {
    public static List<Integer> f1(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9 ; i++) {
            if (i > n) {
                break;
            }
            dfs(n,result,i);
        }
        return result;

    }
    private  static void dfs (int n,List<Integer> result,int i) {
        result.add(i);
        for (int j = 0; j <= 9 ; j++) {
            if (i * 10 + j > n) {
                break;
            }
            dfs(n,result,i*10 + j);

        }
    }
    public static List<Integer> f2 (int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        int pre = 1;
        for (int i = 1;i < n; i++) {
            if (pre * 10 <= n) {
                pre = pre * 10;
            } else {
                while (pre % 10 == 9 || pre == n) {
                    pre  = pre /10;
                }
                pre++;
            }
            result.add(pre);
        }
        return result;
    }
}
