package me.arthurlins.restaurant.view;

import me.arthurlins.restaurant.services.TableService;

import javax.swing.*;

public class TableView extends JFrame {

    private TableService tableServiceService;
    private JPanel mainPanel;
    private JButton criarButton;
    private JButton button2;
    private JScrollPane scrollPane1;
    private JPanel tablesPanel;
    private JList list1;

    public TableView(TableService tableServiceService) {
        super("Mesas");
        setContentPane(mainPanel);
        setSize(500, 500);
        this.tableServiceService = tableServiceService;
        tablesPanel.add(new JTable());
    }


    public void setTablesSizeLabel(JLabel label) {
        label.setText("" + this.tableServiceService.getAllEmptyTables().size());
    }

}
