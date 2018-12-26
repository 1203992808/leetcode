import java.util.ArrayList;
import java.util.Arrays;

/***
 * leetcode 78 Subset 回溯
 *
 *Given a set of distinct integers, S, return all possible subsets.
 *
 * Note:
 *
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 *
 *
 * For example,
 * If S = [1,2,3], a solution is:
 *
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 * **/

public class SubSet {
    public static ArrayList<ArrayList<Integer>> f1 (int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> item = new ArrayList<>();
        if ( arr == null || arr.length == 0) {
            return  result;
        }
        Arrays.sort(arr);

        dfs(arr,0,item,result);
        return result;
    }
    public  static void dfs (int[] arr, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result) {
             result.add(new ArrayList<>(item));
        for (int i = start; i <arr.length ; i++) {
            item.add(arr[i]);
            dfs(arr,i + 1,item,result);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2};
        ArrayList<ArrayList<Integer>> result = f1(arr);
        int i = 5;
    }
}
