import java.util.concurrent.*;

class Task implements Callable<Integer> {

    private int number;

    public Task(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {

        System.out.println("Executing task: " + number);

        // simulate work
        Thread.sleep(1000);

        return number * number; // return result
    }
}

public class ExecutorCallable{

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<Integer> f1 = executor.submit(new Task(2));
        Future<Integer> f2 = executor.submit(new Task(3));
        Future<Integer> f3 = executor.submit(new Task(4));

        try {
            System.out.println("Result 1: " + f1.get());
            System.out.println("Result 2: " + f2.get());
            System.out.println("Result 3: " + f3.get());

        } catch (Exception e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}