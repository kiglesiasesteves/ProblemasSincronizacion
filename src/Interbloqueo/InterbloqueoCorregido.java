package Interbloqueo;

public class InterbloqueoCorregido {
    private final Object recursoA = new Object();
    private final Object recursoB = new Object();

    public void metodo1() {
        synchronized (recursoA) {
            System.out.println(Thread.currentThread().getName() + " bloquea recurso A");
            synchronized (recursoB) {
                System.out.println(Thread.currentThread().getName() + " bloquea recurso B");
            }
        }
    }

    public void metodo2() {
        synchronized (recursoA) {
            System.out.println(Thread.currentThread().getName() + " bloquea recurso A");
            synchronized (recursoB) {
                System.out.println(Thread.currentThread().getName() + " bloquea recurso B");
            }
        }
    }

    public static void main(String[] args) {
        InterbloqueoCorregido ejemplo = new InterbloqueoCorregido();

        Thread hilo1 = new Thread(ejemplo::metodo1, "Hilo 1");
        Thread hilo2 = new Thread(ejemplo::metodo2, "Hilo 2");

        hilo1.start();
        hilo2.start();
    }
}
