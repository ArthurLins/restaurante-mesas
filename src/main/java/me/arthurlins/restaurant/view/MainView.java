package me.arthurlins.restaurant.view;

import me.arthurlins.restaurant.services.ClientQueueService;
import me.arthurlins.restaurant.services.TableService;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView extends JFrame {
    private JButton mesasButton;
    private JButton filaButton;
    private JLabel mesasDisponiveis0Label;
    private JLabel pessoasNaFila10Label;
    private JPanel mainPane;

    private ClientQueueView clientQueueView;
    private TableView tableView;

    public MainView(ClientQueueView clientQueueView, TableView tableView) {
        super("Controle");
        setContentPane(mainPane);
        setSize(500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.clientQueueView = clientQueueView;
        this.tableView = tableView;


        clientQueueView.setQueueSizeLabel(pessoasNaFila10Label);
        tableView.setTablesSizeLabel(mesasDisponiveis0Label);
        bindEvents();
    }

    public static void main(String[] args) {
        JFrame main = new MainView(new ClientQueueView(new ClientQueueService()),
                new TableView(new TableService()));
        main.setVisible(true);
        main.setEnabled(true);
    }

    private void bindEvents() {
        mesasButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tableView.setVisible(true);
                tableView.setEnabled(true);
            }
        });
        filaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clientQueueView.setVisible(true);
                clientQueueView.setEnabled(true);
            }
        });
    }

}
