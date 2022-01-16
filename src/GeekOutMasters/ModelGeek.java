package GeekOutMasters;

import javax.swing.*;

public class ModelGeek {
    //dado1 y dado2 son son los objetos que permiten mostrar el valor de la cara visible del dado
    private Dado dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private int tiro, punto, estado, ronda;
    private String[] estadoToString;
    public int[] dados, dadosActivos, dadosUtilizados;


    /**
     * Class Constructor
     */

    public ModelGeek() {
       /* dado1 = new Dado();
        dado2 = new Dado();
        dado3 = new Dado();
        dado4 = new Dado();
        dado5 = new Dado();
        dado6 = new Dado();
        dado7 = new Dado();
        dado8 = new Dado();
        dado9 = new Dado();
        dado10 = new Dado();
        dados = new int[10];
        ronda = 0;*/
    }

    /**
     * Establish the image according to each dice
     */

    public void calcularTiro() {
         dado1.getCara();
         dado2.getCara();
         dado3.getCara();
         dado4.getCara();
         dado5.getCara();
         dado6.getCara();
         dado7.getCara();
         dado8.getCara();
         dado9.getCara();
         dado10.getCara();
    }

    public int[] getCaras() {
        return dados;
    }



 public void cambiarCara(Dado dadoEnviado){
     if(dadoEnviado.getId() == 1){
         dadoEnviado.getCaraContraria(); //cambia de id
         JOptionPane.showMessageDialog(null, "funciona?");
     }else{

     }
 }
}