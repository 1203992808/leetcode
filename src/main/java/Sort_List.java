/**
 * @Auther: syz
 * @Date: 2019/1/13 14:16
 * @Description:
 */
/*
* leetcode 148 链表排序
**/
public class Sort_List {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public  ListNode f1 (ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode middle = getMiddleList(head);
        ListNode second = middle.next;
        middle.next = null;
        first = f1(first);
        second = f1(second);
        head = sortList(first,second);
        return head;
    }


    public  ListNode sortList (ListNode l1,ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        node.next = null;
        ListNode p = l1;
        ListNode q = l2;
        while (p != null &&q != null) {
            if (p.val < q.val) {
                node.next = p;
                p = p.next;
                node = node.next;
            } else {
                node.next = q;
                q = q.next;
                node = node.next;
            }
        }
        if (p != null) {
            node.next = p;
        } else {
            node.next = q;
        }
        return head.next;
    }
    public  ListNode getMiddleList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
