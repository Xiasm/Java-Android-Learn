package com.xsm.androidexperience.tree;

import java.util.Stack;

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
        System.out.print(root.data);
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);
    }

    /**
     * 前序遍历，利用栈实现
     * 其实栈实现利用的思想还是递归，只不过上面的递归是jvm实现的方法栈
     */
    public void preOrderTraverseByStack(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node<String>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<String> node = stack.pop();
            System.out.print(node.data);
            if (node.rightChild != null) {
                stack.push(node.rightChild);
            }
            if (node.leftChild != null) {
                stack.push(node.leftChild);
            }
        }
    }

    /**
     * 中序遍历，递归算法
     */
    public void midOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        midOrderTraverse(root.leftChild);
        System.out.print(root.data);
        midOrderTraverse(root.rightChild);
    }

    public void midOrderTraverseByStack(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node<String>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            while (stack.peek().leftChild != null) {
                stack.push(stack.peek().leftChild);
            }
            while (!stack.isEmpty()) {
                Node<String> node = stack.pop();
                System.out.print(node.data);
                if (node.rightChild != null) {
                    stack.push(node.rightChild);
                }
            }
        }
    }

    /**
     * 后序遍历，递归算法
     */
    public void postOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraverse(root.leftChild);
        postOrderTraverse(root.rightChild);
        System.out.print(root.data);
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
