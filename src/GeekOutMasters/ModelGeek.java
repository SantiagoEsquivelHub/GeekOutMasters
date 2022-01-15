package GeekOutMasters;

public class ModelGeek {
    //dado1 y dado2 son son los objetos que permiten mostrar el valor de la cara visible del dado
    private Dado dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private int tiro, punto, estado, ronda;
    private String[] estadoToString;
    private int[] dados, dadosActivos, dadosUtilizados;


    /**
     * Class Constructor
     */

    public ModelGeek(){
        dado1 = new Dado();
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
        estadoToString = new String[2];
        ronda = 0;
    }

    public void calcularTiro() {
        dados[0] = dado1.getCara();
        dados[1] = dado2.getCara();
        dados[2] = dado3.getCara();
        dados[3] = dado4.getCara();
        dados[4] = dado5.getCara();
        dados[5] = dado6.getCara();
        dados[6] = dado7.getCara();
        dados[7] = dado8.getCara();
        dados[8] = dado9.getCara();
        dados[9] = dado10.getCara();
    }

    public int[] getCaras() {
        return dados;
    }


}
