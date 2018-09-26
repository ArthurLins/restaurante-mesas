package me.arthurlins.restaurant.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainViewAlt extends JFrame {


    private JButton queueButton;
    private JButton tableButton;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel queueSizeLabel;
    private JLabel tableAdaptableQtyLabel;

    public MainViewAlt() {
        initComponents();
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(() -> new MainViewAlt().setVisible(true));
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tableAdaptableQtyLabel = new javax.swing.JLabel();
        queueSizeLabel = new javax.swing.JLabel();
        queueButton = new javax.swing.JButton();
        tableButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main");
        setResizable(false);

        jLabel1.setFont(jLabel1.getFont().deriveFont((float) 26));
        jLabel1.setText("Mesas livres:");

        jLabel2.setFont(jLabel2.getFont().deriveFont((float) 26));
        jLabel2.setText("Pessoas na fila:");

        tableAdaptableQtyLabel.setFont(tableAdaptableQtyLabel.getFont().deriveFont((float) 26));
        tableAdaptableQtyLabel.setText("0");

        queueSizeLabel.setFont(queueSizeLabel.getFont().deriveFont((float) 26));
        queueSizeLabel.setText("0");

        queueButton.setFont(queueButton.getFont().deriveFont((float) 26));
        queueButton.setText("Fila");
        queueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queueButtonActionPerformed(evt);
            }
        });

        tableButton.setFont(tableButton.getFont().deriveFont((float) 26));
        tableButton.setText("Mesas");
        tableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tableAdaptableQtyLabel))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(queueSizeLabel)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tableButton, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                                        .addComponent(queueButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(tableAdaptableQtyLabel)
                                        .addComponent(tableButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel2)
                                                .addComponent(queueSizeLabel))
                                        .addComponent(queueButton))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void tableButtonActionPerformed(ActionEvent evt) {

    }

    private void queueButtonActionPerformed(ActionEvent evt) {

    }

}
