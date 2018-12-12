
/**
 * 最大连续子字段和
 * */
public class MaxSumSubArr {
    public static int f1 (int[] arr){
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return Math.max(arr[0],arr[1]);
        }
        int[] dp = new int[arr.length];
        int max = 0;
        for (int i = 2; i <arr.length ; i++) {
            dp[i] = Math.max(arr[i],dp[i - 1]+ arr[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(f1(arr));
    }
}
