import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(availableProcessors);
        int randomNumber = ThreadLocalRandom.current().nextInt(20)+1;
        int[][] matriz = new int[5][5];
        Task task = new Task(matriz, randomNumber);
        FindTask findTask = new FindTask(task, matriz, randomNumber);
        List<FindTask> findTasks = new ArrayList<>();
        findTasks.add(findTask);
        final int taskNumber = 5;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = ThreadLocalRandom.current().nextInt(10) + 1;
            }
        }

        System.out.println("MATRIZ CREADA");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("Fila "+ (i+1) + " - ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.println("");
        }

        for (int i = 0; i < taskNumber; i++) {
            findTasks.add(new FindTask(task, matriz, randomNumber));
        }


        System.out.println("Número a buscar: " + randomNumber);

        try {
            Task tasks = fixedThreadPool.invokeAny(findTasks);

        } catch (InterruptedException | ExecutionException ignored) {
        } finally {
            fixedThreadPool.shutdown();
        }
    }
}
