package F3.NB5;

public class Main {
    public static void main(String[] args) {
        NB5<Integer> stack = new NB5<>();

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
    }
}
