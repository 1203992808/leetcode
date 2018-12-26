import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/***
 * leetcode 90 SubsetII
 * 在subset I 的基础上 增加set 去从
 *Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 *
 * [
 * [ 2 ],
 * [ 1 ],
 * [ 1,2,2 ],
 * [ 2,2 ],
 * [ 1,2 ],
 * []
 * ]
 * **/

public class SubSet_II {
    public static ArrayList<ArrayList<Integer>> f1 (int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> item = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();
        if ( arr == null || arr.length == 0) {
            return  result;
        }
        Arrays.sort(arr);

        dfs(arr,0,item,result,set);
        return result;
    }
    public  static void dfs (int[] arr, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> result,Set<ArrayList<Integer>> set) {
        if ( !set.contains(item)) {
            result.add(new ArrayList<>(item));
            set.add(new ArrayList<>(item));
        }

        for (int i = start; i <arr.length ; i++) {
            item.add(arr[i]);
            dfs(arr,i + 1,item,result,set);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2};
        ArrayList<ArrayList<Integer>> result = f1(arr);
        int i = 5;
    }
}
