import java.util.ArrayList;
import java.util.List;

/**
 *
 * 例如：
 * 当 n = 3 时 "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 *
 * **/
public class GenerateParenthesis {
    public static ArrayList<String> f1 (int n) {
        ArrayList<String> result = new ArrayList<>();
        dfs(result,"",0,0,n);
        return result;

    }
    public static void dfs (ArrayList<String> result,String s,int left,int right,int n) {
        if (right > left) {
            return ;
        }
        if (left == n && right == n) {
            result.add(s);
            return;
        }
        if (left < n) {
            dfs(result,s + "(",left+1,right,n);
        }
        if (right < n) {
            dfs(result,s + ")",left,right + 1,n);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        ArrayList<String> list = f1(n);
        int i = 5;
    }
}
