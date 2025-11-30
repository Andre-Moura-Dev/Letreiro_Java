package org.letreiroDigital.ui;

import javax.swing.*;
import java.awt.*;

public class PainelLetreiro extends JPanel {

    private String texto;
    private int x;
    private Timer timer;
    private Color corTexto;
    private int velocidade;

    public PainelLetreiro(String texto) {
        this.texto = texto;
        this.x = getWidth();
        this.corTexto = Color.yellow;
        this.velocidade = 3;

        setBackground(Color.black);
        setFont(new Font("Arial", Font.BOLD, 47));

        this.x = 0;

        timer = new Timer(20, e -> {
            x -= velocidade;

            if(x < -getTextoLargura()) {
                x = getWidth();
            }
            repaint();
        });

        timer.start();
    }

    public int getTextoLargura() {
        FontMetrics fm = getFontMetrics(getFont());
        return fm.stringWidth(texto);
    }

    public void setTexto(String texto) {
        this.texto = texto;
        this.x = getWidth();
        repaint();
    }

    public String getTexto() {
        return texto;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public void setCorTexto(Color cor) {
        this.corTexto = cor;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g2d.setColor(corTexto);
        g2d.setFont(getFont());

        FontMetrics fm = g2d.getFontMetrics();
        int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

        g2d.drawString(texto, x, y);

        g2d.setColor(new Color(255, 255, 255, 30));
        g2d.drawString(texto, x + 2, y + 2);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 120);
    }
}
