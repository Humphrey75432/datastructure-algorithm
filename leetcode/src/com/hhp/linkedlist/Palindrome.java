package com.hhp.linkedlist;

public class Palindrome {

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
