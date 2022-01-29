package GeekOutMasters;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Class Dado: Create a random value between 1 and 6, and we can call this value, change for other and put a initial valua
 *             that be changed while the game is running
 * @authors Sebastian Rey and Santiago Sanchez
 * @version v.1.0.0
 * @date 28/01/2022
 */

public class Dado extends JLabel {

    private int cara;
    private int id;
    public Dado(int id){
    this.id = id;
    }

    /**
     * method: generate a random value to cara
     * @return number Btween (1.6)
     * @authors Sebastian Rey and Santiago Sanchez
     * @version v.1.0.0
     * @date 28/01/2022
     */

    public int getCara() {
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6)+1;
        this.id=cara;
        return cara;

    }

    /**
     * method: change te value of the face of the crap
     * @return number that we change for te value typed
     * @authors Sebastian Rey and Santiago Sanchez
     * @version v.1.0.0
     * @date 28/01/2022
     */
    public void cambiarId(int nuevoId){
        this.id = nuevoId;
    }


    /**
     * method: change te value according the value of this crap, according of the value of all the faces of the craps
     * @return number Btween (1.6)
     * @authors Sebastian Rey and Santiago Sanchez
     * @version v.1.0.0
     * @date 28/01/2022
     */

    public void getCaraContraria() {
        if(id == 1){
            id = 6;
        }else if(id == 6){
            id = 1;
        }else if(id == 2){
            id = 3;
        }else if(id == 3){
            id = 2;
        }else if(id == 4){
            id = 5;
        }else if(id == 5){
            id = 4;
        }else{
            id = 0;
        }
    }

    /**
     * method: call the value id
     * @return number
     * @authors Sebastian Rey and Santiago Sanchez
     * @version v.1.0.1
     * @date 28/01/2022
     */
    public int getId() {
        return id;
    }

}
