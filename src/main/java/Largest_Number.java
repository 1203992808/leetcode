import java.util.*;

/**
 * @author syz
 * @date 2019-01-06 17:38
 */
/**
 * leetcode 179 最大数
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。

 示例 1:

 输入: [10,2]
 输出: 210
 示例 2:

 输入: [3,30,34,5,9]
 输出: 9534330
 *
 * */
public class Largest_Number {
    public static String  f1 (int[] arr) {
        if (arr == null || arr.length == 0) {
            return "";
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(String.valueOf(arr[i]));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 +o2;
                String str2 = o2 +o1;
                return Long.valueOf(str1) < Long.valueOf(str2) ? 1 : -1;
            }
        });
        StringBuilder sb = new StringBuilder();
        if (list.get(0).equals("0")){
            return "0";
        }
        for (String str: list) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = {3,30,34,5,9};
        System.out.println(f1(arr));
    }
}
