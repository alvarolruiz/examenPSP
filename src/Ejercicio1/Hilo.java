package Ejercicio1;

public class Hilo implements Runnable{

    private float[] arrayNumeros;
    private int id;

    public Hilo(int id, float[] array ) {
        this.id = id;
        this.arrayNumeros = array;
    }

    @Override
    public void run() {
        System.out.println(String.format("El hilo %s ha calculado una suma total de %f",this.id,sumarNumerosArray()));
    }
    private float sumarNumerosArray(){
        float resultado =0;
        for (int i = 0; i < arrayNumeros.length; i++) {
            resultado += arrayNumeros[i];
        }
        return resultado;
    }


}
