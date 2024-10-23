package BloqueoActivo;

public class BloqueoActivo {
    private static boolean hilo1Trabaja = true;
    private static boolean hilo2Trabaja = true;

    public static void main(String[] args) {
        Thread hilo1 = new Thread(() -> {
            while (hilo1Trabaja) {
                if (!hilo2Trabaja) {
                    System.out.println("Hilo 1 hace trabajo.");
                    hilo1Trabaja = false;
                }
            }
        });

        Thread hilo2 = new Thread(() -> {
            while (hilo2Trabaja) {
                if (!hilo1Trabaja) {
                    System.out.println("Hilo 2 hace trabajo.");
                    hilo2Trabaja = false;
                }
            }
        });

        hilo1.start();
        hilo2.start();
    }
}
