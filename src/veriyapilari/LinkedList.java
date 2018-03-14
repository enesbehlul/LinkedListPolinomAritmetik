/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veriyapilari;

/**
 *
 * @author behlul
 */
public class LinkedList<T> {

    Node<T> head;
    private int size;

    public void addFirst(T data1, T data2) {
        Node<T> newNode = new Node<>(data1, data2);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(T data1, T data2) {
        if (head == null) {
            addFirst(data1, data2);
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data1, data2);
            size++;
        }
    }

    void remove(T rData1, T rData2) {
        if (isEmpty()) {

        } else {
            if (head.data1 == rData1 && head.data2 == rData2) {
                head = head.next;
                size--;
            } else {
                Node<T> temp = head;
                for (int i = 0; i < size; i++) {
                    if (temp.next.data1 == rData1 && temp.next.data2 == rData2) {
                        temp.next = temp.next.next;
                        size--;
                        break;
                    }
                    temp = temp.next;
                }
            }
        }
    }

    void print() {
        Node<T> temp = head;

        for (int i = 0; i < size; i++) {
            System.out.print(temp.data1 + ", " + temp.data2 + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}