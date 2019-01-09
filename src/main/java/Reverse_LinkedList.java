/**
 * @Auther: syz
 * @Date: 2019/1/9 17:27
 * @Description:
 */
/**
 * leetcode 206 逆转链表
 * leetcode 206 逆转链表
 *
 * */
public class Reverse_LinkedList {
      public class ListNode {
      int val;
       ListNode next;
      ListNode(int x) { val = x; }
  }
  public ListNode f1 (ListNode head) {
          if (head == null) {
              return null;
          }
          ListNode pre = null;
          ListNode node = head;
          ListNode next = null;
          while (node != null) {
              next = node.next;
              node.next = pre;
              pre = node;
              node = next;
          }
          return pre;
  }
}
