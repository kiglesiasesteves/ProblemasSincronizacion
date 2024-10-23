package Inanicion;

public class Inanicion {
    public static void main(String[] args) {
        Runnable altaPrioridad = () -> {
            while (true) {
                System.out.println("Alta prioridad en ejecución.");
            }
        };

        Runnable bajaPrioridad = () -> {
            while (true) {
                System.out.println("Baja prioridad en ejecución.");
            }
        };

        Thread hilo1 = new Thread(altaPrioridad);
        Thread hilo2 = new Thread(bajaPrioridad);

        hilo1.setPriority(Thread.MAX_PRIORITY);
        hilo2.setPriority(Thread.MIN_PRIORITY);

        hilo1.start();
        hilo2.start();
    }
}
