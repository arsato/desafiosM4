package cl.praxis.desafios.reciclajeans;

public class Utils {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearScreenFalse() {
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
