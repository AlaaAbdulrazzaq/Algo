package NB7;

public class Main {
    public static void main(String[] args) {
        NB7<Integer> stack = new NB7<Integer>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Peek at the top element
        System.out.println("Peeked element: " + stack.peek());

        // Pop elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        // Check if the stack is empty
        System.out.println("Is the stack empty? " + stack.empty());

        // Peek at Nth element
        System.out.println("Peek at index 0: " + stack.peek(0));
        System.out.println("Peek at index 1: " + stack.peek(1));

        // Flush the stack
        System.out.println("Flushed. Last element: " + stack.flush());

        // Check if the stack is empty after flushing
        System.out.println("Is the stack empty? " + stack.empty());
    }
}