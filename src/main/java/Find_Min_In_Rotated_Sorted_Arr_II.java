/**
 * @author syz
 * @date 2018-12-23 14:35
 */
/**
 * leetcode 154 旋转数组发现最小值（可能包含重复元素）
 Find Minimum in Rotated Sorted Array II

 Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 The array may contain duplicates.  {1,2,3,1,1,1}

**/
public class Find_Min_In_Rotated_Sorted_Arr_II {
    public  static int f1 (int [] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr[0] < arr[arr.length - 1]) {
            return arr[0];
        }
        int low = 0;
        int high = arr.length - 1;
        while (high - low != 1) {
            int mid = low +(high - low)/2;
            if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
                int min = Integer.MAX_VALUE;
                for (int i = low; i <= high ; i++) {
                    min = Math.min(min,arr[i]);
                }
                return min;
            } else if (arr[mid] >= arr[low]) {
                low = mid ;
            } else if (arr[mid] < arr[high]) {
                high = mid;
            }
        }
        return arr[high];
    }

    public static void main(String[] args) {
        int[] arr1 = {0,1,2,3,4,5,6,7};
        int[] arr2 = {4,5,6,7,0,1,2};
        int[] arr3 = {1,2,3,1,1,1,1};
        System.out.println(f1(arr1));
        System.out.println(f1(arr2));
        System.out.println(f1(arr3));
    }
}
