/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import java.sql.SQLException;
import Controller.BookController;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Phipari
 */
public class BookView extends javax.swing.JFrame {

    private final BookController controller;

    /**
     * Creates new form BookView
     */
    public BookView() {
        initComponents();
        DefaultTableModel dtm = (DefaultTableModel) jtb_Qlsach.getModel();
        controller = new BookController(jtb_Qlsach, dtm);
        controller.loadData(dtm);
         setLocationRelativeTo(null);
         setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
         
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtb_Qlsach = new javax.swing.JTable();
        jbtn_Them = new javax.swing.JButton();
        jbtn_Sua = new javax.swing.JButton();
        jbtn_Xoa = new javax.swing.JButton();
        jbtn_Dong = new javax.swing.JButton();
        tf_maSach = new javax.swing.JTextField();
        tf_gia = new javax.swing.JTextField();
        tf_tenSach = new javax.swing.JTextField();
        tf_maNhaxuatban = new javax.swing.JTextField();
        tf_nhaXuatBan = new javax.swing.JTextField();
        tf_tacGia = new javax.swing.JTextField();
        tf_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_showAll = new javax.swing.JButton();
        btn_luu = new javax.swing.JButton();

        jScrollPane2.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Ma sach:");

        jLabel2.setText("Ten sach:");

        jLabel3.setText("Gia:");

        jLabel4.setText("Nha xuat ban:");

        jLabel5.setText("Tac gia:");

        jLabel6.setText("Ma nha xuat ban:");

        jtb_Qlsach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Ma sach", "Ten sach", "Ma nha san xuat", "Nha san xuat", "Tac gia", "Gia"
            }
        ));
        jtb_Qlsach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtb_QlsachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtb_Qlsach);

        jbtn_Them.setText("Them");
        jbtn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_ThemActionPerformed(evt);
            }
        });

        jbtn_Sua.setText("Sua");
        jbtn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_SuaActionPerformed(evt);
            }
        });

        jbtn_Xoa.setText("Xoa");
        jbtn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_XoaActionPerformed(evt);
            }
        });

        jbtn_Dong.setText("Dong");
        jbtn_Dong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_DongActionPerformed(evt);
            }
        });

        tf_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_searchActionPerformed(evt);
            }
        });

        btn_search.setText("Search");
        btn_search.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        btn_showAll.setText("ShowAll");
        btn_showAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_showAllActionPerformed(evt);
            }
        });

        btn_luu.setText("Luu");
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_maSach, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(tf_gia, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(tf_tenSach, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jbtn_Them)
                        .addGap(34, 34, 34)
                        .addComponent(jbtn_Sua)
                        .addGap(33, 33, 33)
                        .addComponent(jbtn_Xoa)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtn_Dong))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btn_showAll))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_luu)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tf_nhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_maNhaxuatban, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tf_tacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(54, 54, 54))
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search)
                    .addComponent(btn_luu))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(tf_maSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_maNhaxuatban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)
                        .addComponent(tf_nhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tf_tenSach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(tf_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_tacGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_Them)
                    .addComponent(jbtn_Sua)
                    .addComponent(jbtn_Xoa)
                    .addComponent(jbtn_Dong)
                    .addComponent(btn_showAll))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jbtn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_SuaActionPerformed
        String oldMaSach = (String) jtb_Qlsach.getValueAt(jtb_Qlsach.getSelectedRow(), 0);
        String maSach = tf_maSach.getText();
        String tenSach = tf_tenSach.getText();
        String maNhaXuatBan = tf_maNhaxuatban.getText();
        String nhaXuatBan = tf_nhaXuatBan.getText();
        String tacGia = tf_tacGia.getText();
        String gia = tf_gia.getText();
        controller.updateBook(oldMaSach, maSach, tenSach, maNhaXuatBan, nhaXuatBan, tacGia, gia);
    }//GEN-LAST:event_jbtn_SuaActionPerformed

    private void jbtn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_XoaActionPerformed
        // TODO add your handling code here:
        controller.deleteBook(tf_maSach.getText());

    }//GEN-LAST:event_jbtn_XoaActionPerformed

    private void jbtn_DongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_DongActionPerformed

        controller.dongChuongTrinh(this);

    }//GEN-LAST:event_jbtn_DongActionPerformed

    private void jbtn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_ThemActionPerformed
        // TODO add your handling code here:
        controller.addBook(tf_maSach.getText(), tf_tenSach.getText(), tf_maNhaxuatban.getText(), tf_nhaXuatBan.getText(), tf_tacGia.getText(), tf_gia.getText());

    }//GEN-LAST:event_jbtn_ThemActionPerformed

    private void jtb_QlsachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtb_QlsachMouseClicked
        int selectedRow = jtb_Qlsach.getSelectedRow();
        if (selectedRow != -1) {
            controller.displaySelectedBook((DefaultTableModel) jtb_Qlsach.getModel(), selectedRow, tf_maSach, tf_tenSach, tf_maNhaxuatban, tf_nhaXuatBan, tf_tacGia, tf_gia);
        } else {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn một sách để sửa.");
        }

    }//GEN-LAST:event_jtb_QlsachMouseClicked

    private void tf_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_searchActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tf_searchActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
         String keyword = tf_search.getText();
        DefaultTableModel dtm = (DefaultTableModel) jtb_Qlsach.getModel();
        controller.searchBooks(keyword, dtm);
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_showAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_showAllActionPerformed
        // TODO add your handling code here:
           DefaultTableModel dtm = (DefaultTableModel) jtb_Qlsach.getModel();
        controller.loadData(dtm);
    }//GEN-LAST:event_btn_showAllActionPerformed

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        // TODO add your handling code here:
         controller.saveBookListToFile();
    }//GEN-LAST:event_btn_luuActionPerformed

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
            java.util.logging.Logger.getLogger(BookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                BookView bookView = new BookView(); // Khởi tạo một thể hiện của BookView (phần view)
//                bookView.setVisible(true); // Hiển thị cửa sổ giao diện người dùng
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_showAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton jbtn_Dong;
    private javax.swing.JButton jbtn_Sua;
    private javax.swing.JButton jbtn_Them;
    private javax.swing.JButton jbtn_Xoa;
    private javax.swing.JTable jtb_Qlsach;
    private javax.swing.JTextField tf_gia;
    private javax.swing.JTextField tf_maNhaxuatban;
    private javax.swing.JTextField tf_maSach;
    private javax.swing.JTextField tf_nhaXuatBan;
    private javax.swing.JTextField tf_search;
    private javax.swing.JTextField tf_tacGia;
    private javax.swing.JTextField tf_tenSach;
    // End of variables declaration//GEN-END:variables

    private void clearFields() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
