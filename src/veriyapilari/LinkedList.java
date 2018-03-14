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
            if (head.data1.equals(rData1) && head.data2.equals(rData2)) {
                head = head.next;
                size--;
            } else {
                Node<T> temp = head;
                for (int i = 0; i < size; i++) {
                    if (temp.next != null) {
                        if (temp.next.data1.equals(rData1) && temp.next.data2.equals(rData2)) {
                            temp.next = temp.next.next;
                            size--;
                            break;
                        }
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

    public String stringTo() {
        Node<T> temp = head;
        String list = "";

        for (int i = 0; i < size; i++) {
            if (temp != null) {
                int a = (Integer) temp.data1;
                if (a > 0 && !temp.data2.equals(1)) {
                    list = list + "+" + temp.data1 + "x^" + temp.data2;
                } else if (a < 0 && !temp.data2.equals(1)) {
                    list = list + temp.data1 + "x^" + temp.data2;
                } else if (temp.data2.equals(0) && (Integer) temp.data2 > 0) {
                    list = list + "+" + temp.data2;
                } else if (temp.data2.equals(0) && (Integer) temp.data2 < 0) {
                    list = list + temp.data2;
                }
                temp = temp.next;
            }
        }
        if (list.charAt(0) == '+') {
            StringBuilder sb;
            sb = new StringBuilder(list);
            sb.deleteCharAt(0);
            list = sb.toString();
        }
        return list;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public LinkedList additionList(LinkedList equation2) {
        LinkedList equation1 = this;
        Node temp1 = equation1.head;
        Node temp2 = equation2.head;
        LinkedList newEquation = new LinkedList();
        for (int i = 0; i < equation1.size; i++) {

            for (int j = 0; j < equation2.size; j++) {

                if (temp1.data2 == temp2.data2 && equation1.size > 1) {
                    newEquation.addLast((int) temp1.data1 + (int) temp2.data1, temp2.data2);
                    equation1.remove(temp1.data1, temp1.data2);
                    equation2.remove(temp2.data1, temp2.data2);
                    i = i - 1;
                } else if (temp1.data2.equals(0) && temp2.data2.equals(0)) {
                    newEquation.addLast((int) temp1.data1 + (int) temp2.data1, 0);
                    equation1.remove(temp1.data1, temp1.data2);
                    equation2.remove(temp2.data1, temp2.data2);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
            temp2 = equation2.head;
        }
        temp1 = equation2.head;
        for (int i = 0; i < equation2.size; i++) {
            newEquation.addLast(temp1.data1, temp1.data2);
            temp1 = temp1.next;
        }
        temp1 = equation1.head;
        for (int i = 0; i < equation1.size; i++) {
            newEquation.addLast(temp1.data1, temp1.data2);
            temp1 = temp1.next;
        }
        return newEquation;
    }

    public void simplification() {
        LinkedList newEquation = this;
        Node temp1 = this.head;
        Node temp2;
        int sayac = 0;
        for (int i = 0; i < this.size; i++) {
            temp2 = this.head;
            for (int j = 0; j < this.size; j++) {
                if (temp2.next != null) {
                    if (temp1 != temp2 && temp1.data2.equals(temp2.data2) && temp2.next != null && !temp1.data2.equals(0) && !temp2.data2.equals(0)) {
                        newEquation.addLast((int) temp1.data1 + (int) temp2.data1, temp2.data2);
                        newEquation.remove(temp1.data1, temp1.data2);
                        newEquation.remove(temp2.data1, temp2.data2);
                        i = i - 1;
                        break;
                    } else if (temp1 != temp2 && temp1.data2.equals(0) && temp2.data2.equals(0) && temp2.next != null) {
                        newEquation.addLast((int) temp1.data1 + (int) temp2.data1, 0);
                        newEquation.remove(temp1.data1, temp1.data2);
                        newEquation.remove(temp2.data1, temp2.data2);
                        i = i - 1;
                        break;
                    }
                    System.out.println(sayac++);
                    newEquation.print();
                    temp2 = temp2.next;
                } else {
                    temp2 = this.head;
                }
            }
            temp1 = temp1.next;
        }
    }

    public LinkedList additionList2(LinkedList equation2) {
        LinkedList equation1 = this;
        Node temp1 = equation1.head;
        Node temp2 = equation2.head;
        LinkedList newEquation = new LinkedList();
        for (int i = 0; i < equation1.size; i++) {
            newEquation.addLast(temp1.data1, temp1.data2);

            temp1 = temp1.next;

        }
        for (int j = 0; j < equation2.size; j++) {
            newEquation.addLast(temp2.data1, temp2.data2);
            temp2 = temp2.next;
        }
        return newEquation;
    }
}
