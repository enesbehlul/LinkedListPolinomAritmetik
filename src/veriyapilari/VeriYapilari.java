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
public class VeriYapilari {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<Integer> list = new LinkedList();
        list.addFirst(3, 4);
        list.addFirst(4, 5);
        list.addFirst(7, 6);
        list.print();
        
        list.remove(7, 6);
        
        list.print();
    }

}
