package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class LoR extends JPanel{
    private Image icon;
    public LoR() {
        try {
            icon = ImageIO.read(Objects.requireNonNull(Drawer.class.getResource("/Entities/Tutorial/white_arrow.png")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
        g.drawString("", 860, 48);
        g.setColor(Color.white);
        g.drawString("", 858, 45);

        // A
        g.setFont(new Font("Courier New", Font.BOLD, 30));
        g.setColor(Color.white);
        g.fillOval(800, 11, 40, 40);
        g.setColor(Color.gray);
        g.drawString("A", 812, 40);

        // Spiegazione al centro --> background grigio
        g.setFont(new Font("Courier New", Font.BOLD, 41));
        g.setColor(Color.gray);
        g.drawString("About this game", 12, 130);
        g.drawImage(icon, 2, 167, 39, 62, null);
        g.drawString("The HELP System", 50, 210);
        g.drawString("The game", 50, 260);
        g.drawString("Wireless Adapter", 50, 310);
        g.drawString("CANCEL", 50, 360);


        g.setColor(Color.white);
        // Bianco
        g.drawString("About this game", 10, 128);
        g.drawString("The HELP System", 48, 208);
        g.drawString("The game", 48, 258);
        g.drawString("Wireless Adapter", 48, 308);
        g.drawString("CANCEL", 48, 358);


    }
}


