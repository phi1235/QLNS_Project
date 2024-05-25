package controller;

import View.CustomerView;
import model.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CustomerController {
    

    private final Customer cmodel;
    private final JTable tb_KhachHang;
    private final DefaultTableModel dt;

 public CustomerController(JTable tb_KhachHang, DefaultTableModel dt) {
        cmodel = new Customer();
        this.tb_KhachHang = tb_KhachHang;
        this.dt = dt;
    }

    public void loadData(DefaultTableModel dt) {
        try {
            ResultSet rs = cmodel.getAllCustomers();
            dt.setRowCount(0); // Xóa dữ liệu cũ trong bảng trước khi nạp dữ liệu mới
            while (rs.next()) {
                int strmakh = rs.getInt("CustomerID");
                String strho = rs.getString("FirstName");
                String strten = rs.getString("LastName");
                String strsdt = rs.getString("PhoneNumber");
                String stremail = rs.getString("Email");
                String straddress = rs.getString("Address");

                Object strelement[] = {strmakh, strho, strten, strsdt, stremail, straddress};
                dt.addRow(strelement);
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi nạp dữ liệu: " + e.getMessage());
        }
    }

    public void addCustomer(int maKH, String hoKH, String tenKH, String sDT, String email, String diaChi) {
        if (cmodel.isCustomerExists(maKH)) {
            JOptionPane.showMessageDialog(null, "Ma khach hang da ton tai trong he thong, vui long nhap ma khach hang khac");
            return;
        }

        if (cmodel.addCustomer(maKH, hoKH, tenKH, sDT, email, diaChi)) {
            JOptionPane.showMessageDialog(null, "Da them khach hang thanh cong");
            DefaultTableModel dt = (DefaultTableModel) tb_KhachHang.getModel();
            Object[] strHeader = {maKH, hoKH, tenKH, sDT, email, diaChi};
            dt.insertRow(0, strHeader);
        }
    }
    //Xoa khach hang

    public void deleteCustomer(int maKH) {
        int confirm = JOptionPane.showConfirmDialog(null, "Ban co muon xoa khach hang nay?", "Xac nhan xoa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (cmodel.deleteCustomer(maKH)) {
                JOptionPane.showMessageDialog(null, "Xoa thanh cong");
                // Cập nhật lại danh sách sau khi xóa
                loadData(dt);
            } else {
                JOptionPane.showMessageDialog(null, "Loi khi xoa khach hang");
            }
        }
    }

    public void updateCustomer(int maKHCu, int maKHMoi, String hoKH, String tenKH, String sDT, String email, String diaChi) {
        if (!cmodel.canUpdateCustomer(maKHCu, maKHMoi)) {
            JOptionPane.showMessageDialog(null, "Khong the sua khach hang");
            DefaultTableModel dt = (DefaultTableModel) tb_KhachHang.getModel();
            loadData(dt);
            return;
        }

        if (cmodel.updateCustomer(maKHMoi, hoKH, tenKH, sDT, email, diaChi)) {
            JOptionPane.showMessageDialog(null, "Sua thanh cong");
            // Load lại dữ liệu sau khi sửa sách thành công
            DefaultTableModel dt = (DefaultTableModel) tb_KhachHang.getModel();
            loadData(dt);
        } else {
            JOptionPane.showMessageDialog(null, "Da xay ra loi khi sua");
        }
    }

    public void Thoat() {
        int tl = JOptionPane.showConfirmDialog(null, "Ban co muon thoat chuong trinh?", "Thong Bao", JOptionPane.YES_NO_OPTION);

        if (tl == JOptionPane.YES_OPTION) {
            //Exit
            System.exit(0);
        }
    }

    public void displaySelectedBook(DefaultTableModel dt, int rowIndex, JTextField tf_maKhachHang, JTextField tf_hoKhachHang, JTextField tf_tenKhachHang, JTextField tf_sdtKhachHang, JTextField tf_emailKhachHang, JTextField tf_diaChiKhachHang) {
        // Lấy dữ liệu từ bảng
        int maKH = Integer.parseInt(dt.getValueAt(rowIndex, 0).toString());
        String hoKH = dt.getValueAt(rowIndex, 1).toString();
        String tenKH = dt.getValueAt(rowIndex, 2).toString();
        String sdtKH = dt.getValueAt(rowIndex, 3).toString();
        String emailKH = dt.getValueAt(rowIndex, 4).toString();
        String diaChi = dt.getValueAt(rowIndex, 5).toString();
        // Hiển thị dữ liệu lên các JTextField
        tf_maKhachHang.setText(String.valueOf(maKH));
        tf_hoKhachHang.setText(hoKH);
        tf_tenKhachHang.setText(tenKH);
        tf_sdtKhachHang.setText(sdtKH);
        tf_emailKhachHang.setText(emailKH);
        tf_diaChiKhachHang.setText(diaChi);
    }
  // Phương thức để sắp xếp khách hàng theo mã khách hàng
    public void sortByCustomerID(DefaultTableModel dt) {
        try {
            ResultSet rs = cmodel.sortCustomersByCustomerID();
            dt.setRowCount(0); // Xóa dữ liệu cũ trong bảng trước khi nạp dữ liệu mới
            while (rs.next()) {
                int strmakh = rs.getInt("CustomerID");
                String strho = rs.getString("FirstName");
                String strten = rs.getString("LastName");
                String strsdt = rs.getString("PhoneNumber");
                String stremail = rs.getString("Email");
                String straddress = rs.getString("Address");

                Object strelement[] = {strmakh, strho, strten, strsdt, stremail, straddress};
                dt.addRow(strelement);
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi sắp xếp khách hàng: " + e.getMessage());
        }
    }
    

}
