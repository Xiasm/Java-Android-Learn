package com.xsm.androidexperience.tree;

/**
 * 二叉排序树
 *（1）若左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 *（2）若右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 *（3）左、右子树也分别为二叉排序树；
 *（4）没有键值相等的节点。
 */
public class SearchBinaryTree {

    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode put(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        TreeNode parent = null;
        TreeNode node = root;
        for (;node != null;) {
            parent = node;
            if (data < node.data) {
                node = node.leftChild;
            } else if (data > node.data) {
                node = node.rightChild;
            } else {
                return node;
            }
        }
        TreeNode treeNode = new TreeNode(data);
        if (data < parent.data) {
            parent.leftChild = treeNode;
        } else {
            parent.rightChild = treeNode;
        }
        treeNode.parent = parent;
        return treeNode;
    }

    public void midOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrderTraverse(root.leftChild);
        System.out.print(root.data + "  ");
        midOrderTraverse(root.rightChild);
    }

    public class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
        }
    }


}
