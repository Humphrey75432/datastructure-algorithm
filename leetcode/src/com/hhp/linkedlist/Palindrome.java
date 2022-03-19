package com.hhp.linkedlist;

public class Palindrome {

    /**
     * 判断链表是否为回文
     * 具体思路如下：找出链表的前后两半部分，然后将后半部分反转，如果每个节点的值都一样，则链表为回文
     * 1. 定义快慢指针，都从头部开始
     * 2. 当快指针没到链表尾部时，执行下列移动规则：
     *  2.1 慢指针移动一个节点；（长度为偶数）
     *  2.2 快指针移动两个节点；（长度为偶数）
     *  2.3 对于长度为奇数的链表，慢指针到最后一个不为空的节点后，要再将慢指针移动一个节点；
     * 3. 反转慢指针指向的后半部分链表；
     * 4. 将快指针移动到头结点；
     * 5. 逐个循环比较快慢指针指向的节点元素
     *  5.1 如果相等，则比较下一个节点；
     *  5.2 否则退出循环，链表不回文；
     * 6. 结束
     * */
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        slow = reverseList(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode currNode = head;

        while (currNode != null) {
            ListNode next = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = next;
        }
        return preNode;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(node1));
    }
}
