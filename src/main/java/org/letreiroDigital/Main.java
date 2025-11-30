package org.letreiroDigital;

import org.letreiroDigital.ui.LetreiroFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LetreiroFrame();
        });
    }
}