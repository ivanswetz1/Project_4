
//PART 3

public class Queue<T> extends LinkedList<T> {

    public void enqueue(T item) {
        add(item); // Adds item to the end of the queue
    }

    public T dequeue() {
        if (getSize() == 0) {
            throw new java.util.NoSuchElementException("Queue is empty");
        }
        T item = get(0); // Retrieves the first element (front of the queue)
        remove(0); // Removes the first element
        return item;
    }
}

class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        // Test case 1: Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("After enqueueing 1, 2, 3: " + queue); // Expected: 1, 2, 3

        // Test case 2: Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue()); // Expected: 1
        System.out.println("Dequeued: " + queue.dequeue()); // Expected: 2

        // Test case 3: Queue state after multiple operations
        System.out.println("After two dequeues: " + queue); // Expected: 3

        // Test case 4: Enqueue more elements
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("After enqueueing 4, 5: " + queue); // Expected: 3, 4, 5

        // Test case 5: Dequeue all elements to empty the queue
        System.out.println("Dequeued: " + queue.dequeue()); // Expected: 3
        System.out.println("Dequeued: " + queue.dequeue()); // Expected: 4
        System.out.println("Dequeued: " + queue.dequeue()); // Expected: 5

        // Test case 6: Verify queue is empty and exception handling
        try {
            queue.dequeue(); // Expected to throw exception
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Exception caught as expected: " + e.getMessage());
        }
    }
}
