/**
 * @author syz
 * @date 2018-12-27 20:58
 */

import java.util.HashMap;
import java.util.Map;

/***
 * leetcode 246 对称数
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Write a function to determine if a number is strobogrammatic. The number is represented as a string.

 Example 1:

 Input:  "69"
 Output: true
 Example 2:

 Input:  "88"
 Output: true
 Example 3:

 Input:  "962"
 Output: false
 * **/
public class Strobogramamtic_Number {
    public static boolean f1 (String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');
        int low = 0;
        int high = str.length() - 1;
        while (low <= high) {
            if (map.get(str.charAt(low)) == null || map.get(str.charAt(low)) != str.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "989";
        System.out.println(f1(str));
    }
}
