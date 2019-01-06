import java.util.HashMap;

/**
 * leetcode 11 盛最多水的容器
 * @author syz
 * @date 2019-01-01 12:34
 */
public class Container_With_Most_Water {
    public static int f1 (int[] arr) {
        int leftMax = arr[0];
        int rightMax = arr[arr.length - 1];
        int left = 0;
        int right = arr.length - 1;
        int max = 0;
        while (left < right) {
            if (arr[left] < leftMax) {
                left++;
                continue;
            }
            if (arr[right]< rightMax) {
                right--;
                continue;
            }
            leftMax = arr[left];
            rightMax = arr[right];
            max = Math.max(Math.min(leftMax,rightMax)*(right - left),max);
            if (leftMax > rightMax) {
                right--;
            }else {
                left++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(f1(arr));

    }
}
