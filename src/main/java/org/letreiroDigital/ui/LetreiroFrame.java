package org.letreiroDigital.ui;

import javax.swing.*;
import java.awt.*;

public class LetreiroFrame extends JFrame {

    public LetreiroFrame() {
        setTitle("Da Silva - Informática e Serviços");
        setSize(900, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(Color.black);
        setLayout(new BorderLayout());

        PainelLetreiro painel = new PainelLetreiro("🔧 Da Silva Informática - " +
                "Assistência Técnica Especializada: Manutenção de computadores, celulares, televisões, impressoras e etc," +
                " 📞 Telefone: (61) 96231-7890");

        add(painel, BorderLayout.CENTER);

        JPanel panelControls = new JPanel();
        panelControls.setBackground(Color.DARK_GRAY);

        JTextField campoTexto = new JTextField(25);
        campoTexto.setText(painel.getTexto());
        campoTexto.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton aplicar = new JButton("Aplicar texto");
        aplicar.setBackground(new Color(0, 150, 0));
        aplicar.setForeground(Color.WHITE);
        aplicar.addActionListener(e -> {
            if (!campoTexto.getText().trim().isEmpty()) {
                painel.setTexto(campoTexto.getText().trim());
            }
        });

        JButton fullScreen = new JButton("Tela Cheia");
        fullScreen.setBackground(new Color(0, 100, 200));
        fullScreen.setForeground(Color.WHITE);
        fullScreen.addActionListener(e -> entrarFullscreen());

        JButton sairFullscreen = new JButton("Sair Tela Cheia");
        sairFullscreen.setBackground(new Color(200, 100, 0));
        sairFullscreen.setForeground(Color.WHITE);
        sairFullscreen.addActionListener(e -> sairFullscreen());

        campoTexto.addActionListener(e -> aplicar.doClick());

        panelControls.add(new JLabel("Texto: "));
        panelControls.add(campoTexto);
        panelControls.add(aplicar);
        panelControls.add(fullScreen);
        panelControls.add(sairFullscreen);

        add(panelControls, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void entrarFullscreen() {
        dispose();
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    private void sairFullscreen() {
        dispose();
        setUndecorated(false);
        setExtendedState(JFrame.NORMAL);
        setSize(900, 250);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
