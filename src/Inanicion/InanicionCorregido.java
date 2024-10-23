package Inanicion;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InanicionCorregido {
    private Lock lock = new ReentrantLock(true); // true para equidad

    public void accederRecurso() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " está accediendo al recurso.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        InanicionCorregido ejemplo = new InanicionCorregido();

        Runnable tarea = () -> {
            for (int i = 0; i < 5; i++) {
                ejemplo.accederRecurso();
            }
        };

        Thread hilo1 = new Thread(tarea, "Hilo 1");
        Thread hilo2 = new Thread(tarea, "Hilo 2");
        Thread hilo3 = new Thread(tarea, "Hilo 3");

        hilo1.start();
        hilo2.start();
        hilo3.start();
    }
}
