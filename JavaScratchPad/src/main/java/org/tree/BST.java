package org.tree;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BST {

    private Map<Integer,Integer> counter = new HashMap<>();
    public boolean isValidBST(TreeNode root) {
        boolean isBST = false;

        if(hasDuplicate(root))
            return false;

        if(isEmptyTree(root))
            return true;

        if(isLess(min(root.right),root) || isGreater(max(root.left),root))
                return false;

        isBST = isValidBST(root.left) && isValidBST(root.right);

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
        if(isNull(root))
            return new TreeNode(100000);

        if(isNull(root.left))
            return root;

        return min(root.left);
    }

    private TreeNode max(TreeNode root){
        if(isNull(root))
            return new TreeNode(0);

        if(isNull(root.right))
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

        if(isEqual(data,root)){

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
        else if(isLess(data,root)){
            delete(root,root.left,data);

        }
        else if(isGreater(data,root)){
            delete(root,root.right,data);

        }
        return root;
    }

    private boolean isEqual(int data,TreeNode root){
        return data == root.val;
    }

    private boolean isLess(int data,TreeNode root){
        return data < root.val;
    }
    private boolean isGreater(int data,TreeNode root){
        return data > root.val;
    }

    private TreeNode reorderRoot(TreeNode root){

        if(childCount(root) ==2){
            TreeNode minNode = min(root.right);
            minNode.left = root.left;
            root = root.right;
        }
        else {
            root = getChild(root);
        }
        return root;
    }

    private void reorderNodesLeft(TreeNode parent, TreeNode root){


        if(childCount(root) ==2){
            parent.left = root.right;
            TreeNode minNode = min(root.right);
            minNode.left = root.left;

        }
        else {
            parent.left = getChild(root);
        }
    }

    private void reorderNodesRight(TreeNode parent, TreeNode root){


        if(childCount(root) ==2){
            parent.right = root.right;
            TreeNode minNode = min(parent.right);
            minNode.left = root.left;
        }
        else {
            parent.right = getChild(root);
        }
    }

    private TreeNode getChild(TreeNode root){
        TreeNode child = root.left;
        if(child == null)
            child = root.right;
        return child;
    }
    public static TreeNode buildTree(String str){

        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }

        String[] ip = str.split(" ");
        // Create the root of the tree
        TreeNode root = new TreeNode(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while(!queue.isEmpty() && i < ip.length) {

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

    public int getHeight(TreeNode root){

        return height(root,0);
    }

    private int height(TreeNode node, int pathCount){
        int pathLength = pathCount;

        if(node !=null){
            if(isLeafNode(node)){

                 return pathCount;
            }
            pathCount++;

            int pathLen1 = height(node.left,pathCount);
            int pathLen2 = height(node.right,pathCount);
            pathLength =  Math.max(pathLen1,pathLen2);
        }

        return pathLength;
    }

    private boolean isLeafNode(TreeNode node){
        boolean isLeaf = false;
        if(node.left == null && node.right == null)
            isLeaf = true;

        return isLeaf;
    }

    public void BreadthFirstTraversal(TreeNode root){

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(root);

        while(!queue.isEmpty()){
            if(queue.peek().left!=null)
                queue.add(queue.peek().left);

            if(queue.peek().right!=null)
                queue.add(queue.peek().right);

            System.out.println(""+queue.poll().val);
        }
    }
}
