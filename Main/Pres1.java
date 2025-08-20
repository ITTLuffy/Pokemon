package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Pres1 extends JPanel {
    private Image freccia = null;
    private Image oak = null;

    public Pres1() {
        setFocusable(true); // ricevo input
        requestFocusInWindow(); // richiedo il focus quando viene mostrato

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char key = e.getKeyChar(); // ottengo il carattere premuto

                if (key == 'a' || key == 'A') { // se è premuto A o a
                    // Rimuovo il pannello home e aggiungo il prossimo
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Pres1.this);
                    frame.getContentPane().remove(Pres1.this);
                    Controls5 c3 = new Controls5(); // creo il prossimo pannello dei controlli
                    frame.getContentPane().add(c3); // aggiungo il nuovo pannello
                    frame.revalidate();
                    frame.repaint(); // forza il ridisegno
                } else if (key == 'b' || key == 'B') {
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Pres1.this);
                    frame.getContentPane().remove(Pres1.this);
                    Controls6 c2 = new Controls6(); // creo il pannello dei controlli
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Freccia
        g.drawImage(freccia, 870, 500, null); // disegno l'icona

        // Pezzo bianco
        g.setColor(new Color(231, 247, 239));
        g.fillRect(0, 0, getWidth(), getHeight() / 2 - 50);

        g.setColor(new Color(206, 231, 222));
        g.fillRect(0, getHeight() / 2 - 50, getWidth(), 20);

        g.setColor(new Color(181, 214, 206));
        g.fillRect(0, getHeight() / 2 - 30, getWidth(), 20);

        g.setColor(new Color(156, 198, 189));
        g.fillRect(0, getHeight() / 2 - 10, getWidth(), 20);

        g.setColor(new Color(132, 181, 173));
        g.fillRect(0, getHeight() / 2 + 10, getWidth(), 20);

        g.setColor(new Color(107, 165, 156));
        g.fillRect(0, getHeight() / 2 + 30, getWidth(), 20);

        g.setColor(new Color(82, 148, 140));
        g.fillRect(0, getHeight() / 2 + 50, getWidth(), 20);

        g.setColor(new Color(66, 140, 132));
        g.fillRect(0, getHeight() / 2 + 70, getWidth(), getHeight() - (getHeight() / 2 + 70));






    }

}
