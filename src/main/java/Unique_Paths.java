/***
 * leetcode 62
 *
 *一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 问总共有多少条不同的路径？
 */

public class Unique_Paths {
    public int unique_paths (int m,int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
       if (m == 1) {
           return unique_paths(1,n - 1);
       }
       if (n == 1) {
           return unique_paths(m - 1,1);
       }
       return unique_paths(m - 1,n) + unique_paths(m,n - 1);
    }
    public static int unique_path2_II (int m ,int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        int[][] arr = new int[m][n];
        for (int i = 0; i <m ; i++) {
            arr[i][0] = 1;
        }
        for (int j = 0; j <n ; j++) {
            arr[0][j] = 1;
        }
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        return arr[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(Unique_Paths.unique_path2_II(3,2));
    }
}
