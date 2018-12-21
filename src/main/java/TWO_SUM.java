/**
 * @author syz
 * @date 2018-12-21 21:22
 */

import java.util.HashMap;
import java.util.Map;

/***leetcode 1 两数之和
 *
 * 题目：
 给定一个整数数列，找出其中和为特定值的那两个数。

 你可以假设每个输入都只会有一种答案，同样的元素不能被重用。

 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 *
 */

public class TWO_SUM {
    public static  int[] f1 (int[] arr,int target) {
        if (arr == null || arr.length == 0) {
            return new int[] {-1,-1};
        }
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <arr.length ; i++) {
            map.put(arr[i],i);
        }
        for (int i = 0; i <arr.length ; i++) {
            if (map.containsKey(target - arr[i]) && map.get(target - arr[i]) != i) {
                int max = Math.max(i,map.get(target - arr[i]));
                int min = Math.min(i,map.get(target - arr[i]));
                return new int[]{min,max};
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int[] result = f1(arr,7);
        int i = 5;
    }
}
