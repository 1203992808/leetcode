/**
 * @author syz
 * @date 2018-12-24 20:20
 */
/**
 * leetcode 74 Search a 2D Matrix 搜索一个二维矩阵
 * 前一行最后一个元素一定比该行第一个元素小，每行严格递增
 * **/
public class Search_A_2D_Matrix_I {
    public static boolean f1 (int[][] matrix,int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int num = row * col;
        int low = 0;
        int high = num - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            int element = matrix[mid / col][mid % col];
            if (target < element) {
                high = mid - 1;
            } else if (target > element) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(f1(matrix,3));
    }
}
