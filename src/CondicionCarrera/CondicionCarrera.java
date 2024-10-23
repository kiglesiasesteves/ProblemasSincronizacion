package CondicionCarrera;

public class CondicionCarrera implements Runnable {
    private int contador = 0;

    public void incrementar() {
        contador++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            incrementar();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CondicionCarrera rc = new CondicionCarrera();
        Thread hilo1 = new Thread(rc);
        Thread hilo2 = new Thread(rc);

        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();

        System.out.println("Contador final: " + rc.contador); // No será siempre 2000 debido a la condición de carrera.
    }
}
