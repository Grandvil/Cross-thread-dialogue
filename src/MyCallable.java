import java.util.concurrent.Callable;

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        String threadName = Thread.currentThread().getName();
        int messageCount = 0;

        while (messageCount < 10) {
            System.out.printf("Я %s. Всем привет!\n", threadName);
            messageCount++;
            Thread.sleep(2500);
        }
        return messageCount;
    }
}