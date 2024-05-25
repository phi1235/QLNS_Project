/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.BookModel;
import View.frm_Menu;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BookController {

    private final BookModel model;
    private final JTable jtb_Qlsach;
    private final DefaultTableModel dtm;

    public BookController(JTable jtb_Qlsach, DefaultTableModel dtm) {
        model = new BookModel();
        this.jtb_Qlsach = jtb_Qlsach;
        this.dtm = dtm;
    }

    // Lấy dữ liệu sách từ model và hiển thị lên bảng
    public void loadData(DefaultTableModel dt) {
        try {
            ResultSet re = model.getAllBooks();
            dt.setRowCount(0); // Xóa dữ liệu cũ trong bảng trước khi nạp dữ liệu mới
            while (re.next()) {
                String strmasp = re.getString("book_id");
                String strtensp = re.getString("title");
                String strtenhang = re.getString("publisher_id");
                String strnxb = re.getString("publisher");
                String strtacgia = re.getString("author");
                double gia = re.getDouble("price");

                // Format giá
                java.text.DecimalFormat df = new java.text.DecimalFormat("#,###");
                String strgia = df.format(gia);
                String strelement[] = {strmasp, strtensp, strtenhang, strnxb, strtacgia, strgia};
                dt.addRow(strelement);
            }
            re.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi nạp dữ liệu: " + e.getMessage());
        }
    }

    // Thêm sách mới
    public void addBook(String maSach, String tenSach, String maNhaXuatBan, String nhaXuatBan, String tacGia, String gia) {
        // Kiểm tra xem mã sách đã tồn tại chưa
        if (model.isBookExists(maSach)) {
            JOptionPane.showMessageDialog(null, "Mã sách đã tồn tại trong hệ thống. Vui lòng chọn mã sách khác.");
            return;
        }

        // Thêm sách vào cơ sở dữ liệu
        if (model.addBook(maSach, tenSach, maNhaXuatBan, nhaXuatBan, tacGia, gia)) {
            JOptionPane.showMessageDialog(null, "Thêm sách thành công.");
            // Lấy model của bảng
            DefaultTableModel dtm = (DefaultTableModel) jtb_Qlsach.getModel();
            // Tạo một mảng để chứa dữ liệu của dòng mới
            String[] rowData = {maSach, tenSach, maNhaXuatBan, nhaXuatBan, tacGia, gia};
            // Chèn dòng mới vào đầu danh sách
            dtm.insertRow(0, rowData);
        }

    }

    // Sửa thông tin sách
    public void updateBook(String oldMaSach, String newMaSach, String tenSach, String maNhaXuatBan, String nhaXuatBan, String tacGia, String gia) {
        if (!model.canUpdateBook(oldMaSach, newMaSach)) {
            JOptionPane.showMessageDialog(null, "Không được sửa mã sách.");
            DefaultTableModel dtm = (DefaultTableModel) jtb_Qlsach.getModel();
            loadData(dtm);
            return;
        }

        if (model.updateBook(newMaSach, tenSach, maNhaXuatBan, nhaXuatBan, tacGia, gia)) {
            JOptionPane.showMessageDialog(null, "Sửa thông tin sách thành công.");
            // Load lại dữ liệu sau khi sửa sách thành công
            DefaultTableModel dtm = (DefaultTableModel) jtb_Qlsach.getModel();
            loadData(dtm);
        } else {
            JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi sửa thông tin sách.");
        }
    }

    // Xóa sách
    public void deleteBook(String maSach) {
        int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa sách này?", "Xác nhận xóa sách", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (model.deleteBook(maSach)) {
                JOptionPane.showMessageDialog(null, "Xóa sách thành công.");
                // Cập nhật lại danh sách sau khi xóa
                loadData(dtm);
            } else {
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi xóa sách.");
            }
        }
    }

    public void dongChuongTrinh(JFrame currentFrame) {
        int confirmed = JOptionPane.showConfirmDialog(null,
                "Bạn có muốn đóng cửa sổ này không?", "Đóng cửa sổ",
                JOptionPane.YES_NO_OPTION);

        if (confirmed == JOptionPane.YES_OPTION) {
            currentFrame.setVisible(false); // Ẩn form hiện tại
            new frm_Menu().setVisible(true); // Hiển thị form Menu
        }
    }

    // Tìm kiếm sách
    public void searchBooks(String keyword, DefaultTableModel dt) {
        try {
            ResultSet re = model.searchBooks(keyword);
            dt.setRowCount(0); // Xóa dữ liệu cũ trong bảng trước khi nạp dữ liệu mới
            int rowCount = 0;
            while (re.next()) {
                String strmasp = re.getString("book_id");
                String strtensp = re.getString("title");
                String strtenhang = re.getString("publisher_id");
                String strnxb = re.getString("publisher");
                String strtacgia = re.getString("author");
                double gia = re.getDouble("price");

                // Format giá
                java.text.DecimalFormat df = new java.text.DecimalFormat("#,###");
                String strgia = df.format(gia);
                String strelement[] = {strmasp, strtensp, strtenhang, strnxb, strtacgia, strgia};
                dt.addRow(strelement);
                rowCount++;
            }
            re.close();

            if (rowCount > 0) {
                JOptionPane.showMessageDialog(null, "Tìm kiếm thành công. Tìm thấy " + rowCount + " kết quả.");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả nào.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi tìm kiếm dữ liệu: " + e.getMessage());
        }
    }

    public void displaySelectedBook(DefaultTableModel dtm, int rowIndex, JTextField tf_maSach, JTextField tf_tenSach, JTextField tf_maNhaXuatBan, JTextField tf_nhaXuatBan, JTextField tf_tacGia, JTextField tf_gia) {
        // Lấy dữ liệu từ bảng
        String maSach = dtm.getValueAt(rowIndex, 0).toString();
        String tenSach = dtm.getValueAt(rowIndex, 1).toString();
        String maNhaXuatBan = dtm.getValueAt(rowIndex, 2).toString();
        String nhaXuatBan = dtm.getValueAt(rowIndex, 3).toString();
        String tacGia = dtm.getValueAt(rowIndex, 4).toString();
        String gia = dtm.getValueAt(rowIndex, 5).toString();
        gia = gia.replaceAll(",", "");
        // Hiển thị dữ liệu lên các JTextField
        tf_maSach.setText(maSach);
        tf_tenSach.setText(tenSach);
        tf_maNhaXuatBan.setText(maNhaXuatBan);
        tf_nhaXuatBan.setText(nhaXuatBan);
        tf_tacGia.setText(tacGia);
        tf_gia.setText(gia);
    }
    // Thêm mã vào BookController class

    public void saveBookListToFile() {
        // Tạo một đối tượng JFileChooser
        JFileChooser fileChooser = new JFileChooser();

        // Thiết lập tiêu đề cho hộp thoại chọn tập tin
        fileChooser.setDialogTitle("Chọn nơi lưu danh sách sách");

        // Hiển thị hộp thoại chọn tập tin và lấy kết quả
        int userSelection = fileChooser.showSaveDialog(null);

        // Nếu người dùng chọn OK trong hộp thoại
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Lấy đường dẫn tập tin đã chọn
            File fileToSave = fileChooser.getSelectedFile();

            try {
                // Tạo một đối tượng BufferedWriter để ghi vào tập tin
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave));

                // Lấy số lượng hàng trong bảng
                int rowCount = jtb_Qlsach.getRowCount();

                // Duyệt qua từng hàng trong bảng và ghi thông tin vào tập tin
                for (int i = 0; i < rowCount; i++) {
                    StringBuilder line = new StringBuilder();
                    for (int j = 0; j < jtb_Qlsach.getColumnCount(); j++) {
                        line.append(jtb_Qlsach.getValueAt(i, j));
                        if (j < jtb_Qlsach.getColumnCount() - 1) {
                            line.append(", ");
                        }
                    }
                    writer.write(line.toString());
                    writer.newLine(); // Xuống dòng sau mỗi hàng
                }

                // Đóng BufferedWriter sau khi hoàn tất
                writer.close();

                JOptionPane.showMessageDialog(null, "Danh sách sách đã được lưu vào tập tin.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi khi lưu danh sách sách vào tập tin: " + e.getMessage());
            }
        }

    }
}
