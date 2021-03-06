package com.xsm.androidexperience;

import com.example.xiasm.arithmetic.BinarySearch;
import com.xsm.androidexperience.collection.ArrayList;
import com.xsm.androidexperience.collection.ArrayStack;
import com.xsm.androidexperience.collection.LinkedList;
import com.xsm.androidexperience.collection.LinkedQueue;
import com.xsm.androidexperience.map.HashTable;
import com.xsm.androidexperience.proxy.CodeWorker;
import com.xsm.androidexperience.proxy.TeachWorker;
import com.xsm.androidexperience.proxy.Worker;
import com.xsm.androidexperience.proxy.dynamicProxy.DynamicProxy;
import com.xsm.androidexperience.proxy.staticProxy.WorkerAgent;
import com.xsm.androidexperience.tree.BinaryTree;
import com.xsm.androidexperience.tree.SearchBinaryTree;

import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.Hashtable;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() {
        System.out.println(-12 % 10);
        System.out.println(12 % 10);
    }

    @Test
    public void testArrayList() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        System.out.println("添加第一个元素后，数组的长度=" + list.size());

        String testStr = null;
        for (int i = 0; i < 19; i++) {
            String element = String.valueOf(i + 2);
            list.add(element);
            if (i == 1) {
                testStr = element;
            }
        }
        System.out.println("继续添加19个元素后，数组的长度=" + list.size());

        String s = list.get(3);
        System.out.println("数组的第四个元素是" + s);

        boolean remove = list.remove(testStr);
        if (remove) {
            System.out.println("删除的元素是" + testStr);
        }

        list.add(0, "0");
        System.out.println("继续添加1个元素后，数组的长度=" + list.size());

        System.out.println("数组的内容=" + list.toString());

        //越界测试
//        list.add(25, "25");
    }

    @Test
    public void testLinkedList() {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        System.out.println("添加第一个元素后，数组的长度=" + list.size());

        String testStr = null;
        for (int i = 0; i < 19; i++) {
            String element = String.valueOf(i + 2);
            list.add(element);
            if (i == 1) {
                testStr = element;
            }
        }
        System.out.println("继续添加19个元素后，数组的长度=" + list.size());

        String s = list.get(3);
        System.out.println("数组的第四个元素是" + s);

        boolean remove = list.remove(testStr);
        if (remove) {
            System.out.println("删除的元素是" + testStr);
        }

        list.add(0, "0");
        System.out.println("继续添加1个元素后，数组的长度=" + list.size());

        System.out.println("数组的内容=" + list.toString());

        //越界测试
//        list.add(25, "25");
    }

    @Test
    public void testArrayStack() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        System.out.println("是否空栈" + stack.isEmpty());

        for (int i = 0; i < 5; i++) {
            stack.push(i + 1);
        }
        System.out.println("栈顶元素为" + stack.peek().toString());
        System.out.println("栈的所有元素为" + stack.toString());

        System.out.println("出栈元素为" + stack.pop().toString());

        System.out.println("栈顶元素为" + stack.peek().toString());
        System.out.println("栈的所有元素为" + stack.toString());

//        //栈溢出测试
//        for (int i = 0; i < 20; i++) {
//            stack.push(i);
//        }

    }

    @Test
    public void testLinkedQueue() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }
        System.out.println("队列的大小为" + queue.size());

        System.out.println("队头为" + queue.peek());

        System.out.println("出对一个元素=" + queue.poll());
        System.out.println("队列的大小为" + queue.size());

        System.out.println("队头为" + queue.peek());


    }

    @Test
    public void testHashTable() {
        HashTable<Integer, String> table = new HashTable<>(10);
        for (int i = 0; i < 5; i++) {
            table.put(i + 1, String.valueOf(i + 1));
        }
        System.out.println(table.toString());

        System.out.println("获取key=5的value为" + table.get(5));
        table.put(5, "100");
        System.out.println("获取key=5的value为" + table.get(5));

        table.clear();
        System.out.println(table.toString());

        for (int i = 1; i <= 30; i++) {
            table.put(i, String.valueOf(i));
        }
        System.out.println(table);
    }


    @Test
    public void binaryTreeTest() {
        BinaryTree binaryTree = new BinaryTree("A");
        binaryTree.createTree();
        System.out.println("前序遍历：");
        binaryTree.preOrderTraverse(binaryTree.getRoot());
        System.out.println();
        System.out.println("前序遍历-栈实现：");
        binaryTree.preOrderTraverseByStack(binaryTree.getRoot());
        System.out.println();
        System.out.println("中序遍历：");
        binaryTree.midOrderTraverse(binaryTree.getRoot());
        System.out.println();
        System.out.println("中序遍历-栈实现：");
        binaryTree.midOrderTraverseByStack(binaryTree.getRoot());
        System.out.println();

        System.out.println("后序遍历：");
        binaryTree.postOrderTraverse(binaryTree.getRoot());
    }

    @Test
    public void searchBinaryTreeTest() {
        int[] arrays = {12, 3 ,23, 5 ,8, 1, 19};
        SearchBinaryTree tree = new SearchBinaryTree();
        for(int i: arrays) {
            tree.put(i);
        }
        tree.midOrderTraverse(tree.getRoot());


        System.out.println();
        SearchBinaryTree.TreeNode node = tree.searchNode(5);
        System.out.println(node != null ? node.data : null);

        tree.removeNode(node);
        tree.midOrderTraverse(tree.getRoot());
    }

    @Test
    public void proxyTest() {
//        new WorkerAgent(new CodeWorker()).work();
//        new WorkerAgent(new TeachWorker()).work();

        DynamicProxy invocationHandler = new DynamicProxy(new CodeWorker());
        //加上这句将会产生一个$Proxy0.class文件，这个文件即为动态生成的代理类文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        ((Worker) Proxy.newProxyInstance(Worker.class.getClassLoader(), new Class[]{Worker.class}, invocationHandler)).work();

    }

    @Test
    public void binSearchTest() {
        int[] src = new int[]{0, 1, 3, 4, 5, 7, 8, 9, 12};
        int i = BinarySearch.binSearch(src, 6, 0, src.length - 1);
        System.out.println("索引为:" + i);
    }
}