import java.util.Arrays;
import java.util.concurrent.ForkJoinTask;

/**
 * @Auther: syz
 * @Date: 2018/12/29 14:05
 * @Description:
 */
/*
 *leetcode 268 缺失数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 *
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 *
 * */
public class Missed_Number {
    public static  int f1 (int[] arr) {
        int[] nums = new int[arr.length + 1];
        for (int i = 0; i < arr.length ; i++) {
            nums[i] = arr[i];
        }
        nums[nums.length - 1] = -1;
        for (int i = 0; i < nums.length ; i++) {
            while (nums[i] != i && nums[i] != -1) {
                swap(nums,nums[i],i);
            }
        }
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return -1;
    }
    public static int f2 (int [] arr) {
        int result = 0;
        for (int i = 0;i< arr.length;i++) {
            result ^= arr[i] ^ i;
        }

        return result^ arr.length;
    }
    public static void swap (int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {3,0,5,2,1};
        System.out.println(f2(arr));
    }
}

