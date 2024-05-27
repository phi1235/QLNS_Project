/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;


import Model.InventoryModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
/**
 *
 * @author ACER
 */
public class frm_inventory extends javax.swing.JFrame {

   private DefaultTableModel inventoryTableModel;
    private DefaultTableModel lowStockTableModel;
    private InventoryModel bookModel; // Add a reference to BookModel
    
    /**
     * Creates new form frm_inventory
     */
    public frm_inventory() {
        initComponents();
       setupTableModels();
        bookModel = new InventoryModel(); // Instantiate BookModel
        btn_capNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateInventory();
            }
        });
        loadData(); // Load initial data
    }
    private void setupTableModels() {
        // Initialize table models for inventory and low stock
        inventoryTableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã sách", "Tên sách", "Tác giả", "Số lượng tồn kho", "Chú thích"}
        );
        scrollPaneTonKho.setModel(inventoryTableModel);

        lowStockTableModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{"Mã sách", "Tên sách", "Số lượng tồn kho"}
        );
        scrollPaneTonKhoThap.setModel(lowStockTableModel);
    }

    private void updateInventory() {
        // Update inventory based on user input
        String maSach = txt_maSach.getText();
        String soLuongStr = txt_soluong.getText();
        int soLuong;
        try {
            soLuong = Integer.parseInt(soLuongStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!");
            return;
        }

        boolean isNhapHang = cb_nhapHang.getState();
        boolean isBanHang = cb_banHang.getState();

        if (isNhapHang == isBanHang) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn Nhập hàng hoặc Bán hàng!");
            return;
        }

        // Adjust quantity for sales if necessary
        if (isBanHang) {
            soLuong *= -1;
        }

        // Update inventory using BookModel method
        boolean success = bookModel.updateInventory(maSach, soLuong);

        if (success) {
            // Reload inventory data and update low stock table if update successful
            loadData();
            checkLowStock();
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi khi cập nhật hàng tồn kho!");
        }
    }

  private void loadData() {
    // Load data into inventory table
    try {
        ResultSet rs = bookModel.getAllBooks();
        inventoryTableModel.setRowCount(0); // Clear existing data
        while (rs.next()) {
            // Populate table with data from ResultSet
            String maSach = rs.getString("masach");
            String tenSach = rs.getString("tensach");
            String tacGia = rs.getString("tacgia");
            int soLuongTonKho = rs.getInt("soluongtonkho"); // Adjusted column name
            String chuThich = rs.getString("chuthich");

            // Add row to table model
            Object[] row = {maSach, tenSach, tacGia, soLuongTonKho, chuThich};
            inventoryTableModel.addRow(row);
        }
        rs.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Lỗi khi tải dữ liệu từ cơ sở dữ liệu: " + ex.getMessage());
    }
}

    private void checkLowStock() {
        // Check for low stock items and update low stock table
        lowStockTableModel.setRowCount(0); // Clear the table
        for (int i = 0; i < inventoryTableModel.getRowCount(); i++) {
            int stock = (int) inventoryTableModel.getValueAt(i, 3);
            if (stock < 5) {
                Object[] row = {
                        inventoryTableModel.getValueAt(i, 0),
                        inventoryTableModel.getValueAt(i, 1),
                        stock
                };
                lowStockTableModel.addRow(row);
            }
        }
    }

    // Other methods remain unchanged


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_tacGia = new javax.swing.JLabel();
        lbl_maSach1 = new javax.swing.JLabel();
        lbl_tenSach = new javax.swing.JLabel();
        lbl_tenSach1 = new javax.swing.JLabel();
        cb_banHang = new java.awt.Checkbox();
        lbl_soLuongTonKho1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_soLuongTonKho = new javax.swing.JLabel();
        lbl_maSach = new javax.swing.JLabel();
        txt_soluong = new javax.swing.JTextField();
        txt_soLuong = new javax.swing.JLabel();
        lbl_chuThich = new javax.swing.JLabel();
        lbl_title = new javax.swing.JLabel();
        btn_capNhat = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        scrollPaneTonKho = new javax.swing.JTable();
        cb_nhapHang = new java.awt.Checkbox();
        jScrollPane2 = new javax.swing.JScrollPane();
        scrollPaneTonKhoThap = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_maSach = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cb_banHang.setLabel("Bán hàng");

        jLabel8.setText("Mã sách");

        txt_soLuong.setText("Số lượng");

        lbl_title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbl_title.setForeground(new java.awt.Color(0, 204, 204));
        lbl_title.setText("QLNS");

        btn_capNhat.setText("Cập nhật");

        scrollPaneTonKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", "", "", ""
            }
        ));
        jScrollPane3.setViewportView(scrollPaneTonKho);

        cb_nhapHang.setLabel("Nhập hàng");

        scrollPaneTonKhoThap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "", ""
            }
        ));
        jScrollPane2.setViewportView(scrollPaneTonKhoThap);

        jLabel11.setText("Báo cáo hàng tồn kho");

        jLabel10.setText("Lý do");

        jLabel6.setText("Cập nhật hàng tồn kho");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(lbl_maSach)
                        .addGap(164, 164, 164)
                        .addComponent(lbl_tenSach1)
                        .addGap(147, 147, 147)
                        .addComponent(lbl_tacGia)
                        .addGap(132, 132, 132)
                        .addComponent(lbl_soLuongTonKho)
                        .addGap(130, 130, 130)
                        .addComponent(lbl_chuThich)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(txt_soLuong))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cb_nhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_maSach, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cb_banHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btn_capNhat)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(250, 250, 250)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(244, 244, 244)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_maSach1)
                                .addGap(81, 81, 81)
                                .addComponent(lbl_tenSach)
                                .addGap(61, 61, 61)
                                .addComponent(lbl_soLuongTonKho1)))
                        .addGap(200, 200, 200)))
                .addGap(272, 272, 272))
            .addGroup(layout.createSequentialGroup()
                .addGap(520, 520, 520)
                .addComponent(lbl_title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lbl_title)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_maSach)
                    .addComponent(lbl_tacGia)
                    .addComponent(lbl_chuThich)
                    .addComponent(lbl_soLuongTonKho)
                    .addComponent(lbl_tenSach1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(txt_maSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_soLuong)
                            .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(cb_nhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addComponent(cb_banHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btn_capNhat))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_maSach1)
                                    .addComponent(lbl_tenSach)
                                    .addComponent(lbl_soLuongTonKho1)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frm_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_inventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_inventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capNhat;
    private java.awt.Checkbox cb_banHang;
    private java.awt.Checkbox cb_nhapHang;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_chuThich;
    private javax.swing.JLabel lbl_maSach;
    private javax.swing.JLabel lbl_maSach1;
    private javax.swing.JLabel lbl_soLuongTonKho;
    private javax.swing.JLabel lbl_soLuongTonKho1;
    private javax.swing.JLabel lbl_tacGia;
    private javax.swing.JLabel lbl_tenSach;
    private javax.swing.JLabel lbl_tenSach1;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JTable scrollPaneTonKho;
    private javax.swing.JTable scrollPaneTonKhoThap;
    private javax.swing.JTextField txt_maSach;
    private javax.swing.JLabel txt_soLuong;
    private javax.swing.JTextField txt_soluong;
    // End of variables declaration//GEN-END:variables
}