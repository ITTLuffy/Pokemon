package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Help3 extends JPanel{
    private Image icon;
    private int iconX = 2;
    private int iconY = 167;
    private int YMassimo = iconY;
    private int YMinimo = iconY + 150;


    public Help3() {
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
                } else if ((keyChar == 'A' || keyChar == 'a') && iconY == 167) { // The HELP System
                    // Rimuovo il pannello home e aggiungo il prossimo
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Help3.this);
                    frame.getContentPane().remove(Help3.this);
                    HELPSystem hs = new HELPSystem(); // creo il prossimo pannello dei controlli
                    frame.getContentPane().add(hs); // aggiungo il nuovo pannello
                    frame.revalidate();
                } else if ((keyChar == 'A' || keyChar == 'a') && iconY == 217) { // EXIT
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Help3.this);
                    frame.getContentPane().remove(Help3.this);
                    TheGame tg = new TheGame(); // creo il prossimo pannello dei controlli
                    frame.getContentPane().add(tg); // aggiungo il nuovo pannello
                    frame.revalidate();
                } else if ((keyChar == 'A' || keyChar == 'a') && iconY == 267) { // EXIT
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Help3.this);
                    frame.getContentPane().remove(Help3.this);
                    WirelessAdapter wa = new WirelessAdapter(); // creo il prossimo pannello dei controlli
                    frame.getContentPane().add(wa); // aggiungo il nuovo pannello
                    frame.revalidate();
                } else if (keyChar == 'B' || keyChar == 'b') { // se è premuto B o b
                    // Rimuovo il pannello home e aggiungo il precedente
                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Help3.this);
                    frame.getContentPane().remove(Help3.this);
                    Help2 help = new Help2(); // creo il pannello dei controlli
                    frame.getContentPane().add(help); // aggiungo il nuovo pannello
                    frame.revalidate();
                }

                repaint();


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

        g.setFont(new Font("Courier New", Font.BOLD, 30));
        g.setColor(Color.white);
        g.fillOval(850, 11, 40, 40);
        g.setColor(Color.gray);
        g.drawString("B", 850, 40);


        // Spiegazione al centro --> background grigio
        g.setFont(new Font("Courier New", Font.BOLD, 41));
        g.setColor(Color.gray);
        g.drawString("About this game", 12, 130);
        g.drawImage(icon, iconX, iconY, 39, 62, null);
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


