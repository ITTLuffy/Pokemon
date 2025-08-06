package Main;

import javax.swing.*;
import java.awt.*;

public class Controls3 extends JPanel {
    public Controls3() {

    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow(); // il focus funziona meglio qui
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

}
