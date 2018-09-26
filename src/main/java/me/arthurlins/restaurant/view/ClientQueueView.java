package me.arthurlins.restaurant.view;

import me.arthurlins.restaurant.services.ClientQueueService;

import javax.swing.*;

public class ClientQueueView extends JFrame {


    private ClientQueueService clientQueueService;

    private JPanel mainPanel;


    public ClientQueueView(ClientQueueService clientQueueService) {
        super("Fila");
        setContentPane(mainPanel);
        this.clientQueueService = clientQueueService;
    }


    public void setQueueSizeLabel(JLabel label) {
        label.setText("" + this.clientQueueService.viewQueue().size());
    }

}
