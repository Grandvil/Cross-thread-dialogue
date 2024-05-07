public class Main {

    public static void main(String[] args) {
        ThreadGroup mainGroup = new ThreadGroup("main group");

        final Thread flowOne = new MyThread(mainGroup, "поток 1");
        final Thread flowTwo = new MyThread(mainGroup, "поток 2");
        final Thread flowThree = new MyThread(mainGroup, "поток 3");
        final Thread flowFour = new MyThread(mainGroup, "поток 4");

        System.out.println("Создаю потоки...");
        flowOne.start();
        flowTwo.start();
        flowThree.start();
        flowFour.start();

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Завершаю все потоки.");
        mainGroup.interrupt();
    }
}
