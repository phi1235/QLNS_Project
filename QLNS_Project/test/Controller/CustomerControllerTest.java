/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Customer;
import model.CustomerModel;

/**
 *
 * @author User
 */
public class CustomerControllerTest {
    
     private Customer customerModelMock;
    private JTable tableMock;
    private DefaultTableModel tableModelMock;
    private CustomerControllerTest controllerTest;
    
    public CustomerControllerTest() {
    }
    
    
    @Before
    public void setUp() {
        customerModelMock = mock(Customer.class);
        tableMock = mock(JTable.class);
        tableModelMock = mock(DefaultTableModel.class);

        when(tableMock.getModel()).thenReturn(tableModelMock);
        controllerTest = new CustomerController(customerModelMock, tableMock, tableModelMock);
    }
    

    /**
     * Test of loadData method, of class CustomerController.
     */
    //@Test
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
    //@Test
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
    //@Test
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
    //@Test
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
    //@Test
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
    
}
