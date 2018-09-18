package com.xsm.androidexperience.map;

public interface Map<K, V> {

    int size();

    boolean isEmpty();

    V get(K key);

    V put(K key, V value);

    V remove(Object key);

    void clear();

}
