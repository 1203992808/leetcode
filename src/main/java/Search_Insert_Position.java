/**
 * @author syz
 * @date 2018-12-21 21:12
 */
/**
 * leetcode  35 搜索插入位置
 * 给定一个排序数组和一个目标值，如果在数组中找到目标值则返回索引。如果没有，返回到它将会被按顺序插入的位置。

 你可以假设在数组中无重复元素
 * **/
public class Search_Insert_Position {
    public static int f1 (int[] arr,int target) {
        int index = -1;
        int begin = 0;
        int end = arr.length;
        while (index == -1) {
            int mid = begin + (end - begin)/2;
            if (target == arr[mid]) {
                index = mid;
            } else if (target < arr[mid]) {
                if (mid == 0 || target > arr[mid - 1]){
                    index = mid;
                }
                end = mid -1;
            } else if (target > arr[mid]) {
                if (target < arr[mid + 1]) {
                    index = mid;
                }
                begin = mid + 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {-1,2,5,20,90,100,207,800};
        int target = 200;
        System.out.println(f1(arr,target));
    }
}
