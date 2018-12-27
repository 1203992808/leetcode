import java.util.ArrayList;

/* leetcode 118 杨辉三角（I）
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 * Return
 *
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 *
 * */
public class Pascal_Triangle_I {
    public static ArrayList<ArrayList<Integer>> f1(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        list.add(1);
        result.add(list);
        if (n == 1) {
            return result;
        }
        for (int i = 1; i < n; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0) {
                    list.add(result.get(i - 1).get(0));
                } else if (j == i) {
                    list.add(result.get(i - 1).get(result.get(i - 1).size() - 1));
                } else {
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        ArrayList<ArrayList<Integer>> result = f1(n);
        int i = 5;
    }
}



