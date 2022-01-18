package GeekOutMasters;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * Class Dado: Create a random value between 1 and 6
 * @author Sebastian Rey
 * @version v.1.0.0
 * @date 13/01/2022
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
     * @author Sebastian Rey
     * @version v.1.0.0
     * @date 13/01/2022
     */

    public int getCara() {
        Random aleatorio = new Random();
        cara = aleatorio.nextInt(6)+1;
        this.id=cara;
        return cara;
    }

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

    public int getId() {
        return id;
    }

    public void getFuncionalidad() {
     /*   if(id == 3){
            MouseListener escuchaSuperHeroe = null;
            Dado.addMouseListener(escuchaSuperHeroe);
        }else if(id == 4){
            addMouseListener(escuchaMeeple);
        }else if(id == 5){
            addMouseListener(escuchaCohete);
        }else if(id == 6){
            addMouseListener(escuchaMeCorazon);
        }else{
            id = 0;
        }*/
    }
}
