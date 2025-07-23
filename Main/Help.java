package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Help extends JPanel {
    private Image icon;
    private int iconX = 2;
    private int iconY = 107;
    private int YMassimo = iconY;
    private int YMinimo = iconY + 50;

    public Help() {
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

                if (key == KeyEvent.VK_UP && iconY > YMassimo) { // se è premuto su e non supera il massimo
                    iconY -= 50;
                } else if (key == KeyEvent.VK_DOWN && iconY < YMinimo) { // se è premuto giù e non supera il minimo
                    iconY += 50;
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
        g.fillOval(800, 11, 40, 40);
        g.setColor(Color.gray);
        g.drawString("A", 812, 40);

        g.setFont(new Font("Courier New", Font.BOLD, 30));
        g.setColor(Color.white);
        g.fillOval(850, 11, 40, 40);
        g.setColor(Color.gray);
        g.drawString("B", 850, 40);


        // Spiegazione al centro --> background grigio
        g.setFont(new Font("Courier New", Font.BOLD, 41));
        g.setColor(Color.gray);
        g.drawImage(icon, iconX, iconY, 39, 62, null);
        g.drawString("About this game", 50, 150);
        g.drawString("EXIT", 50, 200);


        g.setColor(Color.white);
        g.drawString("About this game", 48, 148);
        g.drawString("EXIT", 48, 198);


    }

}