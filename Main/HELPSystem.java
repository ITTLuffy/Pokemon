package Main;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class HELPSystem extends JPanel {
    public HELPSystem() {
        setFocusable(true); // ricevo input
        requestFocusInWindow(); // richiedo il focus quando viene mostrato

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                super.keyPressed(e);
            }
        });

    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow(); // il focus funziona meglio qui
    }

    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);

    }
}
