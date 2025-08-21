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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

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

        g.drawImage(oak, (getWidth() / 2 - 421 / 2), 0, 421, 456, this);

        // Scritta
        g.setColor(new Color(231, 247, 239));
        g.fillRect(50, getHeight() - 150, getWidth() - 100, 120);
        g.setColor(Color.gray);

        g.setFont(new Font("Courier New", Font.BOLD, 41));

        g.drawString("Welcome to the world of POKéMON!", 60, getHeight() - 105);

        // Freccia
        g.drawImage(freccia, 850, 432, null); // disegno l'icona

    }

}
