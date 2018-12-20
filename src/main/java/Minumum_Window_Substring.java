/**
 * @author syz
 * @date 2018-12-20 20:11
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/***
 * leetcode 76 最小窗口子串
 * Hard 哈希实现最小窗口
 * 问题描述：
 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 Example:

 Input: S = "ADOBECODEBANC", T = "ABC"
 Output: "BANC"
 *
 * */
public class Minumum_Window_Substring {
    public static String f1(String s,  String t){
        int ArrayLen = 128;
        int[] map_s = new int[ArrayLen];
        int[] map_t = new int[ArrayLen];
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < t.length(); i++) {
            map_t[t.charAt(i)]++;
        }
        for (Character i = 0; i <ArrayLen ; i++) {
            if (map_t[i] > 0) {
                set.add(i);
            }
        }
        int begin = 0;
        String result = "";
        for (int i = 0; i <s.length() ; i++) {
            map_s[s.charAt(i)]++;
            while(begin <i) {
                char c = s.charAt(begin);
                if (map_t[c] == 0 ) {
                    begin++;
                } else if (map_s[c] > map_t[c]) {
                    map_s[c]--;
                    begin++;
                }else {
                    break;
                }
            }
            if (isWindowOk(map_s,map_t,set)) {
                int newLen = i - begin +1;
                if (result.equals("") || result.length() > newLen) {
                    result = s.substring(begin,i  + 1);
                }
            }
        }
        return result;

    }
    public static boolean isWindowOk(int[] map_s, int[] map_t, Set<Character> set){
        for (Character c: set) {
            if (map_s[c] < map_t[c]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADBECODEBANC";
        String t = "ABC";
      String result = f1(s,t);
        System.out.println(result);
    }
}
