import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: syz
 * @Date: 2019/1/3 09:56
 * @Description:
 */
/**
 *leetcode 219 存在重复元素II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 *
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 *
 **/
public class Contains_Duplicate_II {
    public static  boolean f1 (int[] arr,int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length ; i++) {
            if (map.containsKey(arr[i])) {
                int diff =  i - map.get(arr[i]);
                if ( diff <= k) {
                    return true;
                }
                map.put(arr[i],i);
            } else {
                map.put(arr[i],i);
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,3};
        System.out.println(f1(arr,2));
    }
}
