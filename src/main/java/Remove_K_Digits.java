import java.util.Stack;

/**
 * @author syz
 * @date 2018-12-17 20:59
 */

/*
leetcode 402  Remove K Digits 移掉K位数字（贪心）
* 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

注意:
num 的长度小于 10002 且 ≥ k。
num 不会包含任何前导零。
*
* */
public class Remove_K_Digits {
    public static int f1 (String num,int k) {
        Stack<Integer> stack = new Stack();
        char[] chs = num.toCharArray();
        for (int i = 0; i < chs.length ; i++) {
            int digit = chs[i] - '0';
            while ( !stack.isEmpty() && stack.peek() > digit && k>0) {
                stack.pop();
                k--;
            }
            if (digit != 0 || !stack.isEmpty()) {
                stack.push(digit);
            }
        }
        while( !stack.isEmpty() && k> 0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while ( !stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return Integer.valueOf(sb.reverse().toString());
    }

    public static void main(String[] args) {
        String num= "1432219";
        System.out.println(f1(num,3));
    }
}
