/**
 * @author syz
 * @date 2018-12-13 22:39
 */
/*
* Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
三角形最小路径和问题
* */
public class Triangle {
    public static int f1(int[][] matrix){
        int[][] dp = new int[matrix.length][];
        for (int i = 0; i <matrix.length ; i++) {
            dp[i] = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length ; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 0; i <dp[matrix.length - 1].length ; i++) {
            dp[matrix.length - 1][i] = matrix[matrix.length - 1][i];
        }
        for (int i = matrix.length - 2; i>= 0 ; i--) {
            for (int j = 0; j < dp[i].length ; j++) {
                dp[i][j] = Math.min(matrix[i][j] + dp[i+1][j],matrix[i][j] + dp[i+1][j +1]);
            }
        }
        return dp[0][0];

    }

    public static void main(String[] args) {
        int[][]  matrix = {{2},{3,4},{6,5,7},{4,1,8,3}};
        System.out.println(f1(matrix));
    }

}
