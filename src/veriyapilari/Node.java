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
public class Node<T> {

    Node<T> next;
    T data1, data2;

    Node(T data1, T data2) {
        this.data1 = data1;
        this.data2 = data2;
        next = null;
    }
}
