package GeekOutMasters;


import javax.swing.*;
import java.awt.*;


/**
 * ModelGeek apply crabs Rules
 * tiro = 5 End game
 *
 * @author Sebastian Rey Escobar and santiago Sanchez
 * @version 1.0.0
 * @date 28/01/2022
 */


public class ModelGeek {

    private int tiro = 1, punto, puntajeTotal;


    /**
     * Class Constructor
     * @author Sebastian Rey Escobar and santiago sanchez
     * @version 1.0.0
     * @date: 25/01/2022
     */

    public ModelGeek() {

    }

    /**
     *
     * Establish the round when the game start
     * @author Sebastian Rey Escobar and santiago sanchez
     * @version 1.0.0
     * @date: 25/01/2022
     */


    public int getronda() {

        return tiro;
    }

    /**
     * Reset the round when i used all te powers of the craps in the round and loop the craps again
     * @author Sebastian Rey Escobar and santiago sanchez
     * @version 1.0.0
     * @date: 25/01/2022
     */

    public int reset() {

        return tiro = 0;
    }

    /**
     * Reset the point when i used all te powers of the craps in the round and loop the craps again
     * @author Sebastian Rey Escobar and santiago sanchez
     * @version 1.0.0
     * @date: 25/01/2022
     */


    public int resetPunto() {

        return punto = 0;
    }

    /**
     * go to the round when i used all te powers of the craps in the round and loop the craps again
     * @author Sebastian Rey Escobar and santiago sanchez
     * @version 1.0.0
     * @date: 25/01/2022
     */

    public int sigronda() {

        return tiro++;
    }

    /**
     * Funcion que me garantiza que todos los dados de un vector de ID sea el 1, es decir,
     * el dado 42
     * @author Sebastian Rey Escobar and santiago sanchez
     * @version 1.0.0
     * @date: 25/01/2022
     */

    public boolean todosSon42(int[] vector) {
        int tamaño = vector.length;
        int contador42 = 0;

        for (int i = 0; i < tamaño; i++) {
            if (vector[i] == 1) {
                contador42++;
            }
            if (vector[i] != 1 && vector[i] != 2) {

            }
        }

        if (contador42 == tamaño) {
            return true;
        } else {
            return false;
        }


    }

    /**
     * Funcion que me garantiza que todos los dados de un vector de ID sea el , es decir,
     * el dado Dragon
     * @author Sebastian Rey Escobar and santiago sanchez
     * @version 1.0.0
     * @date: 25/01/2022
     */
    public boolean todosSonDragones(int[] vector) {
        int tamaño = vector.length;
        int contadorDragon = 0;

        for (int i = 0; i < tamaño; i++) {
            if (vector[i] == 2) {
                contadorDragon++;
            }
        }

        if (contadorDragon == tamaño) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Method that extracts all the Ids from the vector of components and puts them in another vector of numbers
     * @author Sebastian Rey Escobar and santiago sanchez
     * @version 1.0.0
     * @date: 28/01/2022
     */
    public int[] componenteToVector(Component[] resultadosID, int[] vector, int rondaDeJuego){
        for (int i = 0; i < resultadosID.length; i++) {
            vector[i] = ((Dado) resultadosID[i]).getId();

        }
        return vector;
    }

    /**
     * Method that extracts all the Ids from the vector of components and puts them in another vector of numbers
     * @author Sebastian Rey Escobar and santiago sanchez
     * @version 1.0.0
     * @date: 28/01/2022
     */
    public int[] vectorDeId(Component[] resultadosID, int[] vector) {
        for (int i = 0; i < resultadosID.length; i++) {
            vector[i] = ((Dado) resultadosID[i]).getId();
        }
        return vector;
    }


    /**
     * Funcion que me garantiza que todos los dados de un vector de ID sea el , es decir,
     * el dado Dragon
     * @author Sebastian Rey Escobar and santiago sanchez
     * @version 1.0.0
     * @date: 28/01/2022
     */
    public int resultadoDados(Component[] resultadosID, int[] vector, int rondaDeJuego) {
        int puntajePorRonda = 0;
        if (rondaDeJuego == 1) {
            return punto;
        } else {

            componenteToVector(resultadosID,vector,rondaDeJuego);

            if (todosSonDragones(vector) == true) {
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



    /**
     * Accumulates the total score of the round, plus the total score of the round.
     * @author Sebastian Rey Escobar and santiago sanchez
     * @version 1.0.0
     * @date: 28/01/2022
     */
    public int totalGame(int puntajeRonda) {
        puntajeTotal += puntajeRonda;

        if (puntajeRonda == 0) {
            puntajeTotal = 0;
        } else {
            return puntajeTotal;
        }
        return puntajeTotal;
    }



}