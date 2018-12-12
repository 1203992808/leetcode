
/**
 * 198.打家劫舍
 题目表述:
 你是一个专业的强盗，计划抢劫沿街的房屋。每间房都藏有一定的现金，阻止你抢劫他们的唯一的制约因素就是相邻的房屋有保安系统连接，如果两间相邻的房屋在同一晚上被闯入，它会自动联系警方。
 给定一个代表每个房屋的金额的非负整数列表，确定你可以在没有提醒警方的情况下抢劫的最高金额。
 *
 * */
public class House_Robber {
    public static int f1(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return Math.max(arr[0],arr[1]);
        }
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        sum[1] = arr[1];
        int max = 0;
        for (int i = 2; i <sum.length ; i++) {
            sum[i] = Math.max(sum[i - 1],arr[i]+ sum[i - 2]);
            max = Math.max(max,sum[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {5,2,6,3,1,7};
        System.out.println(f1(arr));
    }
}
