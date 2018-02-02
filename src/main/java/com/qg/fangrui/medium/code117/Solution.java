package com.qg.fangrui.medium.code117;

import com.qg.fangrui.structure.TreeLinkNode;

/**
 * Populating Next Right Pointers in Each Node II
 * @author FFunriLy
 * Created by FunriLy on 2018/2/2.
 * From small beginnings comes great things.
 */
public class Solution {

    /*
    参考资料 : http://www.cnblogs.com/springfor/p/3889327.html
     */

    private static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode node = root.next;
        // 找到第一个有效的next节点
        while (node != null) {
            if (node.left != null) {
                node = node.left;
                break;
            }
            if (node.right != null) {
                node = node.right;
                break;
            }
            node = node.next;
        }

        if (root.right != null) {
            root.right.next = node;
        }

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = node;
            }
        }

        connect(root.right);
        connect(root.left);
    }
}
