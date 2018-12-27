/**
 * @author syz
 * @date 2018-12-27 21:16
 */

import java.util.HashMap;
import java.util.Map;

/***
 *leetcode 266 回文变换
 *Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.！
 * **/
public class Palindrome_Permutation {
    public static boolean f1 (String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Map<Character,Integer> map = new HashMap();
        for (int i = 0; i < str.length() ; i++) {
            if ( !map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i),1);
            } else {
                map.put(str.charAt(i),map.get(str.charAt(i) ) +1);
            }
        }
        int count = 0;
        for (char c:map.keySet()) {
            if (map.get(c) % 2 == 0) {
                continue;
            }else {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "code";
        System.out.println(f1(str));
    }
}
