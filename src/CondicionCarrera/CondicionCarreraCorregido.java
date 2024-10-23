package CondicionCarrera;

public class CondicionCarreraCorregido {
    private int contador = 0;

    public synchronized void incrementar() {
        contador++;
    }

    public static void main(String[] args) throws InterruptedException {
        CondicionCarreraCorregido ejemplo = new CondicionCarreraCorregido();

        Thread hilo1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                ejemplo.incrementar();
            }
        });

        Thread hilo2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                ejemplo.incrementar();
            }
        });

        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();

        System.out.println("Valor final del contador: " + ejemplo.contador);
    }
}
