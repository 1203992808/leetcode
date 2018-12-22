/**
 * @author syz
 * @date 2018-12-22 12:09
 */

/**
 *leetcode 33 在旋转数组中找指定的值，并返回下标
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 You are given a target value to search. If found in the array return its index, otherwise return -1.
 You may assume no duplicate exists in the array.
 Your algorithm’s runtime complexity must be in the order of O(log n).
 Example 1:
 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:
 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 *
 * */
public class Search_In_Rotated_Sorted_Array_I {
    public static int f1 (int[] arr,int target){
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int begin = 0;
        int end = arr.length - 1;
        while (begin <= end) {
            int mid = begin +(end - begin)/2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > arr[begin]) {
                if (target < arr[mid] && target >= arr[begin]) {
                    end = mid - 1;
                } else {
                    begin = mid +1;
                }
            } else {
                if (target >arr[mid]&&target <= arr[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(f1(arr,target));
    }
}
