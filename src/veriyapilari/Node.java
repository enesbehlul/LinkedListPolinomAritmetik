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
public class Node<T> {

    Node<T> next;
    T data1, data2;
    
    Node(T data1 , T data2){
        this.data1 = data1;
        this.data2 = data2;
        next=null;
    }
}
