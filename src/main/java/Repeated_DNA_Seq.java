/**
 * @author syz
 * @date 2018-12-19 20:36
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *   leetcode187. 重复的DNA序列
 *所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。

 编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。

 示例:

 输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"

 输出: ["AAAAACCCCC", "CCCCCAAAAA"]
 *
 * */
public class Repeated_DNA_Seq {
    public static List<String> f1 (String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<String>();
        }
        ArrayList<String> list = new ArrayList<String>();
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i <str.length() - 10 ; i++) {
            String curStr = str.substring(i,i+10);
            if (map.containsKey(curStr)) {
                if (map.get(curStr) < 2){
                    list.add(curStr);
                }
                map.put(curStr,2);
            } else {
                map.put(curStr,1);
            }

        }
        return list;
    }

    public static void main(String[] args) {
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        ArrayList<String> list = (ArrayList<String>) f1(str);

    }
}
