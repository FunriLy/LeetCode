package com.qg.fangrui.easy.code021;

import com.qg.fangrui.structure.ListNode;

/**
 * Merge Two Sorted Lists
 * @author FunriLy
 * Created by FunriLy on 2018/1/8.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 将两个排序链表合并(递归)
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并后链表
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode list;

        if (l1.val < l2.val) {
            list = l1;
            list.next = mergeTwoLists(l1.next, l2);
        } else {
            list = l2;
            list.next = mergeTwoLists(l1, l2.next);
        }

        return list;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);

        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        b2.next = b3;

        ListNode.print(mergeTwoLists(a1, b1));
    }
}
