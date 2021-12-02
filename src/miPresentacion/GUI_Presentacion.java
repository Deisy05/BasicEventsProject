package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

/**
 * This class is used for show use lister and events
 * @autor Deisy C. Melo 202041790 deisy.melo@correounivalle.edu.co
 * @version 1.1.0 date 1/12/2021
 */

public class GUI_Presentacion extends JFrame {
    //attribs
    private JButton photo, hobby, expectations;
    private JPanel buttonPanel, dataPanel;
    private Titulos intro;
    private JLabel labelImage;
    private JTextArea textExpectations;
    private Escucha escucha;
    //methods

    /**
     * Constructor of GUI class
     */
    public GUI_Presentacion() {
        initGUI();
        //windows settings
        this.setTitle("Mi Presentacion");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);



    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */

    private void initGUI() {

        escucha = new Escucha();
        intro = new Titulos("¡Hola, soy Deisy!, cliquea un boton para mas info...", Color.BLACK);
        this.add(intro, BorderLayout.NORTH);

        dataPanel = new JPanel();
        dataPanel.setBorder(BorderFactory.createTitledBorder(null, "Un poco mas de mi...", TitledBorder.CENTER,
                TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", Font.PLAIN, 20), Color.BLACK));
        this.add(dataPanel, BorderLayout.CENTER);
        dataPanel.setPreferredSize(new Dimension(400,500));
        dataPanel.setBackground(Color.PINK);

        photo = new JButton("Esta soy yo");
        photo.addMouseListener(escucha);

        hobby = new JButton("Mi hobby");
        hobby.addMouseListener(escucha);

        expectations = new JButton("Mis expectations");
        expectations.addMouseListener(escucha);
        expectations.setFocusable(true);
        expectations.addKeyListener(escucha);

        buttonPanel = new JPanel();
        buttonPanel.add(photo);
        buttonPanel.add(hobby);
        buttonPanel.add(expectations);
        this.add(buttonPanel, BorderLayout.SOUTH);

        labelImage = new JLabel();
        textExpectations = new JTextArea(10, 12);

    }

    /**
     * Main process of the java program.
     *
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion miGUIPresentacion = new GUI_Presentacion();
            }
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */

    private class Escucha implements MouseListener, KeyListener {
        private ImageIcon imagen;

        @Override
        public void mouseClicked(MouseEvent e)
        {
            if (e.getSource() == photo && e.getClickCount()==1){
                dataPanel.removeAll();
                imagen = new ImageIcon(getClass().getResource("/recursos/miFoto.jpg"));
                labelImage.setIcon(imagen);
                dataPanel.add(labelImage);
            }
            else if (e.getSource() == hobby && e.getClickCount()==2){
                dataPanel.removeAll();
                imagen = new ImageIcon(getClass().getResource("/recursos/miHobby.jpeg"));
                labelImage.setIcon(imagen);
                dataPanel.add(labelImage);
            }
            revalidate();
            repaint();

        }


        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e)
        {
            if(e.getSource()==photo){
                photo.setBackground(Color.PINK);
            }
            else if (e.getSource() == hobby) {
                hobby.setBackground(Color.PINK);
            }
            else if (e.getSource() == expectations) {
                expectations.setBackground(Color.PINK);
            }
        }

        @Override
        public void mouseExited(MouseEvent e)
        {
            photo.setBackground(null);
            hobby.setBackground(null);
            expectations.setBackground(null);

        }




        @Override
        public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_M){
                    dataPanel.removeAll();
                    textExpectations.setText("No se nada de Java así que espero aprender mucho en este curso.");
                    textExpectations.setSize(400,500);
                    textExpectations.setBackground(null);
                    textExpectations.setLineWrap(true);
                    textExpectations.setFont(new java.awt.Font("texto", Font.PLAIN, 25));
                    dataPanel.add(textExpectations);
                }
            revalidate();
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}

