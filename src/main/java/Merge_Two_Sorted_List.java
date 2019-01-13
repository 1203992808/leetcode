/**
 * @Auther: syz
 * @Date: 2019/1/13 14:00
 * @Description:
 */
/**
 * LeetCode 21 合并两个有序链表
 * */
public class Merge_Two_Sorted_List {

    public  ListNode f1 (ListNode l1,ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        node.next = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
                node = node.next;
            } else {
                node.next = l2;
                l2 = l2.next;
                node = node.next;
            }
        }
        if ( l1 != null) {
            node.next = l1;

        } else {
            node.next = l2;
        }
        return head.next;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
