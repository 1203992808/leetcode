import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * leetcode 39 组合数之和（I）
 *Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * **/
public class Combination_Sum_I {
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
            dfs(arr,target,sum + arr[i],i ,result,current,set);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5};
        int target = 8;
        ArrayList<ArrayList<Integer>> result = f1(arr,target);
        System.out.println("aaaaa");

    }
}
