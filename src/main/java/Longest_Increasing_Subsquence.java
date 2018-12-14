/**
 * @author syz
 * @date 2018-12-14 21:00
 */
/**
 *
 *【题目描述】

 给定N个数，求这N个数的最长上升子序列的长度。

 【样例输入】

 7

 2 5 3 4 1 7 6

 【样例输出】

 4
 * */
public class Longest_Increasing_Subsquence {
    public  static int f1(int[] arr){
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i <arr.length ; i++) {
            dp[i] = 1;
            for (int j = 0; j < i ; j++) {
                if (arr[j] < arr[i] && dp[i] < dp[j] +1) {
                    dp[i] = dp[j] +1;
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,3,4,1,7,6};
        System.out.println(f1(arr));
    }
}
