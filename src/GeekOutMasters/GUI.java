package GeekOutMasters;

import javax.swing.*;
import java.awt.*;

/**
 * This class is used for ...
 * @autor Paola-J Rodriguez-C paola.rodriguez@correounivalle.edu.co
 * @version v.1.0.0 date:21/11/2021
 */
public class GUI extends JFrame {

    public static final String MENSAJE_INICIO =
            "Hola jugador, bienvenido a Geek Out Masters...";

    private Header headerProject;
    private JPanel panelSaludo, panelDados, panelResultados;
    private JTextArea mensajeInicio, resultadosDados;
    private JButton poderesDados, reglasJuego, lanzar;

    /**
     * Constructor of GUI class
     */
    public GUI(){
        initGUI();

        //Default JFrame configuration
        this.setTitle("Geek Out Masters");
        this.setSize(500,500);
        //this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * This method is used to set up the default JComponent Configuration,
     * create Listener and control Objects used for the GUI class
     */
    private void initGUI() {
        //Set up JFrame Container's Layout
        //Create Listener Object and Control Object
        //Set up JComponents
        headerProject = new Header("Geek Out Masters", Color.BLACK);
        this.add(headerProject,BorderLayout.NORTH); //Change this line if you change JFrame Container's Layout

        poderesDados = new JButton("Poderes Dados");
        reglasJuego = new JButton("Reglas");


        mensajeInicio= new JTextArea();
        mensajeInicio.setText(MENSAJE_INICIO);
        mensajeInicio.setEditable(false);
        mensajeInicio.setAlignmentX(CENTER_ALIGNMENT);
        this.add(mensajeInicio);

        panelSaludo = new JPanel();
        panelSaludo.setPreferredSize(new Dimension(200,180));
        panelSaludo.add(mensajeInicio);
        panelSaludo.add(poderesDados);
        panelSaludo.add(reglasJuego);
        this.add(panelSaludo, BorderLayout.CENTER);

    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUI miProjectGUI = new GUI();
        });
    }

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha {

    }
}
