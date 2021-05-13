package com.leetcode.topic601_650;

/**
 * @author knight
 * @version v1.0.0
 * @Package : com.leetcode.topic601_650
 * @Description : 法一 ： 数组加指针   法二： 双向链表
 * @Create on : 2021/5/12 20:35
 *
 * 利用数组加头尾指针， 队列空，head == tail  队列满 (tail + 1) % size = head;
 * 重点：  head  指向队列头部第 11 个有效数据的位置
 *        tail : 指向队列尾部（即最后 11 个有效数据）的 下一个位置，即下一个从队尾入队元素的位置
 **/
public class Problem641 {

    class MyCircularDeque {

        private final int[] cycleArray;

        private int capacity ;

        private int head;

        private int tail;

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            capacity = k + 1;
            cycleArray = new int[k + 1];
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            head = (head + capacity - 1) % capacity;
            cycleArray[head] = value;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            cycleArray[tail] = value;
            tail = (tail + 1) % capacity;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
//            cycleArray[head] = null;
            head = (head + 1) % capacity;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
//            cycleArray[tail] = null;
            tail = (tail + capacity - 1) % capacity;
            return true;

        }

        /** Get the front item from the deque. */
        public int getFront() {
            if (isEmpty()) return -1;
            return  cycleArray[head];
        }

        /** Get the last item from the deque. */
        public int getRear() {

            if (isEmpty()) return -1;
            // 当 rear 为 0 时防止数组越界
            return cycleArray[(tail - 1 + capacity) % capacity];
//            return  cycleArray[tail];

        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return head == tail;

        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return (tail + 1) % cycleArray.length == head;
        }
    }
}
