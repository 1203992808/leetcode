
/**
 * 爬楼梯
 * */
public class ClimbStairs {
    public static int  f1(int n){
        if (n == 1 || n == 2) {
            return n;
        }
        return f1(n - 1)+f1(n - 2);
    }

    public static int  f2(int n){
        if (n == 1 || n == 2) {
            return n;
        }
        int[] sum = new int[n];
        sum[0] = 1;
        sum [1]= 2;
        for (int i = 2; i <n ; i++) {
            sum[i] = sum[i - 1]+ sum[i - 2];
        }
        return sum[n - 1];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(f1(n));
        System.out.println(f2(n));

    }
}
