/**
 * @author syz
 * @date 2018-12-14 22:13
 */
/** 地牢游戏 leetcode 174
 *一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。

 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。

 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。

 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 */

public class Dungeon_Game {
    public static int f1(int[][] matrix) {
        int[][] dp = new int[matrix.length ][matrix[0].length ];
        dp[matrix.length - 1][matrix[0].length - 1] = Math.max(1,1 -matrix[matrix.length - 1][matrix[0].length - 1]);
        for (int j = matrix[0].length - 2; j >= 0 ; j--) {
            dp[matrix.length - 1][j] = Math.max(1,dp[matrix.length - 1][j+1] - matrix[matrix.length - 1][j]);
        }
        for (int i = matrix.length - 2; i >= 0 ; i--) {
            dp[i][matrix[0].length - 1] = Math.max(1,dp[i+ 1][matrix[0].length - 1] - matrix[i][matrix[0].length - 1]);
        }
        for (int i = matrix.length - 2; i >= 0 ; i--) {
            for (int j = matrix[0].length - 2; j >= 0 ; j--) {
               int min = Math.min(dp[i+1][j],dp[i][j+1]);
               dp[i][j] = Math.max(1,min - matrix[i][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] matrix = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        System.out.println(f1(matrix));
    }
}
