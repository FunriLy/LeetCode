package com.qg.fangrui.medium.code002;

import com.qg.fangrui.structure.ListNode;

/**
 * Add Two Numbers
 * @author FunriLy
 * Created by FunriLy on 2018/1/8.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 将两个数字型字符串相加
     * @param l1 数字字符串1
     * @param l2 数字字符串2
     * @return 两个字符串相加后的结果
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode cur = node;
        int sum = 0;
        while (l1 != null || l2 != null) {
            int d1 = 0, d2 = 0;
            if (l1 != null) {
                d1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                d2 = l2.val;
                l2 = l2.next;
            }
            int temp = d1 + d2 + sum;
            sum = (temp>=10) ? 1 : 0;
            cur.next = new ListNode(temp % 10);
            cur = cur.next;
        }

        if (sum == 1) {
            cur.next = new ListNode(1);
        }

        return node.next;
    }

    public static void main(String[] args) {
        ListNode.print(addTwoNumbers(
                ListNode.createTestData("[2,4,3]"),
                ListNode.createTestData("[5,6,4]")
        ));
    }
}
