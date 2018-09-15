package com.xsm.androidexperience.collection;

import java.util.Arrays;

/**
 * 顺序表结构的栈实现，实现的目的是为了更好的理解栈结构，所以只实现了最主要的功能，有兴趣的同学可以继续扩展。
 */
public class ArrayStack<E> {
    //栈的最大容量
    private static final int DEFAULT_STACK_CAPACITY = 20;
    private static final Object[] DEFAULT_EMPTY_DTTA = new Object[]{};

    private Object[] elementData;
    private int size;
    private E top;

    public ArrayStack() {
        this.elementData = DEFAULT_EMPTY_DTTA;
        this.top = null;
    }

    /**
     * 入栈
     * @param item
     * @return
     */
    public E push(E item) {
        if ((size + 1) > DEFAULT_STACK_CAPACITY) {
            throw new StackOverflowError("栈最大容量为 + " + DEFAULT_STACK_CAPACITY  + ",当前压入的index为" + String.valueOf(size + 1) + ",溢出了");
        }

        addElement(item);
        return item;
    }

    /**
     * 栈顶元素出栈
     * @return
     */
    public synchronized E pop() {
        E obj = peek();
        removeLastElement();
        return obj;
    }

    /**
     * 返回栈顶元素，不出栈
     * @return
     */
    public synchronized E peek() {
        return top;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
        top = null;
    }

    private void addElement(E item) {
        ensureCapacity(size + 1);

        elementData[size] = item;
        size++;

        updateTop();
    }

    private void updateTop() {
        if (size == 0) {
            top = null;
        } else {
            top = (E) elementData[size - 1];
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (elementData.length < minCapacity) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        //newCapacity的容量为oldCapacity + oldCapacity/2 取整
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity > DEFAULT_STACK_CAPACITY) {
            newCapacity = minCapacity;
        }
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private void removeLastElement() {
        if (size != 0) {
            elementData[size - 1] = null;
            size--;
        }
        updateTop();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (int i = 0; i < size; i++) {
            builder.append(elementData[i].toString());
        }
        builder.append("}");
        return builder.toString();
    }
}
