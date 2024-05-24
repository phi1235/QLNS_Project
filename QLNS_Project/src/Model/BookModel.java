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

public class BookModel extends javax.swing.JFrame {

    private Connection con;

    public BookModel() {
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
        String sql = "SELECT * FROM books";
        PreparedStatement se = con.prepareStatement(sql);
        return se.executeQuery();
    }

    public boolean isBookExists(String maSach) {
        try {
            String query = "SELECT * FROM books WHERE book_id = ?";
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
    public boolean addBook(String maSach, String tenSach, String maNhaXuatBan, String nhaXuatBan, String tacGia, String gia) {
        try {
            String sql = "INSERT INTO books VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, maSach);
            statement.setString(2, tenSach);
            statement.setString(3, maNhaXuatBan);
            statement.setString(4, nhaXuatBan);
            statement.setString(5, tacGia);
            statement.setString(6, gia);

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
    public boolean updateBook(String maSach, String tenSach, String maNhaXuatBan, String nhaXuatBan, String tacGia, String gia) {
        try {
            String sql = "UPDATE books SET title=?, publisher_id=?, publisher=?, author=?, price=? WHERE book_id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, tenSach);
            statement.setString(2, maNhaXuatBan);
            statement.setString(3, nhaXuatBan);
            statement.setString(4, tacGia);
            statement.setString(5, gia);
            statement.setString(6, maSach);

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
            String sql = "DELETE FROM books WHERE book_id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, maSach);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa sách: " + e.getMessage());
            return false;
        }
    }
}
