/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller;

import View.CustomerView;
import controller.CustomerController;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Customer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/*
 *
 * @author User
 */
public class CustomerControllerTest {
     private CustomerController controller;
    private Customer model;
    private CustomerView view;
    
    public CustomerControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
 public void setUp() {
    model = mock(Customer.class); // Sửa lại thành mock(Customer.class)
    view = mock(CustomerView.class); // Đảm bảo đang sử dụng lớp CustomerView
    controller = new CustomerController(view, model);
}
    
    @After
    public void tearDown() {
    }

    /**
     * Test of loadData method, of class CustomerController.
     */
    @Test
    public void testLoadData() {
        System.out.println("loadData");
        DefaultTableModel dt = null;
        CustomerController instance = null;
        instance.loadData(dt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCustomer method, of class CustomerController.
     */
    @Test
    public void testAddCustomer() {
        System.out.println("addCustomer");
        int maKH = 0;
        String hoKH = "";
        String tenKH = "";
        String sDT = "";
        String email = "";
        String diaChi = "";
        CustomerController instance = null;
        instance.addCustomer(maKH, hoKH, tenKH, sDT, email, diaChi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCustomer method, of class CustomerController.
     */
    @Test
    public void testDeleteCustomer() {
        System.out.println("deleteCustomer");
        int maKH = 0;
        CustomerController instance = null;
        instance.deleteCustomer(maKH);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCustomer method, of class CustomerController.
     */
    @Test
    public void testUpdateCustomer() {
        System.out.println("updateCustomer");
        int maKHCu = 0;
        int maKHMoi = 0;
        String hoKH = "";
        String tenKH = "";
        String sDT = "";
        String email = "";
        String diaChi = "";
        CustomerController instance = null;
        instance.updateCustomer(maKHCu, maKHMoi, hoKH, tenKH, sDT, email, diaChi);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Thoat method, of class CustomerController.
     */
    @Test
    public void testThoat() {
        System.out.println("Thoat");
        CustomerController instance = null;
        instance.Thoat();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displaySelectedBook method, of class CustomerController.
     */
    @Test
    public void testDisplaySelectedBook() {
        System.out.println("displaySelectedBook");
        DefaultTableModel dt = null;
        int rowIndex = 0;
        JTextField tf_maKhachHang = null;
        JTextField tf_hoKhachHang = null;
        JTextField tf_tenKhachHang = null;
        JTextField tf_sdtKhachHang = null;
        JTextField tf_emailKhachHang = null;
        JTextField tf_diaChiKhachHang = null;
        CustomerController instance = null;
        instance.displaySelectedBook(dt, rowIndex, tf_maKhachHang, tf_hoKhachHang, tf_tenKhachHang, tf_sdtKhachHang, tf_emailKhachHang, tf_diaChiKhachHang);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    private Customer mock(Class<Customer> aClass) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
