package miPresentacion;
import javax.swing.*;
import java.awt.*;

/**
 * This class is a kind of JLabel used to create a personalized Header for the project
 * @autor Deisy C. Melo - 202041790 deisy.melo@correounivalle.edu.co
 * @version v.1.0.0 date:23/11/2021
 */

public class Titulos extends JLabel
{
    /**
     * Constructor of the Header class
     * @param intro String that contains Header text
     * @param fondoDeIntro Color object to be assigned for the Header background
     */

    public Titulos(String intro, Color fondoDeIntro)
    {
        this.setText(intro);
        this.setBackground(fondoDeIntro);
        this.setForeground(Color.pink);
        this.setFont(new Font(Font.SANS_SERIF, Font.BOLD,20));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setOpaque(true);
    }
}
