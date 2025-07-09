package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Drawer {
    public static void main(String[] args) {
        // Frame
        JFrame frame = new JFrame("Pokemon rosso fuoco");
        frame.setSize(1000, 600); // size
        frame.setLocationRelativeTo(null); // center on screen
        frame.setResizable(false); // not resizable
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close on exit

        Image icon = null; // icon
        try { // load icon
            icon = ImageIO.read(Objects.requireNonNull(Drawer.class.getResource("/Entities/Icons/Poké_Ball_icon.svg.png")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        HomePage homePage = new HomePage();
        frame.getContentPane().add(homePage); // add home page to frame

        frame.setIconImage(icon); // set icon

//        DrawingCanvas c = new DrawingCanvas(); // create canvas
//        frame.getContentPane().add(c); // add canvas to frame

        frame.setVisible(true); // make frame visible

    }
}
