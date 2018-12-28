import java.util.ArrayList;

/**
 * @Auther: syz
 * @Date: 2018/12/28 10:30
 * @Description:
 */
/*
leetcode 46 全排列（I）
* 给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*
* */
public class Permutation_I {
    public static ArrayList<ArrayList<Integer>> f1 (int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        permute(arr,0,current,result);
        return result;

    }
    public static  void permute (int[] arr,int start,ArrayList<Integer> current,ArrayList<ArrayList<Integer>> result) {
        if(start == arr.length) {
            result.add(new ArrayList<>(current));
            return ;
        }
        for (int i = 0; i <arr.length ; i++) {
            if (!current.contains(arr[i])) {//重复元素不能加 ，例如 {1,1,1}
                current.add(arr[i]);
                permute(arr,start + 1,current,result);// 注意两点
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        ArrayList<ArrayList<Integer>> result = f1(arr);
        int i = 9;
    }
}
