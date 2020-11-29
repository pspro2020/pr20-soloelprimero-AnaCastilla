import java.util.concurrent.Callable;

public class FindTask implements Callable<Task> {

    private final Task task;
    private final int randomNumber;
    private final int[][] matriz;

    FindTask(Task task, int[][] matriz, int randomNumber) {
        this.task = task;
        this.matriz = matriz;
        this.randomNumber = randomNumber;
    }

    @Override
    public Task call() throws InterruptedException {
        boolean search = task.findNumber(matriz, randomNumber);
        if (!search) {
            throw new RuntimeException("Search failed");
        }
        return task;
    }


}
