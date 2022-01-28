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
        return tiro;
    }

    public int reset (){
        return tiro = 0 ;
    }
    public int resetPunto (){
        return punto = 0 ;
    }


    public int sigronda() {
        return tiro++;
    }
    /**
    *Funcion que me garantiza que todos los dados de un vector de ID sea el 1, es decir,
    el dado 42
    */

    public boolean todosSon42(int[] vector){
        int tamaño = vector.length;
        int contador42 = 0;

        for (int i = 0; i < tamaño; i++) {
           if(vector[i] == 1){
               contador42++;
           }
           if(vector[i] != 1 && vector[i] != 2){

           }
        }

        if(contador42 == tamaño){
            return true;
        }else{
            return false;
        }



    }

    public boolean todosSonDragones(int[] vector){
        int tamaño = vector.length;
        int contadorDragon = 0;

        for (int i = 0; i < tamaño; i++) {
            if(vector[i] == 2){
                contadorDragon++;
            }
        }

        if(contadorDragon == tamaño){
            return true;
        }else{
            return false;
        }

    }

public boolean quedaSoloUnDadoDiferenteONinguno(int[] vector){
        int tamaño = vector.length;

            if(tamaño ==1 && vector[0]!=1){
                return true;
            }

            if(tamaño == 0){
            return true;
    }

    return false;
}

public int[] vectorDeId (Component[] resultadosID , int[] vector){
    for (int i = 0; i < resultadosID.length; i++) {
        vector[i] = ((Dado) resultadosID[i]).getId();
    }
    return vector;
}

    public int resultadoDados( Component[] resultadosID ,int[] vector, int rondaDeJuego ){
        int puntajePorRonda = 0;
if(rondaDeJuego == 1){
    return punto;
}else {


    for (int i = 0; i < resultadosID.length; i++) {
        vector[i] = ((Dado) resultadosID[i]).getId();
    }

    if (todosSonDragones(vector)==true) {
        punto = 0;
    }

    for (int i = 0; i < vector.length; i++) {
        if (vector[i] == 1) {
            punto++;
        }
    }

    switch (punto) {
        case 0:
            punto = 0;
            break;
        case 1:
            punto = 1;
            break;
        case 2:
            punto = 3;
            break;
        case 3:
            punto = 6;
            break;
        case 4:
            punto = 10;
            break;
        case 5:
            punto = 15;
            break;
        case 6:
            punto = 21;
            break;
        case 7:
            punto = 28;
            break;
        case 8:
            punto = 36;
            break;
        case 9:
            punto = 45;
            break;
        case 10:
            punto = 55;
            break;
    }
    return punto;
}
    }


    public int totalGame(int puntajeRonda) {

        puntajeTotal+=puntajeRonda;

         puntajeTotal += puntajeRonda;

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