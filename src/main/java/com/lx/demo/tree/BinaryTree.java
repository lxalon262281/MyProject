package com.lx.demo.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉数的构建与遍历
 */
public class BinaryTree {
    public static String[] array = {"7","4","8","6","2","3","9"};
    public static int index = 0;

    private TreeNode root;
    public TreeNode getRoot() {
        return root;
    }

    //根据根节点创建完全二叉树
    public static TreeNode addNode2(TreeNode root, List<String> list) {
        int count = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty() && count < list.size()) {
            TreeNode cur = queue.poll();

            if (count < list.size()) {
                TreeNode left = new TreeNode(list.get(count++));
                cur.setLeftTreeNode(left);
                queue.add(left);
            }
            if (count < list.size()) {
                TreeNode right = new TreeNode(list.get(count++));
                cur.setRightTreeNode(right);
                queue.add(right);
            }
        }
        return root;
    }
    public static TreeNode createTree(TreeNode node, int i) {
        if (array[i].equals("#") && node == null) {
            return null;
        } else {
            node = new TreeNode(array[i]);
            if (i < array.length - 1) {
                node.setLeftTreeNode(createTree(node.getLeftTreeNode(), ++i));
            }
            if (i < array.length - 1) {
                node.setRightTreeNode(createTree(node.getRightTreeNode(), ++i));
            }
            return node;
        }


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
                } else {// 往左放
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
     * 中序非递归遍历
     * @param biTree
     */
    public static void midOrder(TreeNode biTree) {
        //中序遍历费递归实现
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(biTree != null || !stack.isEmpty()) {

            while(biTree != null) {
                stack.push(biTree);
                biTree = biTree.getLeftTreeNode();
            }
            if(!stack.isEmpty()) {
                biTree = stack.pop();
                System.out.println(biTree.getValue() + " ");
                biTree = biTree.getRightTreeNode();
            }
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
     * 后序遍历 非递归
     * 双栈法
     */
    public static void postOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                output.push(node);
                node = node.getRightTreeNode();
            } else {
                node = stack.pop();
                node = node.getLeftTreeNode();
            }
        }

        while (output.size() > 0) {
            TreeNode n = output.pop();
            System.out.print(n.getValue() + "\t");
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

    /**
     * 先序非递归实现
     * @param biTree
     */
    public static void preOrder(TreeNode biTree) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(biTree != null || !stack.isEmpty()) {
            while(biTree != null) {
                System.out.print(biTree.getValue() + " ");
                stack.push(biTree);
                biTree = biTree.getLeftTreeNode();
            }
            if(!stack.isEmpty()) {
                biTree = stack.pop();
                biTree = biTree.getRightTreeNode();
            }
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

        tree.root = addNode2(root,Arrays.asList(array));
        System.out.println(tree.root);
        tree.postOrder2(tree.getRoot());
        System.out.println();
//        tree.inOrder(tree.getRoot());
//        System.out.println();
//        tree.preOrder(tree.getRoot());
        tree.afterOrder(tree.getRoot());

    }

}
