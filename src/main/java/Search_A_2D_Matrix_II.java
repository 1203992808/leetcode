/**
 * @author syz
 * @date 2018-12-24 20:30
 */
/**leetcode 240: Search a 2D Matrix II
 *一行最后一个元素不一定比该行第一个元素小，每行严格递增
 * */
public class Search_A_2D_Matrix_II {
    public static boolean  f1(int[][] matrix,int target){
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length - 1;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            }else  {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11},{2,5,8,12},{3,6,9,16}};
        System.out.println(f1(matrix,8));
    }
}
