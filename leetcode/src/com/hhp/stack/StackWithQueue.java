package com.hhp.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {

//    主队列，负责存储数据
    private Queue<Integer> queue1;
//
    private Queue<Integer> queue2;

    public StackWithQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // 将元素x压入栈顶
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // 移除并返回栈顶元素
    public int pop() {
        return queue1.poll();
    }

    // 返回栈顶元素
    public int top() {
        return queue1.peek();
    }

    // 如果栈是为空，返回true，否则返回false
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackWithQueue stack = new StackWithQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.top());
    }
}
