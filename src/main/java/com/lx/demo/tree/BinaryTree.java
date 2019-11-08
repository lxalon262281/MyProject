package com.lx.demo.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    public static String[] array = {"7","4","8","6","2","3","9"};
    public static int index = 0;

    private TreeNode root;
    public TreeNode getRoot() {
        return root;
    }

    //根据根节点创建完全二叉树
    public static TreeNode addNode(TreeNode root, List<String> list) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty() && count < list.size()) {
            TreeNode lastNode = queue.poll();

            if (count < list.size()) {
                TreeNode left = new TreeNode(list.get(count++));
                lastNode.setLeftTreeNode(left);
                queue.add(left);
            }
            if (count < list.size()) {

                TreeNode right = new TreeNode(list.get(count++));
                lastNode.setRightTreeNode(right);
                queue.add(right);
            }
        }
        return root;
    }

    public void insert(String value) {
        //5，7，4，8，6，2，3，9
        TreeNode newNode = new TreeNode(value);
        if (root == null) {
            root = newNode;
            root.setLeftTreeNode(null);
            root.setRightTreeNode(null);
        } else {
            TreeNode currentNode = root;
            TreeNode parentNode;
            // 有孩子继续循环，一直循环到最后一个节点 和插入的节点比较 大的放到右节点，小于放到左节点
            while (true) {
                parentNode = currentNode;
                // 往右放
                if (Integer.valueOf(newNode.getValue()) > Integer.valueOf(currentNode.getValue())) {
                    currentNode = currentNode.getRightTreeNode();
                    if (currentNode == null) {
                        parentNode.setRightTreeNode(newNode);
                        return;
                    }
                } else {
                    // 往左放
                    currentNode = currentNode.getLeftTreeNode();
                    if (currentNode == null) {
                        parentNode.setLeftTreeNode(newNode);
                        return;
                    }
                }
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param treeNode
     */
    public void inOrder(TreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.getLeftTreeNode());
            System.out.print(" " + treeNode.getValue() + " ");
            inOrder(treeNode.getRightTreeNode());
        }
    }

    /**
     * 后序遍历
     *
     * @param treeNode
     */
    public void afterOrder(TreeNode treeNode) {
        if (treeNode != null) {
            afterOrder(treeNode.getLeftTreeNode());
            afterOrder(treeNode.getRightTreeNode());
            System.out.print(" " + treeNode.getValue() + " ");
        }
    }



    /**
     * 先序遍历
     *
     * @param treeNode
     */
    public void beforeOrder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(" " + treeNode.getValue() + " ");
            beforeOrder(treeNode.getLeftTreeNode());
            beforeOrder(treeNode.getRightTreeNode());
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
//        tree.insert("5");
//        tree.insert("7");
//        tree.insert("4");
//        tree.insert("8");
//        tree.insert("6");
//        tree.insert("2");
//        tree.insert("3");
//        tree.insert("9");
        TreeNode root = new TreeNode("5");
        addNode(root, Arrays.asList(array));

        System.out.println(tree.root);
        tree.beforeOrder(tree.getRoot());
        System.out.println();
        tree.inOrder(tree.getRoot());
        System.out.println();
        tree.afterOrder(tree.getRoot());
    }

}
