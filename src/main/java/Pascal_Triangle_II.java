import java.util.ArrayList;

/* leetcode 119 杨辉三角（II）
Given an index k, return the k th row of the Pascal's triangle.

For example, given k = 3,
Return[1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/
public class Pascal_Triangle_II {
    public static ArrayList<Integer> f1(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        if (n == 0) {
            return list;
        }
        for (int i = 1; i < n + 1; i++) {
            list = new ArrayList<>();
            for (int j = 0; j < i + 1 ; j++) {
                if (j == 0) {
                    list.add(result.get(i - 1).get(0));
                } else if (j == i ) {
                    list.add(result.get(i - 1).get(result.get(i - 1).size() - 1));
                } else {
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(list);
        }
        return result.get( n );
    }

    public static void main(String[] args) {
        int n = 3;
     ArrayList<Integer> result = f1(n);
        int i = 5;
    }
}



