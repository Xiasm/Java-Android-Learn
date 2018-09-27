package com.xsm.androidexperience.tree;

public class BinaryTree {
    Node<String> root;

    public Node<String> getRoot() {
        return root;
    }

    public BinaryTree(String data) {
        this.root = new Node<String>(data, null, null);
    }

    /**
     * 前序遍历，递归算法
     * 先遍历自己的数据域，然后遍历左子树，最后遍历右子树
     *      A
     *  B      C
     *  前序遍历：ABC
     */
    public void preOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);

    }


    public void midOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        midOrderTraverse(root.leftChild);
        System.out.println(root.data);
        midOrderTraverse(root.rightChild);
    }


    public void postOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraverse(root.leftChild);
        postOrderTraverse(root.rightChild);
        System.out.println(root.data);
    }

    /**
     * 构建二叉树
     *              A
     *         B          C
     *      D    E             F
     *
     * 前序遍历：ABDECF
     * 中序遍历：DBEACF
     * 后序遍历：DEBFCA
     */
    public void createTree() {
        Node<String> B = new Node<String>("B", null, null);
        Node<String> C = new Node<String>("C", null, null);
        Node<String> D = new Node<String>("D", null, null);
        Node<String> E = new Node<String>("E", null, null);
        Node<String> F = new Node<String>("F", null, null);
        root.leftChild = B;
        root.rightChild = C;
        B.leftChild = D;
        B.rightChild = E;
        C.rightChild = F;
    }

    public class Node<T> {
        T data;
        Node leftChild;
        Node rightChild;

        public Node(T data, Node leftChild, Node rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
}
