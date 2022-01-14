package GeekOutMasters;

import java.util.Random;

/**
 * Class Dado: Create a random value between 1 and 6
 * @author Sebastian Rey
 * @version v.1.0.0
 * @date 13/01/2022
 */

public class Dado {

    private int cara;

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
        return cara;
    }

}
