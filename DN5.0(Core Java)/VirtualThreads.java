import java.util.concurrent.*;

public class VirtualThreads {

    static Runnable task = () -> {
        System.out.println(Thread.currentThread());
    };

    public static void main(String[] args) throws Exception {

        int count = 100000;

        long startVirtual = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            Thread.startVirtualThread(task);
        }

        long endVirtual = System.currentTimeMillis();

        System.out.println("Virtual Threads Time: " + (endVirtual - startVirtual) + " ms");

        Thread.sleep(2000);

        ExecutorService executor = Executors.newFixedThreadPool(100);

        long startPlatform = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            executor.submit(task);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        long endPlatform = System.currentTimeMillis();
        System.out.println("Platform Threads Time: " + (endPlatform - startPlatform) + " ms");
    }
}