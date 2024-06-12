package Models;

import java.util.ArrayList;

public class Table {
    private int tableNumber;
    private ArrayList<MenuItem> orders;
    private ArrayList<String> customerNames; // إضافة قائمة لأسماء الزبائن

    public Table(int tableNumber) {
        this.tableNumber = tableNumber;
        this.orders = new ArrayList<>();
        this.customerNames = new ArrayList<>(); // تهيئة قائمة الأسماء
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public ArrayList<MenuItem> getOrders() {
        return orders;
    }

    public ArrayList<String> getCustomerNames() { // إضافة دالة للحصول على أسماء الزبائن
        return customerNames;
    }

    public void addOrder(MenuItem item) {
        orders.add(item);
    }

    public void addCustomer(String name) { // إضافة دالة لإضافة أسماء الزبائن
        customerNames.add(name);
    }

    public void clearOrders() {
        orders.clear();
    }

    public double getTotal() {
        double total = 0;
        for (MenuItem item : orders) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public String toString() {
        return " Table Number " + tableNumber;
    }

    public void addOrder(java.awt.MenuItem selectedItem) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
   