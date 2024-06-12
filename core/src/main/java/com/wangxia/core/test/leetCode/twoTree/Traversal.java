package com.wangxia.core.test.leetCode.twoTree;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 二叉树遍历
 */
public class Traversal {

    /**
     * 二叉树先序，中序，后序遍历
     * @param root
     * @return traverseList
     */
    public static Map<String,List<Integer>> traverse(TreeNode root) {

        TreeMap<String,List<Integer>> traverseList = new TreeMap<>(new TraversalComparator());

        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        List<Integer> postorderList = new ArrayList<>();
        traverse(root, preorderList, inorderList, postorderList);

        traverseList.put("preorderList", preorderList);
        traverseList.put("inorderList", inorderList);
        traverseList.put("postorderList", postorderList);
        return traverseList;
    }

    private static void traverse(TreeNode root, List<Integer> preorderList,List<Integer> inorderList,List<Integer> postorderList) {
        if(root == null){
            return;
        }
        preorderList.add(root.val);
        traverse(root.left, preorderList, inorderList, postorderList);
        inorderList.add(root.val);
        traverse(root.right, preorderList, inorderList, postorderList);
        postorderList.add(root.val);
    }

    /**
     * 二叉树先序遍历
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)return list;

        Stack<TreeNode> treeNodes = new Stack<>();
        treeNodes.push(root);

        while (!treeNodes.isEmpty()) {
            TreeNode node = treeNodes.pop();
            list.add(node.val);
            if (node.right != null) {
                treeNodes.push(node.right);
            }
            if (node.left != null) {
                treeNodes.push(node.left);
            }

        }
        return list;

    }

    /**
     * 二叉树中序遍历
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (root.left != null) {
                stack.push(root.left);
                root = root.left;
            }
            do {
                root = stack.pop();
                list.add(root.val);
            } while (root.right != null && !stack.isEmpty());

            if (root.right != null) {
                stack.push(root.right);
                root = root.right;
            }
        }
        return list;
    }

    /**
     * 二叉树后序遍历
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> treeNodes = new Stack<>();
        Stack<TreeNode> treeNodes1 = new Stack<>();
        treeNodes.push(root);
        while(!treeNodes.isEmpty()){
            TreeNode node = treeNodes.pop();
            treeNodes1.push(node);
            if(node.right!=null){
                treeNodes.push(node.right);
            }
            if(node.left!=null){
                treeNodes.push(node.left);
            }
        }
        while (!treeNodes1.isEmpty()){
            list.add(treeNodes1.pop().val);
        }
        return list;
    }

    /**
     * 二叉数层序遍历
     * @param root
     * @return
     */
    public static List<Integer> levelOrderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        if(root==null)return list;

        treeNodes.offer(root);

        while (!treeNodes.isEmpty()){
            root = treeNodes.poll();
            list.add(root.val);
            if(root.left!=null){
                treeNodes.offer(root.left);
            }
            if(root.right!=null){
                treeNodes.offer(root.right);
            }
        }

        return list;
    }
    
}
