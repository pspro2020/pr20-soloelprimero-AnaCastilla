import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Task {

    private final int randomNumber;
    private final int[][] matriz;

    public Task(int[][] matriz, int randomNumber) {
        this.matriz = matriz;
        this.randomNumber = randomNumber;
    }


    public boolean findNumber(int[][] matriz, int randomNumber) throws InterruptedException {
        double searchDuration = ThreadLocalRandom.current().nextInt(1) + 0.5;
        System.out.print("Searching...\n");
        boolean found = false;
        final int limitNumber = 10;

        if (randomNumber > limitNumber) {
            System.out.println("Número no válido");
        } else {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length || !found; j++) {
                    if (matriz[i][j] == randomNumber) {
                        search(searchDuration);
                        System.out.printf("Número encontrado en la posición [%d][%d]\n", i, j);
                        found = true;
                    }
                }
            }

            if (found) {
                System.out.printf("Number found in %.2f seconds\n", searchDuration);
            } else {
                System.out.printf("Number not found in %.2f seconds\n", searchDuration);
            }
        }

        return found;
    }


    private void search(double searchDuration) throws InterruptedException {
        try {
            TimeUnit.SECONDS.sleep((long) searchDuration);
        } catch (InterruptedException e) {
            System.out.print("Local database -> Authentication cancelled\n");
            throw new InterruptedException();
        }
    }

}


