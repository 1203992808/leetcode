/**
 * @author syz
 * @date 2018-12-15 17:22
 */
/** leetcode 376 摇摆序列
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。

 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。

 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * **/
public class Wiggle_Subsquence {

    public static  int f1(int[] arr){
         final int begin = 0;
         final  int up = 1;
         final int down = 2;
        int start = begin;
        int maxLength = 1;
        for (int i = 1; i <arr.length ; i++) {
            switch (start) {
                case begin :
                    if (arr[i - 1] < arr[i]){
                        start = up;
                        maxLength++;
                    } else if (arr[ i - 1] > arr[i]){
                        start = down;
                        maxLength++;
                    }
                    break;
                case up :
                    if (arr[i - 1] > arr[i]) {
                        start = down;
                        maxLength++;
                    }
                    break;
                case down :
                    if (arr[i - 1] < arr[i]){
                        start = up;
                        maxLength++;
                    }
                    break;
            }

        }
        return maxLength;

    }

    public static void main(String[] args) {
        int[] arr = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(f1(arr));
    }
}
