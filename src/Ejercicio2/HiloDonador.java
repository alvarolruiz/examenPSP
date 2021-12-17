package Ejercicio2;

import java.util.Random;

public class HiloDonador implements Runnable{
    private static final int MIN_DONACION = 10;
    private static final int MAX_DONACION = 100;
    private static final Random random = new Random();
    private CuentaCorriente cc;
    private double importeDonado = 0;

    public HiloDonador(CuentaCorriente cc) {
        this.cc = cc;
    }

    @Override
    public void run() {
        boolean seHaPodidoDonar = true;
        double donacion = 0;
        while(seHaPodidoDonar){
           donacion = generarDonacion();
           seHaPodidoDonar = cc.donar(donacion);
           if(seHaPodidoDonar){
               importeDonado +=donacion;
           }
        }
        System.out.println(String.format("Importe donado %f euros",importeDonado));
    }

    public static double generarDonacion(){
        return MIN_DONACION + random.nextInt(MAX_DONACION+1);
    }
}
