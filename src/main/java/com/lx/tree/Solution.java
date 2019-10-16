package com.lx.tree;

import com.lx.thread.Station;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    //解法一:双栈实现二叉树的非递归后序遍历
    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();//存储节点
        Stack<TreeNode> temp = new Stack<>();//存储节点
        TreeNode node=root;
        while(node != null|| stack.size()>0){

            //把当前节点及其右侧节点压入栈
            while(node != null){
                stack.push(node);
                temp.push(node);
                node = node.right;
            }
            //处理栈顶的左侧节点
            if(stack.size()>0){
                node = stack.pop();
                node = node.left;
            }
        }
        while(!temp.isEmpty()){
            list.add(temp.pop().val);
        }
        return list;
    }
    public static void InOrder2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<TreeNode>();

        TreeNode p = root;//辅助节点
        stk.add(p);
        while (stk.isEmpty() == false) {
            //只要你有左孩子，就将左孩子压入栈中
            if (p != null && p.left != null) {
                stk.add(p.left);
                p = p.left;
            } else {
                p = stk.pop();//弹出栈顶节点  左孩子--->根节点
                System.out.print(p.val + " ");//访问
                if (p != null && p.right != null) {//如果栈点元素有右孩子的话，将有节点压入栈中
                    stk.add(p.right);
                    p = p.right;
                } else {
                    p = null;//p=stk.pop;已经访问过p了，p设置为null
                }
            }
        }
    }
    public static List<Integer> postorder(TreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();

        TreeNode node = root;
        while (!stack.empty()) {
            while (node != null) {
                //右孩子节点先入栈
                stack.add(node);
                temp.add(node);
                node = node.right;
            }

            if (stack.size() > 0) {
                node = stack.pop();
                node = node.left;

            }
        }
        return null;
    }

//    //方法二:单栈遍历法
//    public ArrayList<Integer> postorderTraversal2(TreeNode root) {
//        ArrayList<Integer> list=new ArrayList<>();
//        if(root==null)
//            return list;
//        Stack<TreeNode>stack=new Stack<>();//存储节点
//        stack.push(root);
//        while(!stack.isEmpty()){
//
//            TreeNode node=stack.pop();
//            list.add(0,node.val); //每次在队列的头部加入节点
//            if(node.left!=null)
//                stack.push(node.left);
//            if(node.right!=null)
//                stack.push(node.right);
//        }
//        return list;
//
//    }


    public static void main(String[]args){
        //System.out.println("Hello World!");
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        InOrder2(root);
        ArrayList list = postorderTraversal(root);
        System.out.println(list.toArray());
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}