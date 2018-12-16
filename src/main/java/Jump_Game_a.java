/**
 * @author syz
 * @date 2018-12-16 20:31
 */
/**
 * 题目描述
leetcode  55 跳跃游戏 a

 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 判断你是否能够到达最后一个位置。



 示例 1:

 输入: [2,3,1,1,4]
 输出: true
 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 示例 2:

 输入: [3,2,1,0,4]
 输出: false
 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 *
 * */
public class Jump_Game_a {
    public static boolean f1(int[] arr) {
        int[] index = new int[arr.length];
        for (int i = 0; i < arr.length  ; i++) {
            index[i] = i + arr[i];
        }
        int max_index = arr[0];
        int jump = 0;
        while (jump < index.length && jump <= max_index) {
            if (max_index < index[jump]) {
                max_index = index[jump];
            }
            jump++;
        }
        if (jump == index.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {2,3,1,1,4};
        int[] arr2 = {3,2,1,0,4};
        System.out.println(f1(arr1));
        System.out.println(f1(arr2));

    }
}
