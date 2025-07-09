package Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class HomePage extends JPanel {
    private Image charizard;
    private Image pokemonString;

    public HomePage() {
        try {
            charizard = ImageIO.read(Objects.requireNonNull(HomePage.class.getResource("/Entities/HomeScreen/Charizard_home.png")));
            pokemonString = ImageIO.read(Objects.requireNonNull(HomePage.class.getResource("/Entities/HomeScreen/PokemonString1.png")));
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
        g.fillRect(0, 0, getWidth(), 30);

        // Striscia azzurra in mezzo
        g.setColor(new Color(64, 224, 208));
        g.fillRect(0, 80, getWidth(), getHeight() / 2);

        // Striscia rossa inferiore con copyright e autore
        g.setColor(new Color(139, 0, 0));
        g.fillRect(0, getHeight() - 30, getWidth(), 30);

        // IMMAGINE charizard a destra
        if (charizard != null) {
            g.drawImage(charizard, 600, 50, 400, 400, this);
        }

        // IMMAGINE pokemon a centro-sinistra
        if (pokemonString != null) {
            g.drawImage(pokemonString, 20, 18, 600, 300, this);
        }

        // SCRITTA "Pokemon rosso fuoco" al centro
    }
}
