package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controls4 extends JPanel {
    private Image pikachu = null;
    private Image freccia = null;
    public Controls4() {
        setFocusable(true); // ricevo input
        requestFocusInWindow(); // richiedo il focus quando viene mostrato

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                char key = e.getKeyChar(); // ottengo il carattere premuto

                if (key == 'a' || key == 'A') { // se è premuto A o a
                    // Rimuovo il pannello home e aggiungo il prossimo
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Controls4.this);
                    frame.getContentPane().remove(Controls4.this);
                    Controls5 c3 = new Controls5(); // creo il prossimo pannello dei controlli
                    frame.getContentPane().add(c3); // aggiungo il nuovo pannello
                    frame.revalidate();
                    frame.repaint(); // forza il ridisegno
                } else if (key == 'b' || key == 'B') {
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Controls4.this);
                    frame.getContentPane().remove(Controls4.this);
                    Controls3 c2 = new Controls3(); // creo il pannello dei controlli
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

        // Striscia scura
        g.setColor(new Color(0, 77, 107));
        g.fillRect(0, 60, getWidth(), 11);

        // Striscia blu violaceo
        g.setColor(new Color(82, 99, 181));
        g.fillRect(0, 71, getWidth(), getHeight());

        // Quadrato grigio intorno alle scritte
        g.setColor(new Color(107, 107, 107));
        g.fillRect(16, 106, getWidth() - 32, 8);
        g.fillRect(16, getHeight() - 12, getWidth() - 32, 8);
        g.fillRect(8, 114, 8, getHeight() - 126);
        g.fillRect(getWidth() - 16, 114, 8, getHeight() - 126);

        // Quadrato blu chiaro
        g.setColor(new Color(206, 239, 247));
        g.fillRect(16, 114, getWidth() - 32, getHeight() - 126);

        // Immagine
        g.drawImage(pikachu, 20, 10, 110, 128, this);

        // Freccia
        g.drawImage(freccia, 870, 500, null); // disegno l'icona

        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.setColor(Color.gray);
        g.drawString("NEXT", 858, 48);
        g.setColor(Color.white);
        g.drawString("NEXT", 856, 45);

        // A
        g.setFont(new Font("Courier New", Font.BOLD, 30));
        g.setColor(Color.white);
        g.fillOval(800, 11, 40, 40);
        g.setColor(Color.gray);
        g.drawString("A", 812, 40);

        // Spiegazione al centro
        g.setFont(new Font("Courier New", Font.BOLD, 41));
        g.setColor(Color.gray);
        g.drawString("In the world which you are about to", 60, 170);
        g.drawString("enter, you will embark on a grand", 60, 220);
        g.drawString("adventure with you as the hero.", 60, 270);


        g.drawString("Speak to people and check things", 60, 370);
        g.drawString("wherever you go, be it towns, roads,", 60, 420);
        g.drawString("or caves. Gather information and ", 60, 470);
        g.drawString("hints from every source.", 60, 520);

    }
}
