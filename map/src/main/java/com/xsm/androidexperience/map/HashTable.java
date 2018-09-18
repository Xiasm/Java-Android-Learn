package com.xsm.androidexperience.map;

/**
 * 自己实现HashTable，hash算法为hashMap对key的hash()算法值得绝对值取余容量。
 */
public class HashTable<K, V> implements Map<K, V> {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
    private int initialCapacity;

    private int size;
    Node<K, V>[] table;

    public HashTable() {
        initTable(DEFAULT_INITIAL_CAPACITY);
    }

    public HashTable(int initialCapacity) {
        if (initialCapacity > 0) {
            initTable(initialCapacity);
        } else {
            initTable(DEFAULT_INITIAL_CAPACITY);
        }
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
    public V get(Object key) {
        Node<K, V> node = getNode(hash(key), key);
        return node == null ? null : node.value;
    }

    @Override
    public V put(K key, V value) {
        putVal(hash(key), key, value);
        return value;
    }

    @Override
    public V remove(Object key) {
        Node<K, V> node = removeNode(hash(key), key);
        return node == null ? null : node.value;
    }

    @Override
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            Node<K, V> node = table[i];
            while (node != null) {
                Node<K, V> thisNode = node;
                node = node.next;

                thisNode.key = null;
                thisNode.value = null;
                thisNode.next = null;
            }
            table[i] = null;
        }
    }

    private Node<K, V> removeNode(int hash, Object key) {
        Node<K, V> topNode = table[hash];
        if (topNode == null)
            return null;
        if (topNode.key == key) {
            if (topNode.next == null) {
                table[hash] = null;
            } else {
                table[hash] = topNode.next;
            }
            return topNode;
        }
        if (topNode.next == null) {
            return null;
        }

        for (Node<K, V> x = topNode; ;x = x.next) {
            if (x.next == null) {
                return null;
            }
            if (x.next.key == key) {
                final Node<K, V> node = x.next;
                x.next = node.next;
                return node;
            }
            x = x.next;
        }

    }

    private Node<K, V> getNode(int hash, Object key) {
        Node<K, V> topNode = table[hash];
        if (topNode == null)
            return null;
        Node<K, V> x = topNode;
        while (x != null) {
            if (x.key == key) {
                break;
            }
            x = x.next;
        }
        return x;
    }

    private void putVal(int hash, K key, V value) {
        Node<K, V> topNode = table[hash];
        if (topNode == null) {
            topNode = new Node<>(hash, key, value, null);
            table[hash] = topNode;
        } else {
            Node<K, V> x = topNode;
            while (x != null) {
                if (x.next == null) {
                    x.next = new Node<K, V>(hash, key, value, null);
                    break;
                }
                x = x.next;
            }
        }
        size++;
    }

    private void initTable(int initialCapacity) {
        //(Node<K,V>[])new Node[newCap]
        this.initialCapacity = initialCapacity;
        table = (Node<K, V>[]) new Node[initialCapacity];
    }

    private final int hash(Object key) {
        int h;
        return Math.abs((key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16)) % initialCapacity;
    }


    static class Node<K, V> {
        final int hash;
        K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (int i = 0; i < table.length; i++) {
            builder.append("[");
            Node<K, V> topNode = table[i];
            while (topNode != null) {
                builder.append("{").append("key=").append(topNode.key).append(",value=").append(topNode.value).append("}");
                topNode = topNode.next;
            }
            builder.append("]");
        }
        builder.append("}");
        return builder.toString();
    }
}
