package BloqueoActivo;

public class BloqueoActivoCorregido {
    private static boolean hilo1Trabaja = true;
    private static boolean hilo2Trabaja = true;

    public static void main(String[] args) {
        Thread hilo1 = new Thread(() -> {
            while (true) {
                if (hilo2Trabaja) {
                    System.out.println("Hilo 1 cede el turno.");
                    hilo1Trabaja = true;
                    hilo2Trabaja = false;
                } else {
                    System.out.println("Hilo 1 hace trabajo.");
                    break;
                }
                try {
                    Thread.sleep((long) (Math.random() * 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread hilo2 = new Thread(() -> {
            while (true) {
                if (hilo1Trabaja) {
                    System.out.println("Hilo 2 cede el turno.");
                    hilo2Trabaja = true;
                    hilo1Trabaja = false;
                } else {
                    System.out.println("Hilo 2 hace trabajo.");
                    break;
                }
                try {
                    Thread.sleep((long) (Math.random() * 500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        hilo1.start();
        hilo2.start();
    }
}
