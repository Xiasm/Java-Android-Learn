package com.xsm.androidexperience.collection;

import java.util.Arrays;

/**
 * 自己实现的ArrayList，目的是为了更好的理解ArrayList的原理，
 * 此类实现了ArrayList一些主要的功能，有兴趣的同学可以继续扩展。
 */
public class ArrayList<E> implements Collection<E> {
    //默认容量
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = new Object[]{};

    private int size;

    /**
     * ArrayList 源码中这个字段加了transient(此关键字保证不被序列化) 为什么要这样做呢？
     * 原因在于elementData是一个缓存数组，它通常会预留一些容量，等容量不足时再扩充容量，
     * 那么有些空间可能就没有实际存储元素，所以ArrayList的序列化调用的是
     * readObject(java.io.ObjectInputStream s)和writeObject(java.io.ObjectOutputStream s)方法写入元素
     * @return
     */
    Object[] elementData;

    public ArrayList() {
        elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
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
        return indexOf(0) >= 0;
    }

    @Override
    public void add(E element) {
        //1.先确保数组容量是否足够，如果不够就扩容
        ensureCapacityInternal(size + 1);

        elementData[size++] = element;
    }

    @Override
    public void add(int index, E element) {
        //1.先判断index是否越界
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("数组大小为" + size + " 要添加的位置为" + index);
        }

        //2.确保数组容量是否足够，如果不够就扩容
        ensureCapacityInternal(size + 1);

        /**
         * 3.拷贝数组
         * arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
         * src:源数组；
         * srcPos:源数组要复制的起始位置；
         * dest:目的数组；
         * destPos:目的数组放置的起始位置；
         * length:复制的长度。
         * 注意：src and dest都必须是同类型或者可以进行转换类型的数组．
         */
        System.arraycopy(elementData, index, elementData, index + 1, size - index);

        //赋值
        elementData[index] = element;
        size++;

    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    fastRemove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("数组大小为" + size + " 要获取的位置为" + index);
        }

        return (E) elementData[index];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }


    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 确保在数组容量内部，如果数组容量不够就扩容
     * @param minCapacity 最小容量
     */
    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        ensureExplicitCapacity(minCapacity);
    }

    /**
     * 确保扩展到最小容量
     * @param minCapacity
     */
    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    /**
     * 通过代码中的规则增长数组
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        //newCapacity的容量为oldCapacity + oldCapacity/2 取整，所以可以知道ArrayList是如何增长容量的
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        //TODO:在这里可以考虑增加数组最大长度的限制

        elementData = Arrays.copyOf(elementData, newCapacity);

    }

    /**
     * 不检查是否越界的删除，仅供内部使用
     * @param index
     */
    private void fastRemove(int index) {
        //numMoved就是要删除的索引后面的元素个数
        int numMoved = size - index - 1;

        if (numMoved > 0) {
            /**
             * 3.拷贝数组
             * arraycopy(Object src,int srcPos,Object dest,int destPos,int length)
             * src:源数组；
             * srcPos:源数组要复制的起始位置；
             * dest:目的数组；
             * destPos:目的数组放置的起始位置；
             * length:复制的长度。
             * 注意：src and dest都必须是同类型或者可以进行转换类型的数组．
             */
            System.arraycopy(elementData, index+1, elementData, index, numMoved);

            //拷贝数组后，删除数组最后的一个元素
            elementData[--size] = null;
        } else {
            elementData[--size] = null;
        }

    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (int i = 0; i < size; i++) {
            builder.append("[" + elementData[i] + "]");
        }
        builder.append("}");
        return builder.toString();
    }
}
