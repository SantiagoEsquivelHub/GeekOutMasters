package GeekOutMasters;


import javax.swing.*;
import java.awt.*;

public class ModelGeek {
    //dado1 y dado2 son son los objetos que permiten mostrar el valor de la cara visible del dado
    private Dado dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private int tiro = 1 , punto, estado, puntajeTotal;
    private String[] estadoToString;
    public int[] dados, dadosActivos, dadosUtilizados;
    public Component[] resultadosID;

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

    public int getronda() {
        return tiro=1;
    }

    public int sigronda() {
        return tiro++;
    }

    public int pointsRound() {
        return punto ;
    }





    public int resultadoDados( Component[] resultadosID ,int[] vector ){

        int puntajePorRonda = 0;

        for (int i = 0; i < resultadosID.length; i++)
        {
            vector[i] = ((Dado) resultadosID[i]).getId();
        }

        for (int i = 0; i < vector.length; i++)
        {
            if (vector[i]==1){
                puntajePorRonda++;
            }
            if (vector[i]==2) {
                puntajePorRonda = 0;
            }
        }

        switch (puntajePorRonda){
            case 0: puntajePorRonda = 0;
                break;
            case 1: puntajePorRonda = 1 ;
                break;
            case 2: puntajePorRonda = 3;
                break;
            case 3: puntajePorRonda = 6;
                break;
            case 4:puntajePorRonda = 10;
                break;
            case 5: puntajePorRonda = 15;
                break;
            case 6:puntajePorRonda = 21;
                break;
            case 7:puntajePorRonda = 28;
                break;
            case 8:puntajePorRonda = 36;
                break;
            case 9:puntajePorRonda = 45;
                break;
            case 10:puntajePorRonda = 55;
                break;
        }
        return puntajePorRonda;
    }


    public int totalGame(int puntajeRonda) {
        puntajeTotal+=puntajeRonda;
        if(puntajeRonda == 0){
            puntajeTotal = 0;
        }else{
           return puntajeTotal;
        }
        return puntajeTotal;
    }





 public void cambiarCara(Dado dadoEnviado){
     if(dadoEnviado.getId() == 1){
         dadoEnviado.getCaraContraria(); //cambia de id
         JOptionPane.showMessageDialog(null, "funciona?");
     }else{

     }
 }
}