package GeekOutMasters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIGridBagLayout extends JFrame {
    public static final String MENSAJE_REGLAS =
            "Dinámica del Juego:\n"+
    "De los 10 dados que trae el juego se toman 3 y se colocan en el sector de Dados Inactivos.\n"+
    "Los otros 7 dados se tiran y pasan a ser los Dados Activos. \n"+
    "Se van eligiendo los dados a utilizar según las habilidades de sus caras y se pasan al sector de Dados Utilizados.\n"+
    "Si como último dado activo queda un Dragón, se perderán todos los puntos acumulados.\n"+
    "Este juego lo jugará un único jugador y ganará si logra sumar 30 puntos en 5 rondas consecutivas de juego..\n"
                    +" 1 Dado 42 => 1 punto,\n" +
                    " 2 Dado 42 => 3 puntos,\n" +
                    " 3 Dado 42 => 6 puntos,\n" +
                    " 4 Dado 42 => 10 punto,\n" +
                    " 5 Dado 42 => 15 puntos,\n" +
                    " 6 Dado 42 => 21 punto,\n" +
                    " 7 Dado 42 => 28 puntos,\n" +
                    " 8 Dado 42 => 36 puntos,\n" +
                    " 9 Dado 42 => 45 punto,\n" +
                    " 10 Dado 42 => 55 puntos,\n";

    public static final String MENSAJE_PODERES =
            "Geek Out! Masters es un juego de dados y cada una de las 6 caras de los mismos tienen 1 dibujo que permite al jugador hacer 1 acción especial:\n"+
            "El 42 otorga puntos. Cada dado activo que salga con esta cara se pondrá en el track de puntos.\n"+
             "El Meeple permite relanzar otro dado en juego.\n"+
             "La Nave Espacial envía un dado no usado a la sección de dados inactivos.\n"+
    "El Superhéroe permite que cualquier dado no usado sea volteado y colocado en su cara opuesta.\n"+
    "El Corazón permite tomar un dado de la sección de dados inactivos y lanzarlo para que sea un nuevo dado activo.\n"+
    "El Dragón es la cara que queremos evitar, ya que si al final de la ronda es el último dado activo que queda se habrán perdido todos los puntos ganados.";

    private Header headerProject;
    public JPanel  panelDadosUtilizados, panelDadosInactivos, panelDadosActivos;
    private JTextArea resultados;
    private JButton poderesDados, reglasJuego, lanzar;
    private Escucha escucha;
    private EscuchaBotones escuchaBotones;
    private EscuchaSuperHeroe escuchaSuperHeroe;
    private EscuchaCohete escuchaCohete;
    private EscuchaMeeple escuchaMeeple;
    private EscuchaCorazon escuchaCorazon;
    private ModelGeek modelGeek;
    private ImageIcon imagenDadoElegido, imageDado1, imageDado2,imageDado3,imageDado4,imageDado5,imageDado6,imageDado7, imageDado8,imageDado9,imageDado10;
    private Dado dado1, dado2,dado3, dado4,dado5, dado6,dado7, dado8,dado9, dado10;
    private int[] resultadoDados = new int[10];
    private Component[] resultadosID;


    public GUIGridBagLayout(){
        initGUI();
        //Default JFrame configuration
        this.setUndecorated(false);
        this.setTitle("Geek Out Masters");
        this.setSize(1200,1100);
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
        escuchaBotones = new EscuchaBotones();
        escuchaSuperHeroe = new EscuchaSuperHeroe();
        escuchaCohete = new EscuchaCohete();
        escuchaMeeple = new EscuchaMeeple();
        escuchaCorazon = new EscuchaCorazon();
        modelGeek = new ModelGeek();
        headerProject = new Header("Geek Out Masters", Color.BLACK);
        constraints.gridx=0;
        constraints.gridy=0;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.HORIZONTAL;
        this.add(headerProject,constraints);

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
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(panelDadosUtilizados,constraints);

        panelDadosInactivos = new JPanel();
        panelDadosInactivos.setPreferredSize(new Dimension(300,250));
        panelDadosInactivos.setBorder(BorderFactory.createTitledBorder("Dados Inactivos"));
        constraints.gridx=1;
        constraints.gridy=3;
        constraints.gridwidth=1;
        constraints.fill=GridBagConstraints.BOTH;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(panelDadosInactivos,constraints);

        dado1 = new Dado(1);
        dado1.addMouseListener(escuchaBotones);
        dado2 = new Dado(2);
        dado2.addMouseListener(escuchaBotones);
        dado3 = new Dado(3);
        dado3.addMouseListener(escuchaBotones);
        dado4 = new Dado(4);
        dado4.addMouseListener(escuchaBotones);
        dado5 = new Dado(5);
        dado5.addMouseListener(escuchaBotones);
        dado6 = new Dado(6);
        dado6.addMouseListener(escuchaBotones);
        dado7 = new Dado(1);
        dado7.addMouseListener(escuchaBotones);
        dado8 = new Dado(2);

        dado9 = new Dado(3);

        dado10 = new Dado(4);

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
        panelDadosActivos.setPreferredSize(new Dimension(600,250));
        panelDadosActivos.setBorder(BorderFactory.createTitledBorder("Dados Activos"));
        panelDadosActivos.add(dado1);
        panelDadosActivos.add(dado2);
        panelDadosActivos.add(dado3);
        panelDadosActivos.add(dado4);
        panelDadosActivos.add(dado5);
        panelDadosActivos.add(dado6);
        panelDadosActivos.add(dado7);
        panelDadosInactivos.add(dado8);
        panelDadosInactivos.add(dado9);
        panelDadosInactivos.add(dado10);

        constraints.gridx=0;
        constraints.gridy=3;
        constraints.gridwidth=1;
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


        resultados = new JTextArea(6, 40);
        resultados.setEditable(false);
        resultados.setBorder(BorderFactory.createTitledBorder("Resultados"));
        constraints.gridx=0;
        constraints.gridy=5;
        constraints.gridwidth=2;
        constraints.fill=GridBagConstraints.NONE;
        constraints.anchor=GridBagConstraints.CENTER;
        this.add(resultados,constraints);
        resultados.setText("Ronda "+ 0 +
                "\nPuntuación Ronda "+ 0 +
                "\nTotal acumulado "+ 0
        );

    }

    /**
     * Main process of the Java program
     * @param args Object used in order to send input data from command line when
     *             the program is execute by console.
     */
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            GUIGridBagLayout miProjectGUI = new GUIGridBagLayout();
        });
    }


    private class Escucha implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            int contadorRonda = modelGeek.getronda();
            int resultadoRonda = modelGeek.resultadoDados(resultadosID,resultadoDados, contadorRonda);
            int puntajeAcumulado = modelGeek.totalGame(resultadoRonda);



            if (puntajeAcumulado >= 30 && contadorRonda <= 5) {
                int opcion = JOptionPane.showConfirmDialog(null, "GANASTE \n"
                                + "Obtuviste " + puntajeAcumulado + " puntos en menos de " + contadorRonda + " rondas\n"
                         + "¿Quienes volver a jugar?",
                        "PopUp Dialog", JOptionPane.YES_NO_OPTION);
                contadorRonda = modelGeek.reset();
                resultadoRonda = modelGeek.resetPunto();
                puntajeAcumulado = 0;
                if(opcion == JOptionPane.YES_OPTION){
                    //Volver a lanzar

                }else{
                    if(opcion == JOptionPane.NO_OPTION){
                        System.exit(0);
                    }
                }



            }

            if (contadorRonda == 6) {
                int opcion = JOptionPane.showConfirmDialog(null, "PERDISTE \n"
                                + "Obtuviste " + puntajeAcumulado + " puntos en menos de " + contadorRonda + " rondas\n"
                                + "¿Quienes volver a jugar?",
                        "PopUp Dialog", JOptionPane.YES_NO_OPTION);
                contadorRonda = modelGeek.reset();
                resultadoRonda = modelGeek.resetPunto();
                puntajeAcumulado = 0;
                if(opcion == JOptionPane.YES_OPTION){
                    //Volver a lanzar

                }else{
                    if(opcion == JOptionPane.NO_OPTION){
                        System.exit(0);
                    }
                }


            }


            if(e.getSource() == lanzar){

                imageDado1 = new ImageIcon(getClass().getResource("/resourses/"+dado1.getCara()+".jpeg"));
                dado1.setIcon(imageDado1);
                imageDado2 = new ImageIcon(getClass().getResource("/resourses/"+dado2.getCara()+".jpeg"));
                dado2.setIcon(imageDado2);
                imageDado3 = new ImageIcon(getClass().getResource("/resourses/"+dado3.getCara()+".jpeg"));
                dado3.setIcon(imageDado3);
                imageDado4 = new ImageIcon(getClass().getResource("/resourses/"+dado4.getCara()+".jpeg"));
                dado4.setIcon(imageDado4);
                imageDado5 = new ImageIcon(getClass().getResource("/resourses/"+dado5.getCara()+".jpeg"));
                dado5.setIcon(imageDado5);
                imageDado6 = new ImageIcon(getClass().getResource("/resourses/"+dado6.getCara()+".jpeg"));
                dado6.setIcon(imageDado6);
                imageDado7 = new ImageIcon(getClass().getResource("/resourses/"+dado7.getCara()+".jpeg"));
                dado7.setIcon(imageDado7);
                imageDado8 = new ImageIcon(getClass().getResource("/resourses/"+dado8.getCara()+".jpeg"));
                dado8.setIcon(imageDado8);
                imageDado9 = new ImageIcon(getClass().getResource("/resourses/"+dado9.getCara()+".jpeg"));
                dado9.setIcon(imageDado9);
                imageDado10 = new ImageIcon(getClass().getResource("/resourses/"+dado10.getCara()+".jpeg"));
                dado10.setIcon(imageDado10);


                resultadosID = panelDadosActivos.getComponents();

                resultados.setText("Ronda "+ modelGeek.sigronda() +
                        "\nPuntuación Ronda "+ resultadoRonda +
                        "\nTotal acumulado "+ puntajeAcumulado
                );

                panelDadosActivos.add(dado1);
                panelDadosActivos.add(dado2);
                panelDadosActivos.add(dado3);
                panelDadosActivos.add(dado4);
                panelDadosActivos.add(dado5);
                panelDadosActivos.add(dado6);
                panelDadosActivos.add(dado7);
                panelDadosInactivos.add(dado8);
                panelDadosInactivos.add(dado9);
                panelDadosInactivos.add(dado10);



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


    /**ESCUCHA QUE REDIRECCIONA A CADA DADO A SU RESPECTIVA ESCUCHA
     *
     */

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class EscuchaBotones extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int contadorRonda = modelGeek.getronda();
            int resultadoRonda = modelGeek.resultadoDados(resultadosID,resultadoDados, contadorRonda);
            int puntajeAcumulado = modelGeek.totalGame(resultadoRonda);
            Dado dadoElegido = (Dado) e.getSource();

            //SUPERHEROE

                if (dadoElegido.getId() == 3){

                    dado1.addMouseListener(escuchaSuperHeroe);
                    dado2.addMouseListener(escuchaSuperHeroe);
                    dado3.addMouseListener(escuchaSuperHeroe);
                    dado4.addMouseListener(escuchaSuperHeroe);
                    dado5.addMouseListener(escuchaSuperHeroe);
                    dado6.addMouseListener(escuchaSuperHeroe);
                    dado7.addMouseListener(escuchaSuperHeroe);



                    dadoElegido.removeMouseListener(escuchaSuperHeroe);
                    panelDadosUtilizados.add(dadoElegido);
                    panelDadosActivos.remove(dadoElegido); //PRUEBA

            }
            //COHETE

                if(dadoElegido.getId() == 5){

                    dado1.addMouseListener(escuchaCohete);
                    dado2.addMouseListener(escuchaCohete);
                    dado3.addMouseListener(escuchaCohete);
                    dado4.addMouseListener(escuchaCohete);
                    dado5.addMouseListener(escuchaCohete);
                    dado6.addMouseListener(escuchaCohete);
                    dado7.addMouseListener(escuchaCohete);



                    dadoElegido.removeMouseListener(escuchaCohete);
                    panelDadosUtilizados.add(dadoElegido);
                    panelDadosActivos.remove(dadoElegido); //PRUEBA

                }

            //MEEPLE

            if(dadoElegido.getId() == 4){

                dado1.addMouseListener(escuchaMeeple);
                dado2.addMouseListener(escuchaMeeple);
                dado3.addMouseListener(escuchaMeeple);
                dado4.addMouseListener(escuchaMeeple);
                dado5.addMouseListener(escuchaMeeple);
                dado6.addMouseListener(escuchaMeeple);
                dado7.addMouseListener(escuchaMeeple);



                dadoElegido.removeMouseListener(escuchaMeeple);
                panelDadosUtilizados.add(dadoElegido);
                panelDadosActivos.remove(dadoElegido); //PRUEBA

            }

            //CORAZON

            if(dadoElegido.getId() == 6){
                dado1.removeMouseListener(escuchaBotones);
                dado2.removeMouseListener(escuchaBotones);
                dado3.removeMouseListener(escuchaBotones);
                dado4.removeMouseListener(escuchaBotones);
                dado5.removeMouseListener(escuchaBotones);
                dado6.removeMouseListener(escuchaBotones);
                dado7.removeMouseListener(escuchaBotones);

                dado8.addMouseListener(escuchaCorazon);
                dado9.addMouseListener(escuchaCorazon);
                dado10.addMouseListener(escuchaCorazon);

                dadoElegido.removeMouseListener(escuchaCorazon);
                panelDadosUtilizados.add(dadoElegido);
                panelDadosActivos.remove(dadoElegido); //PRUEBA

            }

            resultadosID = panelDadosActivos.getComponents();
            /*LOS ID DE LOS DADOS NO SALEN DEL VECTOR AL MOVERLOS DE JPANEL*/
            int[] vector2 = modelGeek.componenteToVector(resultadosID,resultadoDados, contadorRonda);


            System.out.println("ID DE LOS DADOS");
            System.out.println(vector2[0]);
            System.out.println(vector2[1]);
            System.out.println(vector2[2]);
            System.out.println(vector2[3]);
            System.out.println(vector2[4]);
            System.out.println(vector2[5]);
            System.out.println(vector2[6]);
            revalidate();
            repaint();
        }

    }

    //ESCUCHA DEL DADO CON CARA DE SUPERHEROE

    private class EscuchaSuperHeroe extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Dado dadoElegido = (Dado) e.getSource();


            if(dadoElegido.getId() == 5){//COHETE

                dadoElegido.removeMouseListener(escuchaCohete);
                dadoElegido.getCaraContraria();
                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getId()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);
                dado1.removeMouseListener(escuchaSuperHeroe);
                dado2.removeMouseListener(escuchaSuperHeroe);
                dado3.removeMouseListener(escuchaSuperHeroe);
                dado4.removeMouseListener(escuchaSuperHeroe);
                dado5.removeMouseListener(escuchaSuperHeroe);
                dado6.removeMouseListener(escuchaSuperHeroe);
                dado7.removeMouseListener(escuchaSuperHeroe);

                dado1.removeMouseListener(escuchaCohete);
                dado2.removeMouseListener(escuchaCohete);
                dado3.removeMouseListener(escuchaCohete);
                dado4.removeMouseListener(escuchaCohete);
                dado5.removeMouseListener(escuchaCohete);
                dado6.removeMouseListener(escuchaCohete);
                dado7.removeMouseListener(escuchaCohete);

                panelDadosActivos.add(dadoElegido);
                dadoElegido.cambiarId(0);

            }else if(dadoElegido.getId() == 3){ //SUPERHEROE

                dadoElegido.getCaraContraria();
                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getId()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);
                dadoElegido.removeMouseListener(escuchaSuperHeroe);

                panelDadosActivos.add(dadoElegido);


                }else if(dadoElegido.getId() == 4){ //MEEPLE

                dadoElegido.getCaraContraria();
                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getId()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);
                dadoElegido.removeMouseListener(escuchaMeeple);
                dado1.removeMouseListener(escuchaMeeple);
                dado2.removeMouseListener(escuchaMeeple);
                dado3.removeMouseListener(escuchaMeeple);
                dado4.removeMouseListener(escuchaMeeple);
                dado5.removeMouseListener(escuchaMeeple);
                dado6.removeMouseListener(escuchaMeeple);
                dado7.removeMouseListener(escuchaMeeple);

                dado1.removeMouseListener(escuchaSuperHeroe);
                dado2.removeMouseListener(escuchaSuperHeroe);
                dado3.removeMouseListener(escuchaSuperHeroe);
                dado4.removeMouseListener(escuchaSuperHeroe);
                dado5.removeMouseListener(escuchaSuperHeroe);
                dado6.removeMouseListener(escuchaSuperHeroe);
                dado7.removeMouseListener(escuchaSuperHeroe);
                panelDadosActivos.add(dadoElegido);


            }else if(dadoElegido.getId() == 6){ //CORAZON

                dadoElegido.getCaraContraria();
                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getId()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);
                dadoElegido.removeMouseListener(escuchaMeeple);
                dado1.removeMouseListener(escuchaSuperHeroe);
                dado2.removeMouseListener(escuchaSuperHeroe);
                dado3.removeMouseListener(escuchaSuperHeroe);
                dado4.removeMouseListener(escuchaSuperHeroe);
                dado5.removeMouseListener(escuchaSuperHeroe);
                dado6.removeMouseListener(escuchaSuperHeroe);
                dado7.removeMouseListener(escuchaSuperHeroe);

                dado1.addMouseListener(escuchaBotones);
                dado2.addMouseListener(escuchaBotones);
                dado3.addMouseListener(escuchaBotones);
                dado4.addMouseListener(escuchaBotones);
                dado5.addMouseListener(escuchaBotones);
                dado6.addMouseListener(escuchaBotones);
                dado7.addMouseListener(escuchaBotones);

                dado8.removeMouseListener(escuchaCorazon);
                dado9.removeMouseListener(escuchaCorazon);
                dado10.removeMouseListener(escuchaCorazon);
                panelDadosActivos.add(dadoElegido);


            }else if(dadoElegido.getId() == 1 || dadoElegido.getId() == 2){//42 y DRAGON

                dadoElegido.getCaraContraria();
                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getId()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);

                dado1.removeMouseListener(escuchaSuperHeroe);
                dado2.removeMouseListener(escuchaSuperHeroe);
                dado3.removeMouseListener(escuchaSuperHeroe);
                dado4.removeMouseListener(escuchaSuperHeroe);
                dado5.removeMouseListener(escuchaSuperHeroe);
                dado6.removeMouseListener(escuchaSuperHeroe);
                dado7.removeMouseListener(escuchaSuperHeroe);
                panelDadosActivos.add(dadoElegido);

            }else{

            }
            revalidate();
            repaint();
        }
    }

    //ESCUCHA DEL DADO CON CARA DE COHETE

    private class EscuchaCohete extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Dado dadoElegido = (Dado) e.getSource();
            if(dadoElegido.getId() == 5){//COHETE

                panelDadosUtilizados.add(dadoElegido);
                panelDadosActivos.remove(dadoElegido); //PRUEBA
                dado1.removeMouseListener(escuchaCohete);
                dado2.removeMouseListener(escuchaCohete);
                dado3.removeMouseListener(escuchaCohete);
                dado4.removeMouseListener(escuchaCohete);
                dado5.removeMouseListener(escuchaCohete);
                dado6.removeMouseListener(escuchaCohete);
                dado7.removeMouseListener(escuchaCohete);

                dado1.removeMouseListener(escuchaCohete);
                dado2.removeMouseListener(escuchaCohete);
                dado3.removeMouseListener(escuchaCohete);
                dado4.removeMouseListener(escuchaCohete);
                dado5.removeMouseListener(escuchaCohete);
                dado6.removeMouseListener(escuchaCohete);
                dado7.removeMouseListener(escuchaCohete);


            }else if(dadoElegido.getId() == 3){//SUPERHEROE
                panelDadosUtilizados.add(dadoElegido);
                panelDadosActivos.remove(dadoElegido); //PRUEBA
                dado1.removeMouseListener(escuchaCohete);
                dado2.removeMouseListener(escuchaCohete);
                dado3.removeMouseListener(escuchaCohete);
                dado4.removeMouseListener(escuchaCohete);
                dado5.removeMouseListener(escuchaCohete);
                dado6.removeMouseListener(escuchaCohete);
                dado7.removeMouseListener(escuchaCohete);


                dado1.removeMouseListener(escuchaSuperHeroe);
                dado2.removeMouseListener(escuchaSuperHeroe);
                dado3.removeMouseListener(escuchaSuperHeroe);
                dado4.removeMouseListener(escuchaSuperHeroe);
                dado5.removeMouseListener(escuchaSuperHeroe);
                dado6.removeMouseListener(escuchaSuperHeroe);
                dado7.removeMouseListener(escuchaSuperHeroe);

            }else if(dadoElegido.getId() == 4){//MEEPLE
                panelDadosUtilizados.add(dadoElegido);
                panelDadosActivos.remove(dadoElegido); //PRUEBA
                dado1.removeMouseListener(escuchaCohete);
                dado2.removeMouseListener(escuchaCohete);
                dado3.removeMouseListener(escuchaCohete);
                dado4.removeMouseListener(escuchaCohete);
                dado5.removeMouseListener(escuchaCohete);
                dado6.removeMouseListener(escuchaCohete);
                dado7.removeMouseListener(escuchaCohete);


                dado1.removeMouseListener(escuchaMeeple);
                dado2.removeMouseListener(escuchaMeeple);
                dado3.removeMouseListener(escuchaMeeple);
                dado4.removeMouseListener(escuchaMeeple);
                dado5.removeMouseListener(escuchaMeeple);
                dado6.removeMouseListener(escuchaMeeple);
                dado7.removeMouseListener(escuchaMeeple);

            }else if(dadoElegido.getId() == 6){//CORAZON
                panelDadosUtilizados.add(dadoElegido);
                panelDadosActivos.remove(dadoElegido); //PRUEBA
                dado1.removeMouseListener(escuchaCohete);
                dado2.removeMouseListener(escuchaCohete);
                dado3.removeMouseListener(escuchaCohete);
                dado4.removeMouseListener(escuchaCohete);
                dado5.removeMouseListener(escuchaCohete);
                dado6.removeMouseListener(escuchaCohete);
                dado7.removeMouseListener(escuchaCohete);

                dado1.addMouseListener(escuchaBotones);
                dado2.addMouseListener(escuchaBotones);
                dado3.addMouseListener(escuchaBotones);
                dado4.addMouseListener(escuchaBotones);
                dado5.addMouseListener(escuchaBotones);
                dado6.addMouseListener(escuchaBotones);
                dado7.addMouseListener(escuchaBotones);


                dado8.removeMouseListener(escuchaCorazon);
                dado9.removeMouseListener(escuchaCorazon);
                dado10.removeMouseListener(escuchaCorazon);

            }else{//42 Y DRAGON
                panelDadosUtilizados.add(dadoElegido);
                panelDadosActivos.remove(dadoElegido); //PRUEBA
                dado1.removeMouseListener(escuchaCohete);
                dado2.removeMouseListener(escuchaCohete);
                dado3.removeMouseListener(escuchaCohete);
                dado4.removeMouseListener(escuchaCohete);
                dado5.removeMouseListener(escuchaCohete);
                dado6.removeMouseListener(escuchaCohete);
                dado7.removeMouseListener(escuchaCohete);

                dadoElegido.removeMouseListener(escuchaBotones);
            }
            revalidate();
            repaint();
        }
    }

    //ESCUCHA DEL DADO CON CARA DE MEEPLE

    private class EscuchaMeeple extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            Dado dadoElegido = (Dado) e.getSource();


            if(dadoElegido.getId() == 5){//COHETE

                dadoElegido.removeMouseListener(escuchaCohete);

                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getCara()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);
                dado1.removeMouseListener(escuchaMeeple);
                dado2.removeMouseListener(escuchaMeeple);
                dado3.removeMouseListener(escuchaMeeple);
                dado4.removeMouseListener(escuchaMeeple);
                dado5.removeMouseListener(escuchaMeeple);
                dado6.removeMouseListener(escuchaMeeple);
                dado7.removeMouseListener(escuchaMeeple);

                dado1.removeMouseListener(escuchaCohete);
                dado2.removeMouseListener(escuchaCohete);
                dado3.removeMouseListener(escuchaCohete);
                dado4.removeMouseListener(escuchaCohete);
                dado5.removeMouseListener(escuchaCohete);
                dado6.removeMouseListener(escuchaCohete);
                dado7.removeMouseListener(escuchaCohete);

                panelDadosActivos.add(dadoElegido);


            }else if(dadoElegido.getId() == 3){//SUPERHEROE


                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getCara()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);
                dado1.removeMouseListener(escuchaMeeple);
                dado2.removeMouseListener(escuchaMeeple);
                dado3.removeMouseListener(escuchaMeeple);
                dado4.removeMouseListener(escuchaMeeple);
                dado5.removeMouseListener(escuchaMeeple);
                dado6.removeMouseListener(escuchaMeeple);
                dado7.removeMouseListener(escuchaMeeple);

                dado1.removeMouseListener(escuchaSuperHeroe);
                dado2.removeMouseListener(escuchaSuperHeroe);
                dado3.removeMouseListener(escuchaSuperHeroe);
                dado4.removeMouseListener(escuchaSuperHeroe);
                dado5.removeMouseListener(escuchaSuperHeroe);
                dado6.removeMouseListener(escuchaSuperHeroe);
                dado7.removeMouseListener(escuchaSuperHeroe);

                panelDadosActivos.add(dadoElegido);


            }else if(dadoElegido.getId() == 4){ //MEEPLE
                dado1.removeMouseListener(escuchaMeeple);
                dado2.removeMouseListener(escuchaMeeple);
                dado3.removeMouseListener(escuchaMeeple);
                dado4.removeMouseListener(escuchaMeeple);
                dado5.removeMouseListener(escuchaMeeple);
                dado6.removeMouseListener(escuchaMeeple);
                dado7.removeMouseListener(escuchaMeeple);

                dado1.removeMouseListener(escuchaMeeple);
                dado2.removeMouseListener(escuchaMeeple);
                dado3.removeMouseListener(escuchaMeeple);
                dado4.removeMouseListener(escuchaMeeple);
                dado5.removeMouseListener(escuchaMeeple);
                dado6.removeMouseListener(escuchaMeeple);
                dado7.removeMouseListener(escuchaMeeple);

                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getCara()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);
                panelDadosActivos.add(dadoElegido);


            }else if(dadoElegido.getId() == 6){ //CORAZON
                dado1.removeMouseListener(escuchaMeeple);
                dado2.removeMouseListener(escuchaMeeple);
                dado3.removeMouseListener(escuchaMeeple);
                dado4.removeMouseListener(escuchaMeeple);
                dado5.removeMouseListener(escuchaMeeple);
                dado6.removeMouseListener(escuchaMeeple);
                dado7.removeMouseListener(escuchaMeeple);

                dado1.addMouseListener(escuchaBotones);
                dado2.addMouseListener(escuchaBotones);
                dado3.addMouseListener(escuchaBotones);
                dado4.addMouseListener(escuchaBotones);
                dado5.addMouseListener(escuchaBotones);
                dado6.addMouseListener(escuchaBotones);
                dado7.addMouseListener(escuchaBotones);

                dado8.removeMouseListener(escuchaCorazon);
                dado9.removeMouseListener(escuchaCorazon);
                dado10.removeMouseListener(escuchaCorazon);

                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getCara()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);
                panelDadosActivos.add(dadoElegido);


            }else if(dadoElegido.getId() == 1 || dadoElegido.getId() == 2 ){//42 Y DRAGON

                dado1.removeMouseListener(escuchaMeeple);
                dado2.removeMouseListener(escuchaMeeple);
                dado3.removeMouseListener(escuchaMeeple);
                dado4.removeMouseListener(escuchaMeeple);
                dado5.removeMouseListener(escuchaMeeple);
                dado6.removeMouseListener(escuchaMeeple);
                dado7.removeMouseListener(escuchaMeeple);

                dado1.removeMouseListener(escuchaMeeple);
                dado2.removeMouseListener(escuchaMeeple);
                dado3.removeMouseListener(escuchaMeeple);
                dado4.removeMouseListener(escuchaMeeple);
                dado5.removeMouseListener(escuchaMeeple);
                dado6.removeMouseListener(escuchaMeeple);
                dado7.removeMouseListener(escuchaMeeple);

                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getCara()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);
                panelDadosActivos.add(dadoElegido);
            }else{

            }
            revalidate();
            repaint();
        }
    }

    //ESCUCHA DEL DADO CON CARA DE CORAZON

    private class EscuchaCorazon extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Dado dadoElegido = (Dado) e.getSource();


            if(dadoElegido.getId() == 5){//COHETE

                dadoElegido.removeMouseListener(escuchaCohete);

                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getCara()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);

                dado8.removeMouseListener(escuchaCorazon);
                dado9.removeMouseListener(escuchaCorazon);
                dado10.removeMouseListener(escuchaCorazon);


                dado8.removeMouseListener(escuchaCorazon);
                dado9.removeMouseListener(escuchaCorazon);
                dado10.removeMouseListener(escuchaCorazon);


                dado1.addMouseListener(escuchaBotones);
                dado2.addMouseListener(escuchaBotones);
                dado3.addMouseListener(escuchaBotones);
                dado4.addMouseListener(escuchaBotones);
                dado5.addMouseListener(escuchaBotones);
                dado6.addMouseListener(escuchaBotones);
                dado7.addMouseListener(escuchaBotones);
                dadoElegido.addMouseListener(escuchaBotones);
                panelDadosActivos.add(dadoElegido);


            }else if(dadoElegido.getId() == 3){//SUPERHEROE
                dadoElegido.removeMouseListener(escuchaSuperHeroe);
                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getCara()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);

                dado8.removeMouseListener(escuchaCorazon);
                dado9.removeMouseListener(escuchaCorazon);
                dado10.removeMouseListener(escuchaCorazon);


                dado8.removeMouseListener(escuchaCorazon);
                dado9.removeMouseListener(escuchaCorazon);
                dado10.removeMouseListener(escuchaCorazon);


                dado1.addMouseListener(escuchaBotones);
                dado2.addMouseListener(escuchaBotones);
                dado3.addMouseListener(escuchaBotones);
                dado4.addMouseListener(escuchaBotones);
                dado5.addMouseListener(escuchaBotones);
                dado6.addMouseListener(escuchaBotones);
                dado7.addMouseListener(escuchaBotones);
                dadoElegido.addMouseListener(escuchaBotones);
                panelDadosActivos.add(dadoElegido);

            }else if(dadoElegido.getId() == 6){ //CORAZON

                dadoElegido.removeMouseListener(escuchaCorazon);

                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getCara()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);

                dado8.removeMouseListener(escuchaCorazon);
                dado9.removeMouseListener(escuchaCorazon);
                dado10.removeMouseListener(escuchaCorazon);


                dado8.removeMouseListener(escuchaCorazon);
                dado9.removeMouseListener(escuchaCorazon);
                dado10.removeMouseListener(escuchaCorazon);


                dado1.addMouseListener(escuchaBotones);
                dado2.addMouseListener(escuchaBotones);
                dado3.addMouseListener(escuchaBotones);
                dado4.addMouseListener(escuchaBotones);
                dado5.addMouseListener(escuchaBotones);
                dado6.addMouseListener(escuchaBotones);
                dado7.addMouseListener(escuchaBotones);
                dadoElegido.addMouseListener(escuchaBotones);
                panelDadosActivos.add(dadoElegido);

            }else if(dadoElegido.getId() == 4){ //MEEPLE

                dadoElegido.removeMouseListener(escuchaMeeple);

                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getCara()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);
                dado8.removeMouseListener(escuchaCorazon);
                dado9.removeMouseListener(escuchaCorazon);
                dado10.removeMouseListener(escuchaCorazon);


                dado8.removeMouseListener(escuchaCorazon);
                dado9.removeMouseListener(escuchaCorazon);
                dado10.removeMouseListener(escuchaCorazon);


                dado1.addMouseListener(escuchaBotones);
                dado2.addMouseListener(escuchaBotones);
                dado3.addMouseListener(escuchaBotones);
                dado4.addMouseListener(escuchaBotones);
                dado5.addMouseListener(escuchaBotones);
                dado6.addMouseListener(escuchaBotones);
                dado7.addMouseListener(escuchaBotones);
                dadoElegido.addMouseListener(escuchaBotones);
                panelDadosActivos.add(dadoElegido);

            }else if(dadoElegido.getId() == 1 || dadoElegido.getId() == 2){//42 Y DRAGON


                imagenDadoElegido = new ImageIcon(getClass().getResource("/resourses/"+dadoElegido.getCara()+".jpeg"));
                dadoElegido.setIcon(imagenDadoElegido);

                dado8.removeMouseListener(escuchaCorazon);
                dado9.removeMouseListener(escuchaCorazon);
                dado10.removeMouseListener(escuchaCorazon);


                dado8.removeMouseListener(escuchaCorazon);
                dado9.removeMouseListener(escuchaCorazon);
                dado10.removeMouseListener(escuchaCorazon);


                dado1.addMouseListener(escuchaBotones);
                dado2.addMouseListener(escuchaBotones);
                dado3.addMouseListener(escuchaBotones);
                dado4.addMouseListener(escuchaBotones);
                dado5.addMouseListener(escuchaBotones);
                dado6.addMouseListener(escuchaBotones);
                dado7.addMouseListener(escuchaBotones);
                dadoElegido.addMouseListener(escuchaBotones);
                panelDadosActivos.add(dadoElegido);
            }
            revalidate();
            repaint();
    }
    }
}
