package GeekOutMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIGridBagLayout extends JFrame {
    public static final String MENSAJE_REGLAS =
            "Dinámica del Juego:\n"+
    "De los 10 dados que trae el juego se toman 3 y se colocan en el sector de Dados Inactivos.\n"+
    "Los otros 7 dados se tiran y pasan a ser los Dados Activos. \n"+
    "Se van eligiendo los dados a utilizar según las habilidades de sus caras y se pasan al sector de Dados Utilizados.\n"+
    "Si como último dado activo queda un Dragón, se perderán todos los puntos acumulados.\n"+
    "Este juego lo jugará un único jugador y ganará si logra sumar 30 puntos en 5 rondas consecutivas de juego..";

    public static final String MENSAJE_PODERES =
            "Geek Out! Masters es un juego de dados y cada una de las 6 caras de los mismos tienen 1 dibujo que permite al jugador hacer 1 acción especial:\n"+
            "El 42 otorga puntos. Cada dado activo que salga con esta cara se pondrá en el track de puntos.\n"+
             "El Meeple permite relanzar otro dado en juego.\n"+
             "La Nave Espacial envía un dado no usado a la sección de dados inactivos.\n"+
    "El Superhéroe permite que cualquier dado no usado sea volteado y colocado en su cara opuesta.\n"+
    "El Corazón permite tomar un dado de la sección de dados inactivos y lanzarlo para que sea un nuevo dado activo.\n"+
    "El Dragón es la cara que queremos evitar, ya que si al final de la ronda es el último dado activo que queda se habrán perdido todos los puntos ganados.";

    private Header headerProject;
    private JPanel panelSaludo, panelDadosUtilizados, panelDadosInactivos, panelDadosActivos, panelResultados;
    private JTextArea mensajeInicio, resultados;
    private JButton poderesDados, reglasJuego, lanzar;
    private Escucha escucha;
    private ModelGeek modelGeek;
    private ImageIcon imageDado1, imageDado2,imageDado3,imageDado4,imageDado5,imageDado6,imageDado7, imageDado8,imageDado9,imageDado10;
    private JLabel dado1, dado2,dado3, dado4,dado5, dado6,dado7, dado8,dado9, dado10;

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

        dado1 = new JLabel();
        dado2 = new JLabel();
        dado3 = new JLabel();
        dado4 = new JLabel();
        dado5 = new JLabel();
        dado6 = new JLabel();
        dado7 = new JLabel();
        dado8 = new JLabel();
        dado9 = new JLabel();
        dado10 = new JLabel();

        imageDado1 = new ImageIcon(getClass().getResource("/resourses/1.jpeg"));
        imageDado2 = new ImageIcon(getClass().getResource("/resourses/2.jpeg"));
        imageDado3 = new ImageIcon(getClass().getResource("/resourses/3.jpeg"));
        imageDado4 = new ImageIcon(getClass().getResource("/resourses/4.jpeg"));
        imageDado5 = new ImageIcon(getClass().getResource("/resourses/5.jpeg"));
        imageDado6 = new ImageIcon(getClass().getResource("/resourses/6.jpeg"));
        imageDado7 = new ImageIcon(getClass().getResource("/resourses/2.jpeg"));
        imageDado8 = new ImageIcon(getClass().getResource("/resourses/3.jpeg"));
        imageDado9 = new ImageIcon(getClass().getResource("/resourses/4.jpeg"));
        imageDado10 = new ImageIcon(getClass().getResource("/resourses/5.jpeg"));


        dado1.setIcon(imageDado1);
        dado2.setIcon(imageDado2);
        dado3.setIcon(imageDado3);
        dado4.setIcon(imageDado4);
        dado5.setIcon(imageDado5);
        dado6.setIcon(imageDado6);
        dado7.setIcon(imageDado7);
        dado8.setIcon(imageDado8);
        dado9.setIcon(imageDado9);
        dado10.setIcon(imageDado10);


        panelDadosActivos= new JPanel();
        panelDadosActivos.setPreferredSize(new Dimension(300,250));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder("Dados Activos"));
        panelDadosActivos.add(dado1);
        panelDadosActivos.add(dado2);
        panelDadosActivos.add(dado3);
        panelDadosActivos.add(dado4);
        panelDadosActivos.add(dado5);
        panelDadosActivos.add(dado6);
        panelDadosActivos.add(dado7);
        panelDadosActivos.add(dado8);
        panelDadosActivos.add(dado9);
        panelDadosActivos.add(dado10);


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
            if(e.getSource() == lanzar){
                panelDadosInactivos.add(dado8);
                panelDadosInactivos.add(dado9);
                panelDadosInactivos.add(dado10);

                modelGeek.calcularTiro();
                int[] dados = modelGeek.getCaras();
                imageDado1 = new ImageIcon(getClass().getResource("/resourses/"+dados[0]+".jpeg"));
                dado1.setIcon(imageDado1);
                imageDado2 = new ImageIcon(getClass().getResource("/resourses/"+dados[1]+".jpeg"));
                dado2.setIcon(imageDado2);
                imageDado3 = new ImageIcon(getClass().getResource("/resourses/"+dados[2]+".jpeg"));
                dado3.setIcon(imageDado3);
                imageDado4 = new ImageIcon(getClass().getResource("/resourses/"+dados[3]+".jpeg"));
                dado4.setIcon(imageDado4);
                imageDado5 = new ImageIcon(getClass().getResource("/resourses/"+dados[4]+".jpeg"));
                dado5.setIcon(imageDado5);
                imageDado6 = new ImageIcon(getClass().getResource("/resourses/"+dados[5]+".jpeg"));
                dado6.setIcon(imageDado6);
                imageDado7 = new ImageIcon(getClass().getResource("/resourses/"+dados[6]+".jpeg"));
                dado7.setIcon(imageDado7);
                imageDado8 = new ImageIcon(getClass().getResource("/resourses/"+dados[7]+".jpeg"));
                dado8.setIcon(imageDado8);
                imageDado9 = new ImageIcon(getClass().getResource("/resourses/"+dados[8]+".jpeg"));
                dado9.setIcon(imageDado9);
                imageDado10 = new ImageIcon(getClass().getResource("/resourses/"+dados[9]+".jpeg"));
                dado10.setIcon(imageDado10);

                /*
                imageDado = new ImageIcon(getClass().getResource("/assets/"+caras[0]+".png"));
                dado1.setIcon(imageDado);
                imageDado = new ImageIcon(getClass().getResource("/assets/"+caras[1]+".png"));
                dado2.setIcon(imageDado);
                modelGeek.determinarJuego();
                resultadosDados.setText(modelGeek.getEstadoToString()[0]);
                mensajeSalida.setText(modelGeek.getEstadoToString()[1]);
                */


            }else{
                if(e.getSource() == poderesDados){
                    JOptionPane.showMessageDialog(null,MENSAJE_PODERES);
                }else {
                    JOptionPane.showMessageDialog(null,MENSAJE_REGLAS);
                }
            }
            revalidate();
            repaint();
        }
    }

}
