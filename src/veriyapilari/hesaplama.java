/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veriyapilari;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author behlul
 * @param <T>
 */
public class hesaplama<T> extends javax.swing.JFrame {

    DefaultComboBoxModel dcm;
    BufferedReader input = null;
    File file;
    LinkedList equation1;
    LinkedList equation2;
    int x;

    /**
     * Creates new form hesaplama
     */
    public hesaplama() {
        initComponents();
        equation1 = new LinkedList();
        equation2 = new LinkedList();
        dcm = new DefaultComboBoxModel();
        dcm.addElement("+");
        dcm.addElement("-");
        dcm.addElement("*");
        dcm.addElement("/");
        cmbIslemler.setModel(dcm);
        cmbIslemler.setSelectedIndex(-1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDosyaOku = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDenklemler = new javax.swing.JTextArea();
        lblDenklemler = new javax.swing.JLabel();
        btnHesapla = new javax.swing.JButton();
        cmbIslemler = new javax.swing.JComboBox<>();
        txtSonucDenklem = new javax.swing.JTextField();
        lblSonuc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnDosyaOku.setText("DOSYA OKU");
        btnDosyaOku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDosyaOkuActionPerformed(evt);
            }
        });

        txtDenklemler.setColumns(20);
        txtDenklemler.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDenklemler.setRows(5);
        jScrollPane1.setViewportView(txtDenklemler);

        lblDenklemler.setText("Denklemler:");

        btnHesapla.setText("HESAPLA");
        btnHesapla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHesaplaActionPerformed(evt);
            }
        });

        txtSonucDenklem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDenklemler)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtSonucDenklem, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbIslemler, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(btnHesapla))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(lblSonuc, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(330, Short.MAX_VALUE)
                .addComponent(btnDosyaOku)
                .addGap(328, 328, 328))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnDosyaOku, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblDenklemler)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHesapla)
                    .addComponent(cmbIslemler, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSonuc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSonucDenklem, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(53, 53, 53))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDosyaOkuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDosyaOkuActionPerformed
        JFileChooser jFileChooser = new JFileChooser();
        int result = jFileChooser.showOpenDialog(this);
        try {
            file = jFileChooser.getSelectedFile();
            if (file != null) {
                input = new BufferedReader(new FileReader(file));
                String equation;
                int count = 0;
                while ((equation = input.readLine()) != null) {
                    switch (count) {
                        case 0:
                            txtDenklemler.setText(txtDenklemler.getText() + equation + "\n");
                            String[] terms = equation.split("\\+|(?=\\-)");
                            for (String term : terms) {
                                if (term.contains("x^")) {
                                    equation1.addLast(Integer.parseInt(term.split("x\\^")[0]), Integer.parseInt(term.split("x\\^")[1]));
                                } else if (!term.contains("x")) {
                                    equation1.addLast(Integer.parseInt(term), 0);
                                } else if (term.contains("x") && !term.contains("^")) {
                                    equation1.addLast(1, Integer.parseInt(term.split("x")[0]));
                                }
                            }
                            break;
                        case 1:
                            txtDenklemler.setText(txtDenklemler.getText() + equation + "\n");
                            terms = equation.split("\\+|(?=\\-)");
                            for (String term : terms) {
                                if (term.contains("x^")) {
                                    equation2.addLast(Integer.parseInt(term.split("x\\^")[0]), Integer.parseInt(term.split("x\\^")[1]));
                                } else if (!term.contains("x")) {
                                    equation2.addLast(Integer.parseInt(term), 0);
                                } else if (term.contains("x") && !term.contains("^")) {
                                    equation2.addLast(1, Integer.parseInt(term.split("x")[0]));
                                }
                            }
                            break;
                        case 2:
                            x = Integer.parseInt(equation);
                    }
                    count++;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Dosya okunamadı. Tekrar deneyiniz.");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(hesaplama.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(hesaplama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDosyaOkuActionPerformed

    private void btnHesaplaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHesaplaActionPerformed
        // TODO add your handling code here:
    //LinkedList newEquation = equation1.additionList(equation2);
//    newEquation.print();
    LinkedList newEquation = equation1.additionList2(equation2);
    newEquation.simplification();
    Node temp = newEquation.head;
    txtSonucDenklem.setText(newEquation.stringTo());
    double sayi = 0;
    BigInteger sayi2 = new BigInteger("0");
        for (int i = 0; i < newEquation.getSize(); i++) {
            sayi = (int)temp.data1*Math.pow(x, (int)temp.data2);
            sayi2.add(new BigInteger(Double.toString(sayi) ));
            temp = temp.next;
        }
        System.out.println(sayi2);
        System.out.println(x);
    }//GEN-LAST:event_btnHesaplaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(hesaplama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hesaplama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hesaplama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hesaplama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hesaplama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDosyaOku;
    private javax.swing.JButton btnHesapla;
    private javax.swing.JComboBox<String> cmbIslemler;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDenklemler;
    private javax.swing.JLabel lblSonuc;
    private javax.swing.JTextArea txtDenklemler;
    private javax.swing.JTextField txtSonucDenklem;
    // End of variables declaration//GEN-END:variables
}
