/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author ACER
 */
public class InventoryModel {
    private Connection con;
    public InventoryModel() {
        try {
            String url = "jdbc:mysql://localhost:3306/book_management";
            String userName = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, userName, password);
            System.out.println("Kết nối thành công");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Kết nối thất bại");
        }
    }

    public ResultSet getAllBooks() throws SQLException {
        String sql = "SELECT * FROM kho";
        PreparedStatement se = con.prepareStatement(sql);
        return se.executeQuery();
    }

    public boolean isBookExists(String maSach) {
        try {
            String query = "SELECT * FROM kho WHERE masach = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, maSach);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Trả về true nếu mã sách đã tồn tại, ngược lại trả về false
        } catch (SQLException ex) {
            System.out.println("Lỗi khi kiểm tra mã sách tồn tại: " + ex.getMessage());
            return false;
        }
    }

    // Thêm sách mới vào cơ sở dữ liệu
    public boolean addBook(String maSach, String tenSach,String tacGia, String soLuongTonKho, String chuThich) {
        try {
            String sql = "INSERT INTO kho VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, maSach);
            statement.setString(2, tenSach);
            statement.setString(3, tacGia);
            statement.setString(4, soLuongTonKho);
            statement.setString(5, chuThich);
            

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi thêm sách: " + e.getMessage());
            return false;
        }
    }

    public boolean canUpdateBook(String oldMaSach, String newMaSach) {
        return oldMaSach.equals(newMaSach);
    }

    // Cập nhật thông tin sách
    public boolean updateBook(String maSach, String tenSach,String tacGia, String soLuongTonKho, String chuThich) {
        try {
            String sql = "UPDATE kho SET masach=?, tensach=?, tacgia=?, soluongtonkho=?, chuthich=? WHERE masach=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(2, tenSach);
            statement.setString(3, tacGia);
            statement.setString(4, soLuongTonKho);
            statement.setString(5, chuThich);
            statement.setString(1, maSach);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi sửa thông tin sách: " + e.getMessage());
            return false;
        }
    }

    // Xóa sách
    public boolean deleteBook(String maSach) {
        try {
            String sql = "DELETE FROM kho WHERE masach=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, maSach);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa sách: " + e.getMessage());
            return false;
        }
    }

    // Cập nhật số lượng tồn kho
    public boolean updateInventory(String maSach, int soLuong) {
         try {
            String sql = "INSERT INTO inventory (masach, stock) VALUES (?, ?) " +
                         "ON DUPLICATE KEY UPDATE stock = stock + ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, maSach);
            statement.setInt(2, soLuong);
            statement.setInt(3, soLuong);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi cập nhật số lượng tồn kho: " + e.getMessage());
            return false;
        }
    }
}
    

