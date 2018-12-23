/**
 * @author syz
 * @date 2018-12-23 14:04
 */
/**
 *题目如下：
   leetcode 135  旋转数组找最小值
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 *
 * **/
public class Find_Min_In_Rotated_Sorted_Arr_I {
    public static int f1 ( int[] arr) {
        if ( arr.length == 1) {
            return arr[0];
        }
        if (arr[0] < arr[arr.length - 1]){ //分两种情况 一  {0,1,2,3,4,5,6,7} 此时针对这种情况 初始值即为最小
            return arr[0];
        }
        int low = 0;                        //以下针对第二种情况 ，旋转点在某个位置 例如 {4,5,6,7,0,1,2}
        int  high = arr.length - 1;
        while(high - low != 1) { //不能写成 hight>= low 这样会造成死循环，因为high永远在第二个有序数组，low永远在第一个有序数组
            int mid = low +(high - low)/2;
            if (arr[mid] > arr[0]){//mid在第一个有序数组里面
                low = mid;//low永远在第一个有序数组
            } else if(arr[mid] < arr[arr.length - 1]) {//mid在第二个有序数组
                high = mid;//high永远在第二个有序数组里
            }
        }
        return arr[high]; //一定是第二个有序数组里，所以是hight
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,1,2,3};
        int[] arr2 = {4,5,6,7,0,1,2};
        System.out.println(f1(arr2));
        System.out.println(f1(arr));
    }
}
