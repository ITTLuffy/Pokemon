package Main;

import javax.swing.*;
import java.awt.*;

public class Controls4 extends JPanel {
    public Controls4() {

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
        g.setColor(new Color(71, 99, 181));
        g.fillRect(0, 60, getWidth(), 11);


    }
}
