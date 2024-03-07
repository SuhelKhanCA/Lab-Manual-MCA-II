import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadedProcessor<T> { // Q3
    private List<T> elements;

    public ThreadedProcessor(List<T> elements) {
        this.elements = elements;
    }

    public void processElements(ProcessorTask<T> task) {
        ExecutorService executor = Executors.newFixedThreadPool(elements.size());

        for (T element : elements) {
            executor.submit(() -> task.process(element));
        }

        executor.shutdown();
    }

    // Other methods specific to the type T can be added here
}

interface ProcessorTask<T> {
    void process(T element);
}

public class Q3 {
    public static void main(String[] args) {
        // Example usage
        List<Integer> intList = List.of(1, 2, 3, 4, 5);
        ThreadedProcessor<Integer> intProcessor = new ThreadedProcessor<>(intList);

        intProcessor.processElements(element -> {
            // Perform some computation or transformation on each integer element
            System.out.println("Processed integer: " + element);
        });

        List<String> stringList = List.of("Hello", "World", "Java", "Threads");
        ThreadedProcessor<String> stringProcessor = new ThreadedProcessor<>(stringList);

        stringProcessor.processElements(element -> {
            // Perform some operation on each string element (e.g., concatenation)
            System.out.println("Processed string: " + element.toUpperCase());
        });
    }
}
