package InconsistenciaMemoria;

public class InconsistenciaMemoriaCorregido {
    private volatile boolean hecho = false;

    public void hacerTrabajo() {
        System.out.println("Haciendo trabajo...");
        hecho = true;
    }

    public void comprobarTrabajo() {
        while (!hecho) {
            // Espera a que el trabajo esté hecho
        }
        System.out.println("Trabajo completado.");
    }

    public static void main(String[] args) {
        InconsistenciaMemoriaCorregido ejemplo = new InconsistenciaMemoriaCorregido();

        Thread hilo1 = new Thread(() -> {
            ejemplo.hacerTrabajo();
        });

        Thread hilo2 = new Thread(() -> {
            ejemplo.comprobarTrabajo();
        });

        hilo1.start();
        hilo2.start();
    }
}
