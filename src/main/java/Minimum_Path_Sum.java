/**
 * @author syz
 * @date 2018-12-14 21:10
 */
/*矩形最小路径和问题 leetcode  64
*
* */
public class Minimum_Path_Sum {
    public static int f1(int[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i <matrix[0].length ; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        for (int j = 1; j <matrix.length ; j++) {
            dp[j][0] = dp[j - 1][0] +matrix[j][0];
        }
        for (int i = 1; i <matrix.length ; i++) {
            for (int j = 1; j <matrix[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j],dp[i][j - 1]) + matrix[i][j];
            }
        }
        return dp[matrix.length - 1][matrix[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(f1(matrix));
    }
}
