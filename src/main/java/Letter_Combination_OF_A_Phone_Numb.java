/**
 * @author syz
 * @date 2018-12-31 13:54
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****
 * leetcode 17 电话号码的组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

 示例:

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 *
 */

public class Letter_Combination_OF_A_Phone_Numb {
    public  static List<String> f1 (String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        Map<Integer,String> map = new HashMap<>();
        map.put(0,"");
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        StringBuilder sb = new StringBuilder();
        dfs(digits,result,sb,0,map);
        return result;


    }
    public  static void dfs(String digits,List<String> result,StringBuilder sb,int start,Map<Integer,String> map) {
        if (start == digits.length()) {
            result.add(sb.toString());
            return;
        }
        String str = map.get(digits.charAt(start)-'0');
        for (int i = 0; i <str.length(); i++) {
            sb.append(str.charAt(i));
            dfs(digits,result,sb,start + 1,map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String str = "23";
        List<String> result = f1(str);
        int i = 5;
    }
}
