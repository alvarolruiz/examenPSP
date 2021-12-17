package Ejercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
private static final int NUMERO_HILOS = 10;
private static final int TAMANO_ARRAY_NUMEROS = 100000;
private static final int RANGO_NUMEROS_ALEATORIOS = 1;
private static final int TIEMPO_ESPERA_MS = 1000;


private static final Random random = new Random();

    public static void main(String[] args) {
        List<Thread> listaHilos = crearHilos();
        iniciarHilos(listaHilos);
        esperarHilos(listaHilos);
        resumenHilos(listaHilos);
    }


    private static List<Thread> crearHilos(){
        List<Thread> listaHilos = new ArrayList<>();
        for (int i = 1; i <= NUMERO_HILOS; i++) {
            listaHilos.add(new Thread(new Hilo(i,generarArrayNumeros())));
        }
        return listaHilos;
    }

    private static void iniciarHilos(List<Thread> listaHilos) {
        for (Thread h : listaHilos) {
            h.start();
        }
    }

    private static void esperarHilos (List<Thread> listaHilos){
        try {
            Thread.currentThread().join(TIEMPO_ESPERA_MS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void resumenHilos(List<Thread> listaHilos) {
        boolean haTerminado = true;
        for (Thread h: listaHilos) {
            if(h.isAlive()){
                haTerminado=false;
            }
        }
        if(!haTerminado){
            System.out.println("Hilos demasiado lentos");
        }else{
            System.out.println("Hilos finalizados correctamente");
        }
    }

    private static float[] generarArrayNumeros() {
        float[] arrayNumeros  = new float[TAMANO_ARRAY_NUMEROS];
        for (int i = 0; i < arrayNumeros.length; i++) {
            arrayNumeros[i] = random.nextInt(RANGO_NUMEROS_ALEATORIOS +1);
        }
        return arrayNumeros;
    }

}
