package Main;

import javax.swing.*;
import java.awt.*;

public class Controls2 extends JPanel {
    public Controls2() {
        setFocusable(true); // ricevo input
        requestFocusInWindow(); // richiedo il focus quando viene mostrato

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                super.keyPressed(e);
                char key = e.getKeyChar(); // ottengo il carattere premuto

                if (key == 'a' || key == 'A') {
                } else if (key == 'b' || key == 'B') { // se è premuto B o b
                    // Rimuovo il pannello home e aggiungo il precedente
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Controls2.this);
                    frame.getContentPane().remove(Controls2.this);
                    Controls1 c1 = new Controls1(); // creo il pannello dei controlli
                    frame.getContentPane().add(c1); // aggiungo il nuovo pannello
                    frame.revalidate();
                    frame.repaint(); // forza il ridisegno
                }
            }
        });

    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow(); // il focus funziona meglio qui
    }

    @Override
    public void paintComponent(Graphics g) {
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
        g.drawString("CONTROLS", 12, 48);
        g.setColor(Color.white);
        g.drawString("CONTROLS", 10, 45);

        // Scritta next con simbolino della A
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.setColor(Color.gray);
        g.drawString("NEXT", 660, 48);
        g.setColor(Color.white);
        g.drawString("NEXT", 658, 45);

        // A
        g.setFont(new Font("Courier New", Font.BOLD, 30));
        g.setColor(Color.white);
        g.fillOval(600, 11, 40, 40);
        g.setColor(Color.gray);
        g.drawString("A", 612, 40);

        // Scritta next con simbolino della B
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.setColor(Color.gray);
        g.drawString("BACK", 858, 48);
        g.setColor(Color.white);
        g.drawString("BACK", 856, 45);

        // B
        g.setFont(new Font("Courier New", Font.BOLD, 30));
        g.setColor(Color.white);
        g.fillOval(800, 11, 40, 40);
        g.setColor(Color.gray);
        g.drawString("B", 812, 40);


        // Spiegazione al centro
        g.setFont(new Font("Courier New", Font.BOLD, 41));
        g.setColor(Color.gray);
        g.drawString("Moves the main character.", 180, 120);
        g.drawString("Also used to choose various data", 180, 170);
        g.drawString("headings.", 180, 220);
        g.setColor(Color.white);
        g.drawString("Moves the main character.", 178, 118);
        g.drawString("Also used to choose various data", 178, 168);
        g.drawString("headings.", 178, 218);

    }
}
