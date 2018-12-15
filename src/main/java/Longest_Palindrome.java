/**
 * @author syz
 * @date 2018-12-15 18:06
 */
/**
 * leetcode 409 最长回文子串
 * 问题描述
 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

 在构造过程中，请注意区分大小写。比如 “Aa” 不能当做一个回文字符串。

 注意:
 假设字符串的长度不会超过 1010。

 示例 1:

 输入:
 “abccccdd”

 输出:
 7

 解释:
 我们可以构造的最长的回文串是”dccaccd”, 它的长度是 7。
 *
 * */
public class Longest_Palindrome {
    public static int  f1 (String str) {
        char[] chs = str.toCharArray();
        char[] map = new char[128];
        for (int i = 0; i <chs.length ; i++) {
            map[chs[i]]++;
        }
        int max = 0;
        int flag = 0;
        for (int i = 0; i <128 ; i++) {
            if (map[i] %2 == 0) {
                max += map[i];
            } else {
                max += map[i]  - 1;
                flag = 1;
            }

        }
        return max + flag;
    }

    public static void main(String[] args) {
        String str = "abccccddaa";
        System.out.println(f1(str));
    }
}
