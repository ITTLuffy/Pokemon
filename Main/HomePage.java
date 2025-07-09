package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HomePage extends JPanel {
    private Image charizard;

    public HomePage() {
        try {
            charizard = ImageIO.read(Objects.requireNonNull(HomePage.class.getResource("/Entities/HomeScreen/Charizard_home.png")));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // background iniziale nero
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());

        // Striscia arancione superiore
        g.setColor(new Color(255, 69, 0));
        g.fillRect(0, 0, getWidth(), 20);

        // Striscia azzurra in mezzo
        g.setColor(new Color(64, 224, 208));
        g.fillRect(0, 80, getWidth(), getHeight() / 2);

        // Striscia rossa inferiore con copyright e autore
        g.setColor(new Color(139, 0, 0));
        g.fillRect(0, getHeight() - 20, getWidth(), 20);

        // IMMAGINE charizard a destra
        if (charizard != null) {
            g.drawImage(charizard, 700, 100, 250, 250, this);
        }
    }
}
