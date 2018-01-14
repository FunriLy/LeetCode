package com.qg.fangrui.medium.code024;

import com.qg.fangrui.structure.ListNode;

/**
 * Swap Nodes in Pairs
 * @author FunriLy
 * Created by FunriLy on 2018/1/12.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 交换链表每相邻两个结点的位置
     * @param head 链表头
     * @return 新链表头
     */
    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode ptr1 = temp;
        ListNode ptr2 = head;

        while(ptr2!=null && ptr2.next!=null){
            ListNode next = ptr2.next.next;
            ptr2.next.next = ptr2;
            ptr1.next = ptr2.next;
            ptr2.next = next;
            ptr1 = ptr2;
            ptr2 = ptr2.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode.print(n1);

        ListNode node = swapPairs(n1);
        ListNode.print(node);
    }
}
