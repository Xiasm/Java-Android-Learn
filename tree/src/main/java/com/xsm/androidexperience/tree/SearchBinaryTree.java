package com.xsm.androidexperience.tree;

import java.util.NoSuchElementException;

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

    public TreeNode searchNode(int data) {
        if (root == null) {
            return null;
        }
        TreeNode node = root;
        while (node != null) {
            if (node.data == data) {
                return node;
            } else if (node.data > data) {
                node = node.leftChild;
            } else {
                node = node.rightChild;
            }
        }
        return null;
    }

    /**
     * 删除一个节点
     * @param node
     */
    public void removeNode(TreeNode node) {
        if (node == null) {
            throw new NoSuchElementException();
        }
        TreeNode parent = node.parent;
        if (node.leftChild == null && node.rightChild == null) {
            //没有孩子节点
            if (parent == null) {
                root = null;
            } else if (parent.rightChild == node) {
                parent.rightChild = null;
            } else {
                parent.leftChild = null;
            }
            node.parent = null;
        } else if (node.leftChild != null && node.rightChild == null) {
            //只有左孩子
            if (parent == null) {
                node.parent = null;
                node.leftChild.parent = null;
                root = node.leftChild;
            } else {
                if (parent.leftChild == node) {
                    parent.leftChild = node.leftChild;
                } else {
                    parent.rightChild = node.leftChild;
                }
                node.parent = null;
            }
        } else if (node.leftChild == null && node.rightChild != null) {
            //只有右孩子
            if (parent == null) {
                node.parent = null;
                node.rightChild.parent = null;
                root = node.rightChild;
            } else {
                if (parent.leftChild == node) {
                    parent.leftChild = node.rightChild;
                } else {
                    parent.rightChild = node.rightChild;
                }
                node.parent = null;
            }
        } else {
            //有左右两个孩子

            //删除节点的右子树的左子树是否为空
            if (node.rightChild.leftChild == null) {
                // 如果为空，则把删除节点的右子树设为删除节点的左子树的根
                node.rightChild.leftChild = node.leftChild;
                if (parent == null) {
                    root = node.rightChild;
                } else if (parent.leftChild == node) {
                    parent.leftChild = node.rightChild;
                } else {
                    parent.rightChild = node.rightChild;
                }
                node.parent = null;
            } else {
                //不为空,找到node的右子树的最小节点（最左子树）
                TreeNode leftNode = getMinLeftNode(node.rightChild);
                //1
                leftNode.leftChild = node.leftChild;
                //2
                TreeNode leftNodeP = leftNode.parent;
                leftNodeP.leftChild = leftNode.rightChild;
                //3
                leftNode.rightChild = node.rightChild;
                //4
                if (parent == null) {
                    root = leftNode;
                } else {
                    if (parent.leftChild == node) {
                        parent.leftChild = leftNode;
                    } else {
                        parent.rightChild = leftNode;
                    }
                }
            }


        }
    }

    private TreeNode getMinLeftNode(TreeNode node) {
        TreeNode curRoot = null;
        if (node == null) {
            return null;
        } else {
            curRoot = node;
            while (curRoot.leftChild != null) {
                curRoot = curRoot.leftChild;
            }
        }

        return null;
    }


    public class TreeNode {
        public int data;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;

        public TreeNode(int data) {
            this.data = data;
        }
    }


}
