package Main;

import javax.swing.*;

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

    }

}
