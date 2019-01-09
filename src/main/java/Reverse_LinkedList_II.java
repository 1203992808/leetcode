/**
 * @Auther: syz
 * @Date: 2019/1/9 17:27
 * @Description:
 */
/**
 *leetcode 92 部分逆转链表
 *
 * */
public class Reverse_LinkedList_II {
      public class ListNode {
      int val;
       ListNode next;
      ListNode(int x) { val = x; }
  }
  public ListNode f1 (ListNode head,int m,int n) {
          int len = 0;
          ListNode node1 = head;
          ListNode pre = null;
          ListNode post = null;
          while (node1 != null) {
              len++;
              pre = len == m - 1 ? node1 : pre;
              post = len == n + 1 ? node1 : post;
              node1 = node1.next;
          }
          if (m > n || m < 1 || n > len) {
              return  head;
          }
          node1 = pre == null ? head : pre.next;//当 m = 1时会出现这种状况，因为第一个的前一个为空；
          ListNode node2 = node1.next;
          node1.next = post;
          ListNode next = null;
          while (node2 != post) {
              next = node2.next;
              node2.next = node1;
              node1 = node2;
              node2.next = next;
          }
          if (pre != null) {
              pre.next = node1;
              return head;
          }
          return node1;

  }

}
