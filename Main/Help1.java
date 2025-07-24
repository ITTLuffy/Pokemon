package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Help1 extends JPanel {
    public Help1() {
        setFocusable(true); // ricevo input
        requestFocusInWindow(); // richiedo il focus quando viene mostrato

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char key = e.getKeyChar(); // ottengo il carattere premuto

                if (key == 'a' || key == 'A') { // se è premuto A o a
                    // Rimuovo il pannello home e aggiungo il prossimo
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Help1.this);
                    frame.getContentPane().remove(Help1.this);
                    Help2 h2 = new Help2(); // creo il prossimo pannello dei controlli
                    frame.getContentPane().add(h2); // aggiungo il nuovo pannello
                    frame.revalidate();
                    frame.repaint(); // forza il ridisegno
                }
            }
        });

    }

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
        g.drawString("HELP", 12, 48);
        g.setColor(Color.white);
        g.drawString("HELP", 10, 45);

        // Scritta next con simbolino della A
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.setColor(Color.gray);
        g.drawString("NEXT", 860, 48);
        g.setColor(Color.white);
        g.drawString("NEXT", 858, 45);

        // A
        g.setFont(new Font("Courier New", Font.BOLD, 30));
        g.setColor(Color.white);
        g.fillOval(800, 11, 40, 40);
        g.setColor(Color.gray);
        g.drawString("A", 812, 40);

        // Spiegazione al centro --> background grigio
        g.setFont(new Font("Courier New", Font.BOLD, 41));
        g.setColor(Color.gray);
        g.drawString("Greetings! This is HELP System.", 12, 200);
        g.drawString("Call me up whenever and wherever you", 12, 250);
        g.drawString("need by pressing L or R Button.", 12, 300);
        g.drawString("The help messages change to suit the", 12, 350);
        g.drawString("situation, so check them often, please.", 12, 400);

        g.setColor(Color.white);
        // Bianco
        g.drawString("Greetings! This is HELP System.", 10, 198);
        g.drawString("Call me up whenever and wherever you", 10, 248);
        g.drawString("need by pressing L or R Button.", 10, 298);
        g.drawString("The help messages change to suit the", 10, 348);
        g.drawString("situation, so check them often, please.", 10, 398);

    }
}
