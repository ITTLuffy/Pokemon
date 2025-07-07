package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pokemon rosso fuoco");
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        Image icon = null;
        try {
            icon = ImageIO.read(Main.class.getResource("/Entities/Icons/Poké_Ball_icon.svg.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        frame.setIconImage(icon);

    }
}
