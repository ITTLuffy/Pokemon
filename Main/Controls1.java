package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Controls1 extends JPanel {

    private Image icon = null;
    public Controls1() {
        setFocusable(true); // ricevo input
        requestFocusInWindow(); // richiedo il focus quando viene mostrato

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char key = e.getKeyChar(); // ottengo il carattere premuto

                if (key == 'a' || key == 'A') { // se è premuto A o a
                    // Rimuovo il pannello home e aggiungo il prossimo
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Controls1.this);
                    frame.getContentPane().remove(Controls1.this);
                    Controls2 c3 = new Controls2(); // creo il prossimo pannello dei controlli
                    frame.getContentPane().add(c3); // aggiungo il nuovo pannello
                    frame.revalidate();
                    frame.repaint(); // forza il ridisegno
                } else if (key == 'l' || key == 'L' || key == 'r' || key == 'R') { // se è premuto l o r
                    // Rimuovo il pannello home e aggiungo il precedente
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Controls1.this);
                    frame.getContentPane().remove(Controls1.this);
                    Help1 help = new Help1(); // creo il pannello dei controlli
                    frame.getContentPane().add(help); // aggiungo il nuovo pannello
                    frame.revalidate();
                    frame.repaint(); // forza il ridisegno
                }
            }
        });

        try { // carico l'icona
            icon = ImageIO.read(Objects.requireNonNull(Drawer.class.getResource("/Entities/Tutorial/Arrow.png")));
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
        g.drawString("NEXT", 860, 48);
        g.setColor(Color.white);
        g.drawString("NEXT", 858, 45);

        // A
        g.setFont(new Font("Courier New", Font.BOLD, 30));
        g.setColor(Color.white);
        g.fillOval(800, 11, 40, 40);
        g.setColor(Color.gray);
        g.drawString("A", 812, 40);

        // Spiegazione al centro --> GESTIRE IL WRAP
        g.setFont(new Font("Courier New", Font.BOLD, 41));
        g.setColor(Color.gray);
        g.drawString("The various buttons will be explained ", 12, 270);
        g.drawString("in the order of their importance.", 12, 320);

        g.setColor(Color.white);
        g.drawString("The various buttons will be explained ", 10, 268);
        g.drawString("in the order of their importance.", 10, 318);

        g.drawImage(icon, 870, 500, null); // disegno l'icona

    }
}
