/**
 * @author syz
 * @date 2018-12-20 21:20
 */

import java.util.HashMap;
import java.util.Map;

/**
 ——唯有更努力才能让一切都是最好的安排。
 leetcode 1 Two Sum （俩数和为目标数的下标）——EASY
 题目：

 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * */
public class Search_For_Range {
    public static int[] f1 (int[] arr,int target)  {
        if (arr == null || arr.length == 0) {
            return new int[]{-1,-1};
        }
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <arr.length ; i++) {
            map.put(arr[i],i);
        }
        for (int i = 0; i < arr.length ; i++) {
            if (map.containsKey(target - arr[i]) && i != map.get(target - arr[i])) {
                int min = Math.min(i,map.get(target - arr[i]));
                int max = Math.max(i,map.get(target - arr[i]));
                return new int[]{min,max};
            }
        }
        return new int[]{-1,-1};

    }

    public static void main(String[] args) {
              int[] arr = {1,2,3,4,5,6,7,8};
              int target = 8;
              int[] result = f1(arr,target);
              int i = 5;
    }
}
