package com.xiashengming.algorithms;

public class Algorithms {

    /**
     * 使用快慢指针 判断链表是否有环
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/comments/
     * @param head
     * @return
     */
    public static boolean isLinkedListContainsLoop(SingleNode head) {
        if (head == null) {
            return false;
        }
        SingleNode fastP = head;
        SingleNode slowP = head;
        boolean hasLoop = false;

        while (fastP.next != null && fastP.next.next != null) {
            fastP = fastP.next.next;
            slowP = slowP.next;
            if (fastP == slowP) {
                return true;
            }
        }
        return false;
    }

    /**
     * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
     *
     * 说明: 叶子节点是指没有子节点的节点。
     *
     * 示例: 
     * 给定如下二叉树，以及目标和 sum = 22，
     *
     *               5
     *              / \
     *             4   8
     *            /   / \
     *           11  13  4
     *          /  \      \
     *         7    2      1
     * ————————————————
     * 版权声明：本文为CSDN博主「moots_」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/shuzishij/article/details/81235076
     *
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.data == sum;
        }
        boolean result = true;
        result = hasPathSum(root.left, sum - root.data);
        if (result) {
            return true;
        }
        result = hasPathSum(root.right, sum - root.data);
        if (result) {
            return true;
        }
        return false;
    }

    /**
     * 单向链表
     */
    public class SingleNode {
        public SingleNode next;
    }

    /**
     * 二叉树
     */
    public class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;
    }
}
