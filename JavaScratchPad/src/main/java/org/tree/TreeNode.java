package org.tree;

public  class TreeNode <T extends Comparable >{
    T val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(T val) { this.val = val; }
    TreeNode(T val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
