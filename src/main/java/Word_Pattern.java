/**
 * @author syz
 * @date 2018-12-18 20:15
 */

import java.util.HashMap;

/***
 * leetcode 290 词语模式
 Given a pattern and a string str, find if str follows the same pattern.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 Both pattern and str contains only lowercase alphabetical letters.
 Both pattern and str do not have leading or trailing spaces.
 Each word in str is separated by a single space.
 Each letter in pattern must map to a word with length that is at least 1.
 *
 * **/
public class Word_Pattern {
    public static boolean f1 (String pattern,String str) {
        if (str == null || pattern == null) {
            return false;
        }
        String[] strs = str.split(" ");
        HashMap<Character,String> map1 = new HashMap<Character, String>();
        HashMap<String,Character> map2 = new HashMap<String, Character>();
        int len1 = pattern.length();
        int len2 = strs.length;
        if (len1 != len2) {
            return false;
        }
        for (int i = 0; i < len1 ; i++) {
            if (map1.get(pattern.charAt(i)) == null) {
                map1.put(pattern.charAt(i),strs[i]);
            } else {
                if (! map1.get(pattern.charAt(i)).equals( strs[i])) {
                    return false;
                }
            }
        }
        for (int i = 0; i < len1 ; i++) {
            if (map2.get(strs[i]) == null) {
                map2.put(strs[i],pattern.charAt(i));
            } else {
                if ( !map2.get(strs[i]).equals( pattern.charAt(i)) ){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String strs = "dog cat cat fish";
        String pattern = "abba";
        System.out.println(f1(pattern,strs));
    }
}
