package CondicionCarrera;

public class CondicionCarreraConObjeto {
    private int contador = 0;
    private final Object lock = new Object(); // Objeto para sincronización

    public void incrementar() {
        synchronized (lock) { // Sincronización utilizando el objeto lock
            contador++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CondicionCarreraConObjeto ejemplo = new CondicionCarreraConObjeto();

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
