/**
 * @author syz
 * @date 2018-12-21 21:19
 */

/**
 * leetcode 34 区间查找
 * 题目：
 给定一个已经升序排序的整形数组，找出给定目标值的开始位置和结束位置。

 你的算法时间复杂度必须是 O(log n) 级别。

 如果在数组中找不到目标，返回 [-1, -1]。

 例如:
 给出 [5, 7, 7, 8, 8, 10] 和目标值 8，
 返回 [3, 4]。
 *
 * **/
public class Search_For_Range {
    public static int[] f1 (int[] arr ,int target) {
        int begin = 0;
        int end = arr.length - 1;
        int mid = 0;
        while (begin <= end) {
            mid = begin + (end - begin)/2;
            if (arr[mid] == target) {
                break;
            }  else if (arr[mid] > target) {
                end = mid + 1;
            } else {
                begin = mid + 1;
            }
        }
        int[] result = new int[2];
        if (arr[mid] == target){
            int newBegin = mid;
            int newEnd = mid;
            while (newBegin > 0 && arr[newBegin - 1] == target){
                newBegin--;
            }
            while (newEnd < arr.length - 1 && arr[newEnd + 1] == target) {
                newEnd++;
            }
            result[0] = newBegin;
            result[1] = newEnd;
        } else {
            result[0] = -1;
            result [1] = -1;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,8,8,10};
        int target = 8;
        int[] result = f1(arr,target);
        int i = 5;
    }
}
