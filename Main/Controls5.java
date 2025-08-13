package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controls5 extends JPanel {
    private Image pikachu = null;
    private Image freccia = null;
    public Controls5() {
        setFocusable(true); // ricevo input
        requestFocusInWindow(); // richiedo il focus quando viene mostrato

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char key = e.getKeyChar(); // ottengo il carattere premuto

                if (key == 'a' || key == 'A') { // se è premuto A o a
                    // Rimuovo il pannello home e aggiungo il prossimo
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Controls5.this);
                    frame.getContentPane().remove(Controls5.this);
                    Controls5 c3 = new Controls5(); // creo il prossimo pannello dei controlli
                    frame.getContentPane().add(c3); // aggiungo il nuovo pannello
                    frame.revalidate();
                    frame.repaint(); // forza il ridisegno
                } else if (key == 'b' || key == 'B') {
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Controls5.this);
                    frame.getContentPane().remove(Controls5.this);
                    Controls4 c2 = new Controls4(); // creo il pannello dei controlli
                    frame.getContentPane().add(c2); // aggiungo il nuovo pannello
                    frame.revalidate();
                    frame.repaint(); // forza il ridisegno
                }
            }
        });

        try {
            pikachu = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Entities/Tutorial/Pikachu.png"));
            freccia = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Entities/Tutorial/Arrow.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
