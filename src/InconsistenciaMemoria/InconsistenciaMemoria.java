package InconsistenciaMemoria;

public class InconsistenciaMemoria {
    private boolean flag = false;

    public void correrHilo() throws InterruptedException {
        Thread hilo1 = new Thread(() -> {
            while (!flag) {
                // Sin sincronización, el cambio a `flag` puede no ser visible
            }
            System.out.println("Hilo 1 detecta cambio en flag.");
        });

        Thread hilo2 = new Thread(() -> {
            try {
                Thread.sleep(2000); // Simula alguna operación
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("Flag modificado a true.");
        });

        hilo1.start();
        hilo2.start();
        hilo1.join();
        hilo2.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new InconsistenciaMemoria().correrHilo();
    }
}
