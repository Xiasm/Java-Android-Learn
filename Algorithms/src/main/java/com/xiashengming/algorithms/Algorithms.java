package com.xiashengming.algorithms;

public class Algorithms {

    /**
     * 使用快慢指针 判断链表是否有环
     * https://leetcode-cn.com/problems/linked-list-cycle-ii/comments/
     * @param head
     * @return
     */
    public static boolean isLinkedListContainsLoop(SingleNode head) {
        if (head == null) {
            return false;
        }
        SingleNode fastP = head;
        SingleNode slowP = head;
        boolean hasLoop = false;

        while (fastP.next != null && fastP.next.next != null) {
            fastP = fastP.next.next;
            slowP = slowP.next;
            if (fastP == slowP) {
                return true;
            }
        }
        return false;
    }

    /**
     * 单向链表
     */
    public class SingleNode {
        public SingleNode next;
    }
}
