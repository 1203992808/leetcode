/**
 * @author syz
 * @date 2018-12-19 20:19
 */
/***leetcode 4 无重复字符的最长子串
 * **/
public class Longest_Substring_Without_Reapeating_Character {
    public static  int   f1 (String str) {
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
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(f1(str));
    }

}
