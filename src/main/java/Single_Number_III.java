/**
 * @author syz
 * @date 2018-12-25 20:56
 */
/**
 * leetcode 260. Single Number III
 题目描述：

 Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * */
public class Single_Number_III {
    public static int[] f1 (int[] arr) {
        int e0 = 0;
        for (int i = 0; i <arr.length ; i++) {
            e0 ^= arr[i];
        }
        int e1 = e0 & (~e0 +1);
        int e2 = 0;
        for (int i = 0; i <arr.length ; i++) {
            if ((e1 & arr[i])!= 0) {
                e2 ^= arr[i];
            }
        }
        return new int[]{e2,(e2 ^e0)};
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,3,2,5};
        int[] arr1 = f1(arr);
        System.out.println(f1(arr));
    }
}
