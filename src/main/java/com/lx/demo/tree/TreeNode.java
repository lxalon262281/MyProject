package com.lx.demo.tree;

public class TreeNode {
    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;
    private String value;
    public TreeNode getLeftTreeNode() {
        return leftTreeNode;
    }

    public void setLeftTreeNode(TreeNode leftTreeNode) {
        this.leftTreeNode = leftTreeNode;
    }

    public TreeNode getRightTreeNode() {
        return rightTreeNode;
    }

    public void setRightTreeNode(TreeNode rightTreeNode) {
        this.rightTreeNode = rightTreeNode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreeNode(String value) {
        super();
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode [leftTreeNode=" + leftTreeNode + ", rightTreeNode=" + rightTreeNode + ", value=" + value + "]";
    }
}
