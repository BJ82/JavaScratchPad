package org.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BST {

    private Map<Integer,Integer> counter = new HashMap<>();
    public boolean isValidBST(TreeNode root) {
        boolean isBST = false;

        if(hasDuplicate(root)) {
            return false;
        }

        if(isEmptyTree(root))
            return true;

        if(childCount(root) == 1){

            if(isGreater(max(root.left),root) || isLess(min(root.right),root))
                return false;

            isBST = isValidBST(root.left) && isValidBST(root.right);

        }

        if(childCount(root) == 2){

            if(isLess(min(root.right),root) || isGreater(max(root.left),root))
                return false;

            isBST = isValidBST(root.left) && isValidBST(root.right);
        }

        return isBST;
    }
    private boolean isNull(TreeNode node){
        boolean isNull = false;
        if(node == null){
            isNull = true;
        }
        return isNull;
    }
    private boolean isEmptyTree(TreeNode root){
        if(!isNull(root))
            return isNull(root.left) && isNull(root.right);
        return true;
    }

    private boolean isLess(TreeNode node1,TreeNode node2){
        if(!isNull(node1) && !isNull(node2))
            return node1.val < node2.val;
        return false;
    }

    private boolean isGreater(TreeNode node1,TreeNode node2){
        if(!isNull(node1) && !isNull(node2))
            return node1.val > node2.val;
        return false;
    }
    private int childCount(TreeNode root){

        int childCount = -1;
        if(root.left == null && root.right == null){
            childCount = 0;
        }
        else if(root.left != null && root.right != null){
            childCount = 2;
        }
        else{
            childCount = 1;
        }

        return childCount;

    }

    private TreeNode min(TreeNode root){

        if(root == null)
            return null;

        if(root.left == null)
            return root;

        return min(root.left);
    }

    private TreeNode max(TreeNode root){

        if(root == null)
            return null;

        if(root.right == null)
            return root;

        return max(root.right);
    }

    private void scanDuplicate(TreeNode root){

        if(root == null)
            return;

        Integer count;

        if(counter.get(root.val) == null)
            count = 0;
        else
            count = counter.get(root.val);

        count++;

        counter.put(root.val,count);

        scanDuplicate(root.left);

        scanDuplicate(root.right);

    }

    private boolean hasDuplicate(TreeNode root){

        scanDuplicate(root);

        for(Map.Entry<Integer,Integer> m:counter.entrySet()){
            if(m.getValue() > 1){
                counter.clear();
                return true;
            }

        }
        counter.clear();
        return false;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        return delete(null,root,key);
    }

    private TreeNode delete(TreeNode parent,TreeNode root,int data){

        if(root == null) return null;

        if(data == root.val){

            if(parent == null){
                root = reorderRoot(root);
            }
            else if(parent.left == root){
                reorderNodesLeft(parent,root);
            }
            else if(parent.right == root){
                reorderNodesRight(parent,root);
            }

        }
        else if(data < root.val){
            delete(root,root.left,data);

        }
        else if(data > root.val){
            delete(root,root.right,data);

        }
        return root;
    }

    private TreeNode reorderRoot(TreeNode root){

        if(childCount(root) ==2){
            TreeNode minNode = min(root.right);
            minNode.left = root.left;
            root = root.right;
        }
        else {
            TreeNode child = root.left;
            if(child == null)
                child = root.right;
            root = child;
        }
        return root;
    }

    private void reorderNodesLeft(TreeNode parent, TreeNode root){


        if(childCount(root) ==2){

            TreeNode minNode = min(root.right);
            minNode.left = root.left;
            parent.left = root.right;

        }
        else {
            TreeNode child = root.left;
            if(child == null)
                child = root.right;
            parent.left = child;
        }
    }

    private void reorderNodesRight(TreeNode parent, TreeNode root){


        if(childCount(root) ==2){
            parent.right = root.right;
            TreeNode minNode = min(parent.right);
            minNode.left = root.left;
        }
        else {
            TreeNode child = root.left;
            if(child == null)
                child = root.right;
            parent.right = child;
        }
    }

    public static TreeNode buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(queue.size()>0 && i < ip.length) {

            // Get and remove the front of the queue
            TreeNode currTreeNode = queue.peek();
            queue.remove();

            // Get the current TreeNode's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if(!currVal.equals("N")) {

                // Create the left child for the current TreeNode
                currTreeNode.left = new TreeNode(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currTreeNode.left);
            }

            // For the right child
            i++;
            if(i >= ip.length)
                break;

            currVal = ip[i];

            // If the right child is not null
            if(!currVal.equals("N")) {

                // Create the right child for the current TreeNode
                currTreeNode.right = new TreeNode(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currTreeNode.right);
            }
            i++;
        }

        return root;
    }

}