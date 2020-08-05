package com.lx.demo.arithmetic.offer;

import com.lx.demo.arithmetic.common.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Auther: allanyang
 * @Date: 2019/11/16 11:48
 * @Description:
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class O_04_重建二叉树 {
    public static void main(String[] args) {
        int[] pre = {1,2,4,5,8,9,3,6,7};
        int[] in = {4,2,8,5,9,1,6,3,7};

        TreeNode node = reConstructBinaryTree(pre,in);
        inShow(node);

    }

    // 记录中序遍历中每个指和对应的索引值
    private static final Map<Integer, Integer> index4InOrders = new HashMap<>();

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        for (int i = 0;i < in.length;i++) {
            index4InOrders.put(in[i], i);
        }

        return process(pre, 0, pre.length-1, 0);
    }

    /**
     * @param pre 先序遍历数组
     * @param preL 当前树中（先序遍历的第一个节点为根节点的时候），树的根节点
     * @param preR 当前树中，树的最右节点（因为先序遍历的顺序是根左右，所以preR恰好是树的最右节点）
     * @param inL 当前树中，树的最左节点
     * @return
     */
    private static TreeNode process(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }

        TreeNode node = new TreeNode(pre[preL]);
        Integer leftSize = index4InOrders.get(pre[preL]) - inL;
        node.left = process(pre, preL+1, preL + leftSize, inL);
        node.right = process(pre, preL+leftSize+1,preR, inL+leftSize+1);

        return node;
    }


    private static void preShow(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                System.out.print(node.val + " ");
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }
    private static void inShow(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

}