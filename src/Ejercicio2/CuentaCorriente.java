package Ejercicio2;

public class CuentaCorriente {
    private static final float MAXIMO_BUSCADO = 1000000;
    private double saldo;

    public CuentaCorriente() {
        this.saldo = 0;
    }

    synchronized public boolean donar (double importe){
        boolean operacionCorrecta = true;
        if(saldo<MAXIMO_BUSCADO){
            saldo+=importe;
        }else{
            operacionCorrecta=false;
        }
        return operacionCorrecta;
    }

}
