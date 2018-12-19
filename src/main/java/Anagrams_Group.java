/**
 * @author syz
 * @date 2018-12-18 20:43
 */

import java.util.*;

/***
 * D 
 * 49. Group Anagrams
 Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 ---------------------
 *
 *
 * **/
public class Anagrams_Group {
    public static List<List<String>> f1(String[] strs){
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        Arrays.sort(strs);
        Map<String,List<String>> map = new HashMap<String, List<String>>();
        for (String str: strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String chStr = String.valueOf(chs);
            if (map.get(chStr) == null) {
                map.put(chStr,new ArrayList());
            }
            map.get(chStr).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        String[] strs  = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = f1(strs);
    }
}
