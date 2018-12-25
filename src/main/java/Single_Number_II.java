/**
 * @author syz
 * @date 2018-12-25 20:49
 */
/**
 * leetcode 137 single number II
 * Given an array of integers, every element appears three times except for one. Find that single one.

 Note:

 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * */
public class Single_Number_II {
    public static int f1 (int[] arr) {
        int e0 = 0;
        for (int i = 0; i <32 ; i++) {
            int sum = 0;
            for (int j = 0; j < arr.length ; j++) {
                sum += (arr[j] >> i) & 1;
            }
            e0 |= (sum % 3)<<i;
        }
        return e0;
    }

    public static void main(String[] args) {
        int[] arr = {2,4,5,7,5,2,7,2,5,7};
        System.out.println(f1(arr));
    }
}
