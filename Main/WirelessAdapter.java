package Main;

import javax.swing.*;
import java.awt.*;

public class WirelessAdapter extends JPanel {
    public WirelessAdapter() {
        setFocusable(true); // ricevo input
        requestFocusInWindow(); // richiedo il focus quando viene mostrato

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                super.keyPressed(e);
                char keyChar = e.getKeyChar(); // ottengo il carattere premuto

                if (keyChar == 'A' || keyChar == 'a') { // Se è premuto A
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(WirelessAdapter.this);
                    frame.getContentPane().remove(WirelessAdapter.this); // Rimuovo il pannello dei controlli
                    Help3 h3 = new Help3(); // creo il prossimo pannello del gioco
                    frame.getContentPane().add(h3); // aggiungo il nuovo pannello
                    frame.revalidate(); // rendo visibile il nuovo pannello
                } else if (keyChar == 'B' || keyChar == 'b') { // Se è premuto B
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(WirelessAdapter.this);
                    frame.getContentPane().remove(WirelessAdapter.this); // Rimuovo il pannello dei controlli
                    Help3 h3 = new Help3(); // creo il prossimo pannello della home page
                    frame.getContentPane().add(h3); // aggiungo il nuovo pannello
                    frame.revalidate(); // rendo visibile il nuovo pannello
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

        // Spiegazione al centro --> background grigio
        g.setFont(new Font("Courier New", Font.BOLD, 41));
        g.setColor(Color.gray);
        g.drawString("Wireless Adapter", 12, 180);
        g.drawString("This game communicates over a wireless", 12, 250);
        g.drawString("link using the Wireless Adapter.", 12, 300);
        g.drawString("Go wireless anywhere, anytime, and", 12, 350);
        g.drawString("with anybody!", 12, 400);
        g.drawString("Try playing with the Wireless Adapter", 12, 450);
        g.drawString("always attached!", 12, 500);

        g.setColor(Color.white);
        // Bianco
        g.drawString("Wireless Adapter", 10, 178);
        g.drawString("This game communicates over a wireless", 10, 248);
        g.drawString("link using the Wireless Adapter.", 10, 298);
        g.drawString("Go wireless anywhere, anytime, and", 10, 348);
        g.drawString("with anybody!", 10, 398);
        g.drawString("Try playing with the Wireless Adapter", 10, 448);
        g.drawString("always attached!", 10, 498);


    }

}
