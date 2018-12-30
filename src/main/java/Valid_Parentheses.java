
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Auther: syz
 * @Date: 2018/12/29 09:58
 * @Description:
 */
/*leetcode 20 有效的括号长度
* **/
public class Valid_Parentheses {
   public static boolean f1 (String str) {
       Map<Character,Character> map = new HashMap<>();
       map.put(')','(');
       map.put(']','[');
       map.put('}','{');
       Stack<Character> stack = new Stack<>();
       for (int i = 0; i < str.length() ; i++) {
           char c = str.charAt(i);
           if (map.containsKey(c)) {
               char element = stack.isEmpty() ? '#' : stack.pop();
               if (element != map.get(c)) {
                   return false;
               }
           } else {
               stack.push(c);
           }
       }

       return stack.isEmpty();
   }

    public static void main(String[] args) {
        String str = "{}{{}}[]";
        System.out.println(f1(str));
    }
}
