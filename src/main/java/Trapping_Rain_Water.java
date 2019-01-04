/**
 * @Auther: syz
 * @Date: 2019/1/4 10:33
 * @Description:
 */
/***
 * leetcode 42 接雨水
 * water problem
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

 示例:

 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 输出: 6
 *
 * */
public class Trapping_Rain_Water {
    public static int  f1 (int[] arr) {
        if (arr == null || arr.length < 3) {
            return  0;
        }
        int[] leftmax = new int[arr.length];
        int[] rightMax = new int[arr.length];
        leftmax[0] = arr[0];
        rightMax[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length - 1; i++) {
            leftmax[i] = Math.max(arr[i],leftmax[i - 1]);
        }
        for (int i = arr.length - 2; i > 0 ; i--) {
            rightMax[i] = Math.max(arr[i],rightMax[i + 1]);
        }
        int value = 0;
        for (int i = 1; i < arr.length - 1 ; i++) {
            value += Math.max(Math.min(leftmax[i],rightMax[i]) - arr[i],0);
        }
        return  value;
    }
    public static  int f2 (int[] arr) {
        if (arr == null || arr.length < 3) {
            return  0;
        }
        int left = 1;
        int right = arr.length - 2;
        int value = 0;
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        while (left <= right){
            if (leftMax < rightMax) {
                value +=  Math.max(leftMax - arr[left],0);
                leftMax = Math.max(leftMax,arr[left++]);
            } else {
                value +=  Math.max(rightMax - arr[right],0);
                rightMax = Math.max(rightMax,arr[right--]);
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(f2(arr));
    }
}
