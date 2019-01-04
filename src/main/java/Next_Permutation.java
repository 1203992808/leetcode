/**
 * @Auther: syz
 * @Date: 2019/1/4 10:09
 * @Description:
 */
/**
 * leetcode 31 下一个排列
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * **/
public class Next_Permutation {
    public static void f1 (int[] arr) {
        int i = arr.length - 2;
        while (i>= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = arr.length - 1;
            while (j>= 0 && arr[j] <= arr[i]) {
                j--;
            }
            swap(arr,i,j);
        }
        reverse(arr,i +1);
    }
    public static  void swap (int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void reverse (int[] arr,int i) {
        int start = i;
        int end = arr.length - 1;
        while (end >= start) {
            swap(arr,end,start);
            end--;
            start++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,5,8,4,7,6,5,5,1};
        f1(arr);
        int i = 5;
    }
}
