package com.qg.fangrui.easy.code100;

import com.qg.fangrui.structure.TreeNode;

/**
 * Merge Sorted Array
 * @author FunriLy
 * Created by FunriLy on 2018/1/20.
 * From small beginnings comes great things.
 */
public class Solution {

    /**
     * 递归判断两树是否相同
     * @param p 树p
     * @param q 树q
     * @return 若两树相同返回 true 否则返回 false
     */
    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null) {
            return true;
        }
        if (p==null || q==null) {
            return false;
        }
        return p.val==q.val &&isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
