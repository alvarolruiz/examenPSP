package Ejercicio2;

import Ejercicio1.Hilo;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
private static final int NUMERO_HILOS = 10;
private static final CuentaCorriente cc = new CuentaCorriente();

    public static void main(String[] args) {
        List<Thread> listaHilos = crearHilos();
        iniciarHilos(listaHilos);

    }
    private static List<Thread> crearHilos(){
        List<Thread> listaHilos = new ArrayList<>();
        for (int i = 1; i <= NUMERO_HILOS; i++) {
            listaHilos.add(new Thread(new HiloDonador(cc)));
        }
        return listaHilos;
    }

    private static void iniciarHilos(List<Thread> listaHilos) {
        for (Thread h : listaHilos) {
            h.start();
        }
    }


}
