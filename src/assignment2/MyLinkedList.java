/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.io.Serializable;
import java.util.Iterator;

/**
 *
 * @author Viet Long
 */
public class MyLinkedList<T> implements Serializable, Iterable<T> {
    
    private Node head;
    private Node tail;
    public static final long serialVersionUID = 1L;

    public MyLinkedList() {
        head = null;
        tail = null;
    }

    public MyLinkedList(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = tail = null;
    }

    public void addFirst(T item) {
        Node p = new Node(item);
        if (isEmpty()) {
            head = tail = p;
        } else {
            p.next = head;
            head = p;
        }
    }

    public void addLast(T item) {
        Node p = new Node(item);
        if (isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
    }

    public int getSize() {
        Node p = head;
        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public void addAfterPosition(int k, T item) {
        Node p = new Node(item);
        if (k == -1) {
            addFirst(item);
        } else {
            int count = 0;
            Node p1 = head;
            while (p1 != null && count < k) {
                p1 = p1.next;
                count++;
            }
            if (p1.next == null && count == k) {
                addLast(item);
            }
            p.next = p1.next;
            p1.next = p;
        }
    }

    public void deleteNode(T item) {
        Node temp = head, prev = null;
        //check head is equal item?
        if (temp != null && temp.data.equals(item)) {
            //remove head
            head = temp.next;
            return;
        }
        //check where node must be deleted
        while (temp != null) {
            if (temp.data.equals(item)) {
                break;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        //if the node dont exist in the list  
        if (temp == null) {
            return;
        }
        prev.next = temp.next;
    }

    public void deleteBeforeNode(T item) {
        Node temp = head, prev1Node = null, prev2Node = null;
        //check head is equal item?
        if (temp != null && temp.data.equals(item)) {
            //remove head
            head = temp.next;
            return;
        }
        //check where node must be deleted
        while (temp != null) {
            if (temp.data.equals(item)) {
                break;
            } else {
                prev2Node = prev1Node;
                prev1Node = temp;
                temp = temp.next;
            }
        }
        //if the node dont exist in the list  
        if (temp == null) {
            return;
        }
        prev2Node.next = temp;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T item = (T) node.data;
                    node = node.next;
                    return item;
                }
                return null;
            }
        };
    }

    public void swap(T a, T b) {
        Node preX = null, currenX = head;
        //search where is node keep the data a.
        if (currenX != null && !currenX.data.equals(a)) {
            preX = currenX;
            currenX = currenX.next;
        }
        Node preY = null, currenY = head;
        //search where is node keep the data b.
        if (currenY != null && !currenY.data.equals(b)) {
            preY = currenY;
            currenY = currenY.next;
        }
        if (currenX == null || currenY == null) {
            return;
        }

        // If x is not head of linked list 
        if (preX != null) {
            preX.next = currenY;
        } else {
            head = currenY;
        }

        // If y is not head of linked list 
        if (preY != null) {
            preY.next = currenY;
        } else {
            head = currenX;
        }

        Node temp = currenX.next;
        currenX.next = currenY.next;
        currenY.next = temp;
    }

    public T getDataOfNextNode(T item) {
        Node p = head;
        while (p.next != null) {
            if (p.data.equals(item)) {
                return (T) p.next.data;
            }
            p = p.next;
        }
        return null;
    }
    
//    public void swap(T a, T b) {
//        Node preX = null, currenX = head;
//        while (currenX != null) {
//            if (currenX.data.equals(a)) {
//                break;
//            } else {
//                preX = currenX;
//                currenX = currenX.next;
//            }
//        }
//        Node preY = null, currenY = head;
//        while (currenY != null) {
//            if (currenY.data.equals(b)) {
//                break;
//            } else {
//                preY = currenY;
//                currenY = currenY.next;
//            }
//        }
//        if (currenX == null || currenY == null) {
//            return;
//        }
//        System.out.println(currenX.data);
//        System.out.println(currenY.data);
//        if (preX != null) 
//            preX.next = currenY; 
//        else
//            head = currenY; 
//  
//        if (preY != null) 
//            preY.next = currenX; 
//        else 
//            head = currenX; 
//        Node temp = currenX.next;
//        currenX.next = currenY.next;
//        currenY.next = temp;
//    }

    public void sort() {
        if (getSize() > 1) {
            for (int i = 0; i < getSize(); i++) {
                Node currentNode = head;
                Node next = head.next;
                for (int j = 0; j < getSize() - 1; j++) {
                    if (currentNode.data.toString().compareTo(next.data.toString()) > 0) {
                        Node temp = currentNode;
                        currentNode = next;
                        next = temp;
                    }
                    currentNode = next;
                    next = next.next;
                }
            }
        }
    }
    
    public T get(int n) {
        if (n > getSize()) {
            return null;
        }
        Node p = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        return (T) p.data;
    }
    
}
