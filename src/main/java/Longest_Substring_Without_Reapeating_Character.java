/**
 * @author syz
 * @date 2018-12-19 20:19
 */

import java.util.HashMap;
import java.util.Map;

/***leetcode 4 无重复字符的最长子串
 * **/
public class Longest_Substring_Without_Reapeating_Character {
    public static  int   f1 (String str) { //用数组实现哈希表
        if (str == null || str.length() == 0) {
            return 0;
        }
        int begin = 0;
        char[] map  = new char[128];
        String word = "";
        int result = 0;
        for (int i = 0; i < str.length() ; i++) {
            map[str.charAt(i)]++;
            if (map[str.charAt(i)] == 1) {
                word = word + map[str.charAt(i)];
                if (result < word.length()) {
                    result = word.length();
                }
            } else {
                while (begin < i && map[str.charAt(i)]> 1) {
                    begin++;
                    map[str.charAt(begin)]--;
                }
            }
            word = "";
            StringBuilder sb = new StringBuilder();
            for (int j = begin; j <= i ; j++) {
                  sb.append(str.charAt(j));
            }
            word = sb.toString();
        }
        return result;
    }
    public static int f2 (String str) {//用java自带的map
        if (str == null || str.length() == 0) {
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        int slow = 0;
        int fast = 0;
        int max = 0;
        for ( fast = 0; fast <str.length() ; fast++) {
            char currentChar = str.charAt(fast);
            if (map.get(currentChar) == null) {
                map.put(currentChar,fast);
                max = Math.max(max,fast - slow +1);
            } else {
                int lastPosition = map.get(currentChar);
                if (lastPosition < slow) {
                    map.put(currentChar,fast);
                    max = Math.max(max,fast - slow +1);
                } else {
                    slow = lastPosition +1;
                    map.put(currentChar,fast);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(f1(str));
        System.out.println(f2(str));
    }

}
