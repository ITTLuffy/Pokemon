package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Help2 extends JPanel {
    private Image icon;
    private int iconY = 107;
    private final int YMassimo = iconY;
    private final int YMinimo = iconY + 50;
    private String l1 = "Detailed descriptions are given";
    private String l2 = "about this game.";

    public Help2() {
        try {
            icon = ImageIO.read(Objects.requireNonNull(Drawer.class.getResource("/Entities/Tutorial/white_arrow.png")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        setFocusable(true); // ricevo input
        requestFocusInWindow(); // richiedo il focus quando viene mostrato

        addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(java.awt.event.KeyEvent e) {
                super.keyPressed(e);
                int key = e.getKeyCode(); // ottengo il carattere premuto
                char keyChar = e.getKeyChar(); // ottengo il carattere premuto

                if (key == KeyEvent.VK_UP && iconY > YMassimo) { // se è premuto su e non supera il massimo
                    iconY -= 50;
                    System.out.println("UP pressed, iconY: " + iconY);
                } else if (key == KeyEvent.VK_DOWN && iconY < YMinimo) { // se è premuto giù e non supera il minimo
                    iconY += 50;
                    System.out.println("DOWN pressed, iconY: " + iconY);
                } else if ((keyChar == 'A' || keyChar == 'a') && iconY == 107) { // About this game
                    // Rimuovo il pannello home e aggiungo il prossimo
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Help2.this);
                    frame.getContentPane().remove(Help2.this);
                    Help3 lor = new Help3(); // creo il prossimo pannello dei controlli
                    frame.getContentPane().add(lor); // aggiungo il nuovo pannello
                    frame.revalidate();
                } else if ((keyChar == 'A' || keyChar == 'a') && iconY == 157) { // EXIT
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Help2.this);
                    frame.getContentPane().remove(Help2.this);
                    Controls1 lor = new Controls1(); // creo il prossimo pannello dei controlli
                    frame.getContentPane().add(lor); // aggiungo il nuovo pannello
                    frame.revalidate();
                } else if (keyChar == 'B' || keyChar == 'b') { // se è premuto B o b
                    // Rimuovo il pannello home e aggiungo il precedente
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Help2.this);
                    frame.getContentPane().remove(Help2.this);
                    Controls1 c1 = new Controls1(); // creo il pannello dei controlli
                    frame.getContentPane().add(c1); // aggiungo il nuovo pannello
                    frame.revalidate();
                }


                if (iconY == 107) {
                    l1 = "Detailed descriptions are given";
                    l2 = "about this game.";
                } else if (iconY == 157) {
                    l1 = "Select to exit the HELP System.";
                    l2 = "";
                }

                repaint();

            }
        });

    }

    public void addNotify() {
        super.addNotify();
        requestFocusInWindow(); // il focus funziona meglio qui
    }

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
        g.drawString("", 860, 48);
        g.setColor(Color.white);
        g.drawString("", 858, 45);

        // A
        g.setFont(new Font("Courier New", Font.BOLD, 30));
        g.setColor(Color.white);
        g.fillOval(710, 11, 40, 40);
        g.setColor(Color.gray);
        g.drawString("A", 722, 40);

        // Scritta ok con simbolino della A
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.setColor(Color.gray);
        g.drawString("OK", 760, 48);
        g.setColor(Color.white);
        g.drawString("OK", 758, 45);

        g.setFont(new Font("Courier New", Font.BOLD, 30));
        g.setColor(Color.white);
        g.fillOval(830, 11, 40, 40);
        g.setColor(Color.gray);
        g.drawString("B", 842, 40);

        // Scritta end con simbolino della B
        g.setFont(new Font("Courier New", Font.BOLD, 50));
        g.setColor(Color.gray);
        g.drawString("END", 876, 48);
        g.setColor(Color.white);
        g.drawString("END", 874, 45);

        // Spiegazione al centro --> background grigio
        g.setFont(new Font("Courier New", Font.BOLD, 41));
        g.setColor(Color.gray);
        int iconX = 2;
        g.drawImage(icon, iconX, iconY, 39, 62, null);
        g.drawString("About this game", 50, 150);
        g.drawString("EXIT", 50, 200);

        g.setColor(Color.white);
        g.drawString("About this game", 48, 148);
        g.drawString("EXIT", 48, 198);

        // Rettangolo bianco con il testo in basso
        g.setColor(Color.white);
        g.fillRect(50, getHeight() - 220, getWidth() - 100, 140);
        g.setColor(Color.black);
        g.setFont(new Font("Courier New", Font.BOLD, 41));
        g.drawString(l1, 60, getHeight() - 170);
        g.drawString(l2, 60, getHeight() - 120);

    }

}