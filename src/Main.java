import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        System.out.println("Создаю потоки...");

        // Результат выполнения всех задач
        int threadCount = 4;
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            futures.add(executorService.submit(new MyCallable()));
        }

        try {
            executorService.awaitTermination(30, TimeUnit.SECONDS);
            System.out.println("Получаю результаты...");
            int messageCount = 0;
            for (Future<Integer> future : futures) {
                messageCount += future.get();
            }
            System.out.println("Всего напечатано " + messageCount + " сообщений!");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }

        // Результат от одной из задач (самой быстрой) - расскоментировать
//        try {
//            List<Callable<Integer>> tasks = Arrays.asList(new MyCallable(), new MyCallable(), new MyCallable(), new MyCallable());
//            int messageCount = executorService.invokeAny(tasks);
//            executorService.awaitTermination(30, TimeUnit.SECONDS);
//            System.out.println("Получаю результат от самой быстрой задачи...");
//            System.out.printf("Самая быстрая задача отправила %d сообщений\n", messageCount);
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        } finally {
//            executorService.shutdown();
//        }
    }
}
