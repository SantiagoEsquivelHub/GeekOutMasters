package GeekOutMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGridBagLayout extends JFrame {
    public static final String MENSAJE_INICIO =
            "Hola jugador, bienvenido a Geek Out Masters...";

    private Header headerProject;
    private JPanel panelSaludo, panelDadosUtilizados, panelDadosInactivos, panelDadosActivos, panelResultados;
    private JTextArea mensajeInicio, resultados;
    private JButton poderesDados, reglasJuego, lanzar;
    private Escucha escucha;
    private ModelGeek modelGeek;


    public GUIGridBagLayout(){
        initGUI();
        //Default JFrame configuration
        this.setUndecorated(false);
        this.setTitle("Geek Out Masters");
        this.setSize(600,600);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        //Set up JFrame Container's Layout
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        //Create Listener Object and Control Object
        //Set up JComponents
        escucha = new Escucha();
        modelGeek = new ModelGeek();
        headerProject = new Header("Geek Out Masters", Color.BLACK);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints);

       /* mensajeInicio= new JTextArea();
        mensajeInicio.setText(MENSAJE_INICIO);
        mensajeInicio.setEditable(false);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(mensajeInicio);
        this.add(mensajeInicio,constraints);*/

        poderesDados = new JButton("Poderes Dados");
        poderesDados.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_START;
        this.add(poderesDados,constraints);

        reglasJuego = new JButton("Reglas");
        reglasJuego.addActionListener(escucha);
        constraints.gridx=1;
        constraints.gridy=1;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.LINE_END;
        this.add(reglasJuego,constraints);


        panelDadosUtilizados = new JPanel();
        panelDadosUtilizados.setPreferredSize(new Dimension(300,250));
        panelDadosUtilizados.setBorder(BorderFactory.createTitledBorder("Dados Utilizados"));
        constraints.gridx=0;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(panelDadosUtilizados,constraints);

        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(300,250));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados Inactivos"));
        constraints.gridx=1;
        constraints.gridy=2;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(panelDadosInactivos,constraints);

        panelDadosActivos= new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(300,250));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder("Dados Activos"));
        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(panelDadosActivos,constraints);

        lanzar = new JButton("Lanzar");
        lanzar.addActionListener(escucha);
        constraints.gridx=0;
        constraints.gridy=4;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(lanzar,constraints);

        resultados = new JTextArea(4, 31);
        resultados.setText("");
        resultados.setBorder(BorderFactory.createTitledBorder("Resultados"));

        constraints.gridx=0;
        constraints.gridy=5;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(resultados,constraints);

    }

    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIGridBagLayout miProjectGUI = new GUIGridBagLayout();
        });
    }


    private class Escucha implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

}
