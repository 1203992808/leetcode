/**
 * @author syz
 * @date 2018-12-13 22:10
 */
/**
 * leetcode 322
 * 现存在一堆面值为 1,2,5,11,20,50 面值的硬币，问最少需要多少个硬币才能找出总值为 N个单位的零钱
 *
 * */
public class Coin_Charge {
    public  static int f1(int[] arr ,int target) {
        int[] dp = new int[target +1];
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        for (int i = 0; i <=target; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j <arr.length ; j++) {
                if (i - arr[j]>= 0 && dp[i - arr[j]] != max) {
                    dp[i] = Math.min(dp[i],1+ dp[i - arr[j]]);
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5,7,10};
        System.out.println(f1(arr,12));
    }
}
