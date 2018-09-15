package com.xsm.androidexperience.collection;

/**
 * 单链表结构的栈实现，支持尾端入队，队头出对，实现的目的是为了更好的理解队列这种数据结构，所以只实现了主要的功能，有兴趣的同学可以继续扩展。
 */
public class LinkedQueue<E> {
    public static final int DEFAULT_QUEUE_CAPACITY = 20;
    private int size;
    private Node<E> first;
    private Node<E> last;

    public LinkedQueue() {
    }

    public boolean add(E e) {
        if (size < DEFAULT_QUEUE_CAPACITY) {
            linkLast(e);
            return true;
        }
        return false;
    }

    public E peek() {
        return first.item;
    }

    public E poll() {
        return removeFirst();
    }

    private E removeFirst() {
        if (size == 0) {
            return null;
        }
        final Node<E> oldFirst = first;
        first = first.next;
        size--;
        return oldFirst.item;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        for (Node<E> x = first; x != null;) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }


    private void linkLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (size == 0) {
            first = last = newNode;
        } else {
            final Node<E> lastNode = last;
            lastNode.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("[").append(first.item).append("]");
        for (Node<E> x = first; x.next != null; x = x.next) {
            builder.append("[").append(x.next.item).append("]");
        }
        builder.append("}");
        return builder.toString();
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }
    }


}
