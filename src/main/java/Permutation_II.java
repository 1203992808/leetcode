import java.util.ArrayList;

/**
 * @Auther: syz
 * @Date: 2018/12/28 10:30
 * @Description:
 */
/*
leetcode 47 全排列（II）
* 给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*
* */
public class Permutation_II {
    public static ArrayList<ArrayList<Integer>> f1 (int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        permute(arr,0,current,index,result);
        return result;

    }
    public static  void permute (int[] arr,int start,ArrayList<Integer> current,ArrayList<Integer>index,ArrayList<ArrayList<Integer>> result) {
        if(start == arr.length) {
            if ( !result.contains(current)){
                result.add(new ArrayList<>(current));
            }
            return ;
        }
        for (int i = 0; i <arr.length ; i++) {
            if (!index.contains(i)) {//重复下标不能加，但可以加重复元素,但必须是不同位置的重复元素，如果不允许加不同位置不同元素，元素个数就不够数组的长度，这会导致result元素少于指定的个数
                current.add(arr[i]);
                index.add(i);
                permute(arr,start + 1,current,index,result);//
                index.remove(index.size() - 1);
                current.remove(current.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1};
        ArrayList<ArrayList<Integer>> result = f1(arr);
        int i = 9;
    }
}
