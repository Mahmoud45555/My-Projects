package Views;

import Models.MenuItem;
import Models.Table;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RestaurantManagementGUI extends JFrame {
    private ArrayList<Table> tables;
    private ArrayList<MenuItem> menuItems;
    
    private JComboBox<Table> tableComboBox;
    private JComboBox<MenuItem> menuComboBox;
     
    private JLabel customerNameLabel;
    private JTextField customerCountField;
    private JTextArea orderArea;

    public RestaurantManagementGUI() {
        setTitle("Restaurant Management System");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        tables = new ArrayList<>();
        menuItems = new ArrayList<>();

        
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(4));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(7));
        tables.add(new Table(8));
        tables.add(new Table(9));
        tables.add(new Table(10));

        menuItems.add(new MenuItem("Burger Meal", 5.99));
        menuItems.add(new MenuItem("Small Chicken Pizza", 4.99));
        menuItems.add(new MenuItem("Medium Chicken Pizza", 6.99));
        menuItems.add(new MenuItem("Large Chicken Pizza", 8.99));
        menuItems.add(new MenuItem("Small Potato BOX", 0.65));
        menuItems.add(new MenuItem("Medium Potato BOX", 0.99));
        menuItems.add(new MenuItem("Large Potato BOX", 1.50));
        menuItems.add(new MenuItem("Super Shawerma Meal ", 2.99));
        menuItems.add(new MenuItem("double Shawerma Meal ", 3.99));
        menuItems.add(new MenuItem("Trouble Shawerma Meal ", 4.99));
        menuItems.add(new MenuItem("Matrix Cola", 0.50));
        menuItems.add(new MenuItem("diet Matrix Cola", 0.50));
        menuItems.add(new MenuItem("Orange Juice", 0.60));
        menuItems.add(new MenuItem("Apple Juice", 0.60));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2, 6)); // Changed columns to 6
        
        tableComboBox = new JComboBox<>(tables.toArray(new Table[0]));
        menuComboBox = new JComboBox<>(menuItems.toArray(new MenuItem[0]));
        customerNameLabel = new JLabel("Customer Name"); 
        JButton changeNameButton = new JButton("Change Name"); 
        
        customerCountField = new JTextField("Customer Count");

        JButton addButton = new JButton("Add Order");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Table selectedTable = (Table) tableComboBox.getSelectedItem();
                MenuItem selectedItem = (MenuItem) menuComboBox.getSelectedItem();
                String customerName = customerNameLabel.getText(); 
                int customerCount = Integer.parseInt(customerCountField.getText());
                if (selectedTable != null && selectedItem != null) {
                    selectedTable.addOrder(selectedItem);
                    selectedTable.addCustomer(customerName);
                    updateOrderArea(selectedTable);
                }
            }
        });
        
        changeNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newName = JOptionPane.showInputDialog("Enter new customer name:");
                if (newName != null && !newName.isEmpty()) {
                    customerNameLabel.setText(newName);
                }
            }
        });

        topPanel.add(tableComboBox);
        topPanel.add(menuComboBox);
        topPanel.add(customerNameLabel);
        topPanel.add(changeNameButton); // Added the button to the panel
        topPanel.add(customerCountField);
        topPanel.add(addButton);

        orderArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(orderArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void updateOrderArea(Table table) {
        orderArea.setText("Table Number: " + table.getTableNumber() + "\n");
        orderArea.append("Customer Name: ");
        for (String customerName : table.getCustomerNames()) {
            orderArea.append(customerName + ", ");
        }
        orderArea.append("\nCustomer Count: " + table.getCustomerNames().size() + "\n");
        orderArea.append("Total: JD" + table.getTotal() + "\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                var gui = new RestaurantManagementGUI();
                gui.setVisible(true);
            }
        });
    }
}
