import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: syz
 * @Date: 2019/1/3 14:17
 * @Description:
 */
/*
* leetcode 229 求众数
* 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。

示例 1:

输入: [3,2,3]
输出: [3]
示例 2:

输入: [1,1,1,3,3,2,2,2]
输出: [1,2]
* **/
public class Major_Element_II {
    public static List<Integer> f1 (int[] arr) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return  result;
        }
        if (arr.length == 1) {
            result.add(arr[0]);
            return result;
        }
        int majorA = arr[0];
        int majorB = arr[1];
        int countA = 0;
        int countB = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] == majorA) {
                countA++;
                continue;
            }
            if (arr[i] == majorB) {
                countB++;
                continue;
            }
            if (countA == 0) {
                countA++;
                majorA = arr[i];
                continue;
            }
            if (countB == 0) {
                countB++;
                majorB = arr[i];
                continue;
            }
            countA--;
            countB--;
        }
        countA = 0;
        countB = 0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] == majorA) {
                countA++;
            } else if (arr[i] == majorB) {
                countB++;
            }
        }
        if (countA > arr.length/3) {
            result.add(majorA);
        }
        if (countB > arr.length/3) {
            result.add(majorB);
        }
        return result;
    }
    public static List<Integer> f2 (int[] arr) {
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return  result;
        }
        if (arr.length == 1) {
            result.add(arr[0]);
            return result;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <arr.length ; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i],map.get(arr[i]) + 1);
            }else {
                map.put(arr[i],1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > arr.length/3) {
                result.add(entry.getKey());
            }
        }
        return  result;
    }
}
