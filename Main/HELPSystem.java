package Main;

import javax.swing.*;
import java.awt.*;
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

        // Sfondo azzurro
        g.setColor(new Color(0, 115, 181));
        g.fillRect(0, 0, getWidth(), getHeight());

        // Striscia che separa in alto
        g.setColor(new Color(0, 77, 107));
        g.fillRect(0, 60, getWidth(), 8);
        g.setColor(new Color(0, 160, 209));
        g.fillRect(0, 68, getWidth(), 3);

        // Effetto finale in basso
        g.setColor(new Color(0, 106, 122));
        g.fillRect(0, getHeight() - 13, getWidth(), 5);
        g.setColor(new Color(0, 77, 107));
        g.fillRect(0, getHeight() - 8, getWidth(), 8);

        // Scritta controls in alto a sinistra
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.setColor(Color.gray);
        g.drawString("HELP", 12, 48);
        g.setColor(Color.white);
        g.drawString("HELP", 10, 45);

        // Scritta ok con simbolino della A
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.setColor(Color.gray);
        g.drawString("CANCEL", 780, 48);
        g.setColor(Color.white);
        g.drawString("CANCEL", 778, 45);

        g.setFont(new Font("Courier New", Font.BOLD, 30));
        g.setColor(Color.white);
        g.fillOval(670, 11, 40, 40);
        g.setColor(Color.gray);
        g.drawString("A", 682, 40);

        g.setFont(new Font("Courier New", Font.BOLD, 30));
        g.setColor(Color.white);
        g.fillOval(720, 11, 40, 40);
        g.setColor(Color.gray);
        g.drawString("B", 732, 40);


    }
}
