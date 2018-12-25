/**
 * @author syz
 * @date 2018-12-25 20:46
 */

/**
 *  leetcode 136 single number
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.

 Note:

 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

 Example 1:

 Input: [2,2,1]
 Output: 1
 Example 2:

 Input: [4,1,2,1,2]
 Output: 4
 *
 * **/
public class Single_Number_I {
    public static int f1 (int[] arr) {
        int e0 = 0;
        for (int i = 0; i < arr.length; i++) {
            e0 ^= arr[i];
        }
        return e0;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,5,7,5,7,2};
        System.out.println(f1(arr));
    }
}
