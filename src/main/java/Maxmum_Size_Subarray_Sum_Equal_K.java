/**
 * @author syz
 * @date 2018-12-28 20:58
 */

import java.util.HashMap;
import java.util.Map;

/**leetcode 325 和为k 的最长子数组长度
 *Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

 Example 1:

 Given nums = [1, -1, 5, -2, 3], k = 3,
 return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

 Example 2:

 Given nums = [-2, -1, 2, 1], k = 1,
 return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

 Follow Up:
 Can you do it in O(n) time?
 *
 * */
public class Maxmum_Size_Subarray_Sum_Equal_K {
    public  static int f1 (int[] arr ,int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer,Integer> map = new HashMap();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length ; i++) {
            sum += arr[i];
            if (sum == k) {
                max = i +1;
            } else {
                if (map.containsKey(sum - k)) {
                    max = Math.max(max,i - map.get(sum - k));
                }
            }
            if (!map.containsKey(sum)) {
                map.put(i,sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,-1,5,-2,3};
        int k = 3;
        System.out.println(f1(arr,k));
    }
}
