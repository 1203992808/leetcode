/**
 * @author syz
 * @date 2018-12-16 20:41
 */
/**
 *
 *
 * LeetCode45. 跳跃游戏 b
 给定一个非负整数数组，你最初位于数组的第一个位置。

 数组中的每个元素代表你在该位置可以跳跃的最大长度。

 判断你最少几步可以到达最后一个位置。
 * */
public class Jump_Game_b {
    public static int f1 (int[] arr) {
        if (arr.length == 0 || arr == null) {
            return -1;
        }
        int cur = 0;
        int jump = 0;
        int next = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (cur < i) {
                cur = next;
                jump++;
            }
            next = Math.max(next,i + arr[i]);

        }
        return jump;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,3,1,1,4};
        System.out.println(f1(arr));
    }
}
