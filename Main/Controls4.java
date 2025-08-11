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




    }
}
