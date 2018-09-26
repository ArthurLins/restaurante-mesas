package me.arthurlins.restaurant.view.console;

import me.arthurlins.restaurant.model.Announce;
import me.arthurlins.restaurant.services.AnnounceService;
import me.arthurlins.restaurant.view.console.util.ConsoleSection;

import javax.swing.*;
import java.awt.*;

public class AnnounceConsoleView extends ConsoleSection {

    private AnnounceService announceService;
    private JLabel code;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel antCode;
    private JFrame frame;


    public AnnounceConsoleView() {
        frame = new JFrame("Anuncios");
        announceService = new AnnounceService();
        initComponents();
        EventQueue.invokeLater(() -> frame.setVisible(true));
    }

    public void attendCode() {
        clear();
        title("Digite o codigo do cliente:");
        String code = getUserInput();
        try {
            Announce announce = announceService.getAnnounce(code);
            if (announce == null) {
                error("Não existe");
            } else {
                messageBox("Código encontrado", "Leve o cliente na mesa: "
                        + "(" + announce.getTable().getId() + "|" + announce.getTable().getName() + ")");
                announce.getTable().take(announce.getClientQueue().getPersonQtd());
                announceService.attendAnnounce(announce);
            }
        } catch (Exception e) {
            error(e.getMessage());
        }
        makeBackMenu();
    }

    public void refreshAlert(String code) {
        if (code == null) {
            System.out.println("CODE NULL");
        }
        if (antCode == null) {
            System.out.println("ANT CODE NULL");
        }
        if (this.code == null) {
            System.out.println("public code null");
        }
        this.antCode.setText(this.code.getText());
        this.code.setText(code);
    }

    @Override
    public void mainMenu() {
        getPreviousSection().mainMenu();
    }

    //By: Netbeans
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        antCode = new javax.swing.JLabel();

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(jLabel1.getFont().deriveFont((float) 40));
        jLabel1.setText("Cliente: ");

        code.setFont(code.getFont().deriveFont((float) 80));
        code.setForeground(new java.awt.Color(255, 0, 51));
        code.setText("00000");

        jLabel2.setFont(jLabel2.getFont().deriveFont((float) 30));
        jLabel2.setText("Anterior: ");

        antCode.setFont(antCode.getFont().deriveFont((float) 40));
        antCode.setText("00000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(code))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(antCode)))
                                .addContainerGap(301, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(code)
                                        .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(antCode))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        frame.pack();
    }


}
