
//PART 2

public class Stack<T> extends LinkedList<T> {

    public void push(T item) {
        addFirst(item); // Pushes item to the top of the stack
    }

    public T pop() {
        if (getSize() == 0) {
            throw new java.util.NoSuchElementException("Stack is empty");
        }
        T item = get(0); // Retrieves the first element (top of the stack)
        remove(0); // Removes the top of the stack
        return item;
    }
}

class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Test case 1: Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("After pushing 1, 2, 3: " + stack); // Expected: 3, 2, 1

        // Test case 2: Pop elements from the stack
        System.out.println("Popped: " + stack.pop()); // Expected: 3
        System.out.println("Popped: " + stack.pop()); // Expected: 2

        // Test case 3: Stack state after multiple operations
        System.out.println("After two pops: " + stack); // Expected: 1

        // Test case 4: Push more elements
        stack.push(4);
        stack.push(5);
        System.out.println("After pushing 4, 5: " + stack); // Expected: 5, 4, 1

        // Test case 5: Pop all elements to empty the stack
        System.out.println("Popped: " + stack.pop()); // Expected: 5
        System.out.println("Popped: " + stack.pop()); // Expected: 4
        System.out.println("Popped: " + stack.pop()); // Expected: 1

        // Test case 6: Verify stack is empty and exception handling
        try {
            stack.pop(); // Expected to throw exception
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Exception caught as expected: " + e.getMessage());
        }
    }
}