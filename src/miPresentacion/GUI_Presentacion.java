package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used for show use lister and events
 * @autor Deisy C. Melo 202041790 deisy.melo@correounivalle.edu.co
 * @version 1.0.0 date 23/11/2021
 */

public class GUI_Presentacion extends JFrame
{
    //attribs
    private JButton foto, hobby, expectativas;
    private JPanel panelBotones, panelDatos;
    private Titulos intro;
    private JLabel labelImage;
    private JTextArea textoExpectativas;
    private Escucha escucha;
    //methods
    /**
     * Constructor of GUI class
     */
    public GUI_Presentacion()
    {
        initGUI();
        //windows settings
        this.setTitle ("Mi Presentacion");
        this.setSize(600,540);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */

    private void initGUI()
    {
        escucha = new Escucha();
        intro = new Titulos("¡Hola, soy Deisy!, cliquea un boton para mas info...", Color.BLACK);
        this.add(intro,BorderLayout.NORTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder (null, "Un poco mas de mi...", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Times New Roman",Font.PLAIN, 20), Color.BLACK));
        this.add(panelDatos,BorderLayout.CENTER);

        foto  = new JButton("Esta soy yo");
        foto.addActionListener(escucha);
        hobby = new JButton("Mi hobby");
        hobby.addActionListener(escucha);
        expectativas = new JButton("Mis expectativas");
        expectativas.addActionListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(foto);
        panelBotones.add(hobby);
        panelBotones.add(expectativas);

        this.add(panelBotones,BorderLayout.SOUTH);

        labelImage= new JLabel();
        textoExpectativas = new JTextArea(10,12);

    }

    /**
     * Main process of the java program.
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */

    public static void main (String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */

    private class Escucha implements ActionListener
    {
        private ImageIcon imagen;

        @Override
        public void actionPerformed(ActionEvent e) {
            panelDatos.removeAll();
            if (e.getSource() == foto) {
                imagen = new ImageIcon(getClass().getResource("/recursos/miFoto.jpg"));
                labelImage.setIcon(imagen);
                panelDatos.add(labelImage);
            }
            else
            {
                if (e.getSource() == hobby)
                {
                    imagen = new ImageIcon(getClass().getResource("/recursos/miHobby.jpeg"));
                    labelImage.setIcon(imagen);
                    panelDatos.add(labelImage);
                }
                else
                {
                    textoExpectativas.setText("No se nada de Java así que espero aprender\n" +
                            "mucho en este curso.");
                    textoExpectativas.setBackground(null);
                    textoExpectativas.setFont(new java.awt.Font("texto", Font.PLAIN, 25));
                    panelDatos.add(textoExpectativas);
                }
            }
            revalidate();
            repaint();
        }
    }

}
