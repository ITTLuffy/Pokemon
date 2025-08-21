package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Pres2 extends JPanel {
    private Image freccia = null;
    private Image oak = null;

    public Pres2() {
        setFocusable(true); // ricevo input
        requestFocusInWindow(); // richiedo il focus quando viene mostrato

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char key = e.getKeyChar(); // ottengo il carattere premuto

                if (key == 'a' || key == 'A') { // se è premuto A o a
                    // Rimuovo il pannello home e aggiungo il prossimo
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Pres2.this);
                    frame.getContentPane().remove(Pres2.this);
                    Pres2 c3 = new Pres2(); // creo il prossimo pannello dei controlli
                    frame.getContentPane().add(c3); // aggiungo il nuovo pannello
                    frame.revalidate();
                    frame.repaint(); // forza il ridisegno
                } else if (key == 'b' || key == 'B') {
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Pres2.this);
                    frame.getContentPane().remove(Pres2.this);
                    Pres1 c2 = new Pres1(); // creo il pannello dei controlli
                    frame.getContentPane().add(c2); // aggiungo il nuovo pannello
                    frame.revalidate();
                    frame.repaint(); // forza il ridisegno
                }
            }
        });

        try {
            oak = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Entities/Tutorial/Oak.png"));
            freccia = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Entities/Tutorial/Arrow.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow(); // il focus funziona meglio qui
    }

}
