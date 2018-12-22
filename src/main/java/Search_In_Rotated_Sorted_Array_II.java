/**
 * @author syz
 * @date 2018-12-22 12:20
 */
/**
 * leetcode 81 在旋转数组（包含重复）中找指定的数
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。

 ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。

 示例 1:

 输入: nums = [2
 ,5,6,0,0,1,2]
 , target = 0
 输出: true
 示例 2:

 输入: nums = [2
 ,5,6,0,0,1,2]
 , target = 3
 输出: false

 * */
public class Search_In_Rotated_Sorted_Array_II {
    public static boolean f1 (int[] arr,int target) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int begin = 0;
        int end = arr.length;
        while (begin <= end) {
            int mid = begin +(end - begin)/2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > arr[begin]) {
                if (target < arr[mid] && target >= arr[begin]) {
                    end = mid - 1;
                } else {
                    begin = mid +1;
                }
            } else if (arr[mid] < arr[begin]) {
                if (target > arr[mid] && target < arr[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                begin++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 1;
        System.out.println(f1(arr,target));
    }
}
