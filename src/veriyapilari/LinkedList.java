/**
 * @file hesaplama.java
 * @description polinom toplamasi gerceklestiren kullanici arayuzu
 * @assignment birinci odev
 * @date 17.03.2018
 * @author Enes Behlul Yenidunya - ebehlul.yenidunya@stu.fsm.edu.tr
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
        if (!isEmpty()) {
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

    void clear() {
        head = null;
        size = 0;
    }

    void print() {
        Node<T> temp = head;

        for (int i = 0; i < size; i++) {
            System.out.print(temp.data1 + ", " + temp.data2 + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public String string() {
        Node<T> temp = head;
        if (head != null) {
            String liste = "";
            for (int i = 0; i < size; i++) {
                liste = liste + temp.data1 + ", " + temp.data2 + "->";
                temp = temp.next;
            }
            liste = liste + "null";
            return liste;
        }
        return "null linked list";
    }

    @Override
    public String toString() {
        Node<T> temp = head;
        if (head != null) {
            String list = " ";
            for (int i = 0; i < size; i++) {
                if (temp != null) {
                    int a = (Integer) temp.data1;
                    if (a > 0 && !temp.data2.equals(1) && !temp.data2.equals(0)) {
                        list = list + "+" + temp.data1 + "x^" + temp.data2;
                    } else if (a < 0 && !temp.data2.equals(0)) {
                        list = list + temp.data1 + "x^" + temp.data2;
                    } else if (a < 0 && temp.data2.equals(0)) {
                        list = list + temp.data1;
                    } else if (a > 0 && temp.data2.equals(0)) {
                        list = list + "+" + temp.data1;
                    }
                    temp = temp.next;
                }
            }
            if (list.length() > 1) {
                if (list.charAt(1) == '+') {
                    StringBuilder sb;
                    sb = new StringBuilder(list);
                    sb.deleteCharAt(0);
                    sb.deleteCharAt(0);
                    list = sb.toString();
                }
            }
            return list;
        }
        return "bos liste";
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void simplification() {
        LinkedList newEquation = this;
        Node temp1 = this.head;
        Node temp2;
        for (int i = 0; i < this.size; i++) {
            temp2 = this.head;
            for (int j = 0; j < this.size; j++) {
                if (temp2.next != null) {
                    if (temp1 != temp2 && temp1.data2.equals(temp2.data2)) {
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
                    temp2 = temp2.next;
                } else {
                    temp2 = this.head;
                }
            }
            temp1 = temp1.next;
        }
    }

    public LinkedList addLinkedList(LinkedList equation2) {
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

    public LinkedList subLinkedList(LinkedList equation2) {
        LinkedList equation1 = this;
        Node temp1 = equation1.head;
        Node temp2 = equation2.head;
        LinkedList newEquation = new LinkedList();
        for (int i = 0; i < equation1.size; i++) {
            newEquation.addLast(temp1.data1, temp1.data2);
            temp1 = temp1.next;
        }
        for (int j = 0; j < equation2.size; j++) {
            newEquation.addLast(-1 * (int) temp2.data1, temp2.data2);
            temp2 = temp2.next;
        }
        return newEquation;
    }
}
