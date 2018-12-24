/**
 * @author syz
 * @date 2018-12-24 20:12
 */
/***
 *
 * leetcode 162 返回局部最大值
 *给定一个相邻元素不相等的数组，找出其中的一个局部最大值，返回对应下标。
 * 例如 ： {1，2,3,1} 返回 2
 * */
public class Find_Peak_Element {
    public  static int f1 (int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        int low = 0;
        int high = arr.length - 1;
        int mid ;
        while (low <= high) {
            if (low == high) {
                break;
            }
            mid = low + (high - low)/2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(f1(arr));
    }
}
