package com.qg.fangrui.structure;

/**
 * 数据结构 TreeLinkNode
 * @author FunriLy
 * Created by FunriLy on 2018/2/2.
 * From small beginnings comes great things.
 */
public class TreeLinkNode {

    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;
    public TreeLinkNode(int v){
        val = v;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

}
