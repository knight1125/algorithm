package com.leetcode.topic1_50;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.leetcode.topic1_50
 * @Description : 合并两个有序链表  简单题，链表的简单操作; P
 * @Create on : 2021/5/10 22:00
 **/
public class Problem21 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {return l2;}
        if (l2 == null) {return l1;}

        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            l1= l1.next;
        } else {
            head = l2;
            l2=l2.next;
        }
        ListNode tail = head;

        while (l1 !=null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 != null) {
            tail.next = l1;
        }
        if (l2 != null) {
            tail.next =l2;
        }
        return head;
    }

}
