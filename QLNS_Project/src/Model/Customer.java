/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Customer {

    private Connection con;

    public Customer() {
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

    public Customer(int maKH, String hoKH, String tenKH, String sDT, String email, String diaChi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ResultSet getAllCustomers() throws SQLException {
        String sql = "SELECT * FROM Customer";
        PreparedStatement se = con.prepareStatement(sql);
        return se.executeQuery();
    }

    public boolean isCustomerExists(int customerID) {
        try {
            String query = "SELECT * FROM Customer WHERE CustomerID = ?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, customerID);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next(); // Trả về true nếu mã khách hàng đã tồn tại, ngược lại trả về false
        } catch (SQLException ex) {
            System.out.println("Lỗi khi kiểm tra mã khách hàng tồn tại: " + ex.getMessage());
            return false;
        }
    }

    public boolean addCustomer(int maKH, String hoKH, String tenKH, String sDT, String email, String diaChi, String gender) {
        try {
            String sql = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, maKH);
            statement.setString(2, hoKH);
            statement.setString(3, tenKH);
            statement.setString(4, sDT);
            statement.setString(5, email);
            statement.setString(6, diaChi);
            statement.setString(7, gender);

            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Loi khi them khach hang moi " + e.getMessage());
            return false;
        }
    }

    public boolean canUpdateCustomer(int oldCustomerID, int newCustomerID) {
        return oldCustomerID == newCustomerID;
    }

    public boolean updateCustomer(int customerID, String firstName, String lastName, String phoneNumber, String email, String address, String gender) {
        try {
            String sql = "UPDATE Customer SET FirstName=?, LastName=?, PhoneNumber=?, Email=?, Address=?, Gender=? WHERE CustomerID=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, phoneNumber);
            statement.setString(4, email);
            statement.setString(5, address);
            statement.setString(6, gender);
            statement.setInt(7, customerID);

            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi sửa thông tin khách hàng: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteCustomer(int customerID) {
        try {
            String sql = "DELETE FROM Customer WHERE CustomerID=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, customerID);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xóa khách hàng: " + e.getMessage());
            return false;
        }
    }

    public ResultSet sortCustomersByCustomerID() throws SQLException {
        String sql = "SELECT * FROM Customer ORDER BY CustomerID";
        PreparedStatement statement = con.prepareStatement(sql);
        return statement.executeQuery();
    }

    public Object getCustomerID() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getFirstName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getLastName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getPhoneNumber() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getAddress() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
