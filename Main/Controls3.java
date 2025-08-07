package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controls3 extends JPanel {
    public Controls3() {
        setFocusable(true); // ricevo input
        requestFocusInWindow(); // richiedo il focus quando viene mostrato

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char key = e.getKeyChar(); // ottengo il carattere premuto

                if (key == 'a' || key == 'A') { // se è premuto A o a
                    // Rimuovo il pannello home e aggiungo il prossimo
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Controls3.this);
                    frame.getContentPane().remove(Controls3.this);
                    Controls2 c3 = new Controls2(); // creo il prossimo pannello dei controlli
                    frame.getContentPane().add(c3); // aggiungo il nuovo pannello
                    frame.revalidate();
                    frame.repaint(); // forza il ridisegno
                } else if (key == 'l' || key == 'L' || key == 'r' || key == 'R') { // se è premuto l o r
                    // Rimuovo il pannello home e aggiungo il precedente
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Controls3.this);
                    frame.getContentPane().remove(Controls3.this);
                    Controls2 c2 = new Controls2(); // creo il pannello dei controlli
                    frame.getContentPane().add(c2); // aggiungo il nuovo pannello
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

    }

}
