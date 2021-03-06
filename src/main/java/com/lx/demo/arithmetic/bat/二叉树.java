package com.lx.demo.arithmetic.bat;

/**
 * @Auther: allanyang
 * @Date: 2020/1/13 10:31
 * @Description:
 */
public class 二叉树 {

    // 0.二叉搜索树
    /**
     * 中序遍历是递增的
     *
     * 平衡二叉树，红黑树都是二叉搜索树的实现
     */

    // 1.平衡二叉树（AVL树）
    /**
     * 1.空树是平衡二叉树
     * 2.如果一棵树不为空，那么所有的字数都满足各自的左子树与右子树的高度差都不超过1.
     * 3.是一颗二叉搜索树（中序遍历后是递增的）
     */

    // 2.红黑树（RB树）
    /**
     * 并不是所有的树都可以标记成红黑树，并且标记成红黑树的方式也不止一种。
     * 相对于平衡二叉树的好处是他在增删的时候保证树的旋转次数不超过2次，而平衡二叉树再增删的时候旋转次数不可控。
     * 也叫2/3/4树，因此叶子节点个数2^h~4^h,因此高度小于lg（n）
     *
     * 1.所有的节点中，要么是红色，要么是黑色。
     * 2.根节点或叶子节点（nil），都要是黑色。
     * 3.两个红色节点不能相连，如果相连就要进行重新染色和旋转。
     * 4.树的高度就是黑色节点的高度/
     */

    // 3.B树
    /**
     * 磁盘块的数据结构，每个磁盘块真实存储数据节点。
     *
     * 1.每个节点至多有m颗字数。
     * 2.除根节点外，每个分支至少有m/2颗字树。
     * 3.根节点至少有两颗子树。
     * 4.所有叶子节点都在同一层。
     * 5.有j个飞叶子节点恰好有j-1个索引，索引按次数递增。
     */

    // 4.B+树
    /**
     * 数据库索引的数据结构。只有叶子系欸但才存储真实数据
     *
     * 1.所有数据都在叶子节点
     * 2.叶子节点有链表从头到尾连接，便于范围查询。
     */

    // 5.跳跃表
    /**
     * 1-(1/2)^n的概率可以再O（lgn）内拿下，空间复杂度O（n）.
     * 类比与地铁和地铁快线。
     */

    // 6.判断一棵树是否是平衡二叉树
    /**
     * 分别用递归的方式来解决。
     */

    // 7.判断一棵树是否是二叉搜索树
    /**
     * 1.中序遍历的方法
     *
     * 2.process(root, int maxValue, int minValue).判断root是否大于minValue，小于maxValue(初始化传入Integer.MAX_VALUE/Integer.MIN_VALUE)
     */

    // 8.判断一棵树是否是完全二叉树
    /**
     * 用按层遍历的方式，如果出现了某个节点为null（此时要用一个变量标记下来），后续还存在节点的情况，那么就不是完全二叉树。
     */

    // 9.后继节点和前驱结点
    /**
     *  后继节点：中序遍历的下一个节点
     *  前驱结点：中序遍历的上一个节点
     */

    // 10.请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折一次，压出折痕后展开，此时这很是凹下去的，即这很突起的方向指向纸条的背面。如果从纸条的下边向上方连续对折2次，压出折痕后展开。，此时又三条折痕。给定一个输入参数N，代表纸条都从下边向上方连续对折N次，请从上到下打印所有折痕的方向。
    /**
     * 其实就是一个完全二叉树，中序遍历。
     */

}