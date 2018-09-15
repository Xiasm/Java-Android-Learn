package com.xsm.androidexperience;

import com.xsm.androidexperience.collection.ArrayList;
import com.xsm.androidexperience.collection.ArrayStack;
import com.xsm.androidexperience.collection.LinkedList;

import org.junit.Test;

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
        int a = 5;
        int b = a + (a >> 1);
        System.out.println("a=" + a + "    b=" + b);
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


}