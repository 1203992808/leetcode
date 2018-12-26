import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 40 组合数之和（II）
 *Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * **/
public class Combination_Sum_II {
    public static ArrayList<ArrayList<Integer>> f1(int[] arr,int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        ArrayList<Integer> current = new ArrayList<>();
        Set<ArrayList<Integer>> set = new HashSet<>();
        Arrays.sort(arr);
        dfs(arr,target,0,0,result,current,set);

        return result;

    }
    public static void dfs (int[] arr,int target,int sum,int start,
                           ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current,Set<ArrayList<Integer>> set) {
        if (sum == target) {
            if ( !set.contains(current)){
                set.add(current);
                result.add(new ArrayList<>(current));
            }
            return ;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < arr.length ; i++) {
            current.add(arr[i]);
            dfs(arr,target,sum + arr[i],i + 1,result,current,set);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        ArrayList<ArrayList<Integer>> result = f1(arr,target);
        System.out.println("aaaaa");

    }
}
