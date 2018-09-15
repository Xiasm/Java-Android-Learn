package com.xsm.androidexperience.collection;

public class LinkedList<E> implements Collection<E> {

    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public LinkedList() {
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public void add(E element) {
        linkLast(element);
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("链表大小为" + size + " 要添加的位置为" + index);
        }

        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("链表大小为" + size + " 要获取的位置为" + index);
        }

        return node(index).item;
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.prev = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    return index;
                }
                index++;
            }
        }

        return -1;
    }

    /**
     * 在succ节点之前插入e
     * @param e
     * @param succ
     */
    private void linkBefore(E e, Node<E> succ) {
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    private void linkLast(E element) {
        final Node<E> thisLast = last;
        final Node<E> newNode = new Node<>(thisLast, element, null);
        last = newNode;
        if (thisLast == null) {
            first = newNode;
        } else {
            thisLast.next = newNode;
        }
        size++;

    }

    private E unlink(Node<E> node) {
        final E element = node.item;
        final Node<E> prev = node.prev;
        final Node<E> next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }
        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;
        return element;
    }

    /**
     * 返回指定的节点，不检查是否越界。
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        //查找小优化，如果要查找的元素在前半段，则从头节点开始遍历，否则从尾节点遍历
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i < index; i--) {
                x= x.prev;
            }
            return x;
        }
    }

    private static class Node<E> {
        E item;
        //前驱
        Node<E> prev;
        //后继
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        builder.append("[" + first.item + "]");
        for (Node<E> x = first; x.next != null; x = x.next) {
            builder.append("[" + x.next.item + "]");
        }
        builder.append("}");
        return builder.toString();
    }
}
