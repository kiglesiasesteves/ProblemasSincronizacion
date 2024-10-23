package Interbloqueo;

public class Interbloqueo {
    private static final Object recursoA = new Object();
    private static final Object recursoB = new Object();

    public static void main(String[] args) {
        Thread hilo1 = new Thread(() -> {
            synchronized (recursoA) {
                System.out.println("Hilo 1 bloquea recurso A");
                try { Thread.sleep(50); } catch (InterruptedException e) {}
                synchronized (recursoB) {
                    System.out.println("Hilo 1 bloquea recurso B");
                }
            }
        });

        Thread hilo2 = new Thread(() -> {
            synchronized (recursoB) {
                System.out.println("Hilo 2 bloquea recurso B");
                try { Thread.sleep(50); } catch (InterruptedException e) {}
                synchronized (recursoA) {
                    System.out.println("Hilo 2 bloquea recurso A");
                }
            }
        });

        hilo1.start();
        hilo2.start();
    }
}
