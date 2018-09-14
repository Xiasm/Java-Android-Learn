package com.xsm.androidexperience.collection;

public interface Collection<E> {

    int size();

    boolean isEmpty();

    boolean contains(Object o);

    void add(E element);

    void add(int index, E element);

    boolean remove(Object o);

    E get(int index);

    void clear();
}
