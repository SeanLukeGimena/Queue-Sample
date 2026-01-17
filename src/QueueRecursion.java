import java.util.LinkedList;

public class QueueRecursion {

    /**
     * Recursively reverse a queue
     * This operation removes all elements and re-inserts them in reverse order
     * 
     * Time Complexity: O(n) where n is the number of elements
     * Space Complexity: O(n) due to recursive call stack
     */
    public static void reverseQueue(LinkedList<Integer> queue) {
        // Base case: if queue is empty, return
        if (queue.isEmpty()) {
            return;
        }

        // Remove the front element
        int front = queue.removeFirst();

        // Recursively reverse the remaining queue
        reverseQueue(queue);

        // Add the removed element to the rear
        queue.addLast(front);
    }

    /**
     * Recursively search for an element in the queue
     * 
     * @param queue the queue to search
     * @param target the element to search for
     * @return true if element is found, false otherwise
     */
    public static boolean recursiveSearch(LinkedList<Integer> queue, int target) {
        // Base case: queue is empty
        if (queue.isEmpty()) {
            return false;
        }

        // Check the front element
        if (queue.getFirst() == target) {
            return true;
        }

        // Remove the front element temporarily
        int front = queue.removeFirst();

        // Recursively search the rest
        boolean found = recursiveSearch(queue, target);

        // Add the element back to maintain queue structure
        queue.addFirst(front);

        return found;
    }

    /**
     * Recursively print queue elements in order
     * Time Complexity: O(n)
     * Space Complexity: O(n) due to recursive call stack
     */
    public static void recursivePrint(LinkedList<Integer> queue) {
        // Base case
        if (queue.isEmpty()) {
            return;
        }

        // Remove and print the front element
        int front = queue.removeFirst();
        System.out.print(front + " ");

        // Recursively print the rest
        recursivePrint(queue);

        // Add the element back
        queue.addLast(front);
    }

    /**
     * Recursively print queue elements in reverse order
     * Time Complexity: O(n)
     * Space Complexity: O(n) due to recursive call stack
     */
    public static void recursivePrintReverse(LinkedList<Integer> queue) {
        // Base case
        if (queue.isEmpty()) {
            return;
        }

        // Remove the front element
        int front = queue.removeFirst();

        // Recursively print the rest first
        recursivePrintReverse(queue);

        // Then print the current element (reverse order)
        System.out.print(front + " ");

        // Add the element back
        queue.addLast(front);
    }

    /**
     * Recursively find the maximum element in the queue
     * 
     * @param queue the queue to search
     * @return the maximum element
     */
    public static int findMax(LinkedList<Integer> queue) {
        // Base case: only one element
        if (queue.size() == 1) {
            return queue.getFirst();
        }

        // Remove the front element
        int front = queue.removeFirst();

        // Find max in the remaining queue
        int maxRest = findMax(queue);

        // Add the element back
        queue.addFirst(front);

        // Return the maximum
        return Math.max(front, maxRest);
    }

    /**
     * Recursively find the minimum element in the queue
     * 
     * @param queue the queue to search
     * @return the minimum element
     */
    public static int findMin(LinkedList<Integer> queue) {
        // Base case: only one element
        if (queue.size() == 1) {
            return queue.getFirst();
        }

        // Remove the front element
        int front = queue.removeFirst();

        // Find min in the remaining queue
        int minRest = findMin(queue);

        // Add the element back
        queue.addFirst(front);

        // Return the minimum
        return Math.min(front, minRest);
    }

    /**
     * Recursively calculate the sum of all elements in the queue
     * 
     * @param queue the queue to process
     * @return the sum of all elements
     */
    public static int recursiveSum(LinkedList<Integer> queue) {
        // Base case: empty queue
        if (queue.isEmpty()) {
            return 0;
        }

        // Remove the front element
        int front = queue.removeFirst();

        // Recursively calculate the sum of remaining elements
        int sum = front + recursiveSum(queue);

        // Add the element back
        queue.addFirst(front);

        return sum;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Queue with Recursive Operations ===\n");

        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(10);
        queue.addLast(20);
        queue.addLast(30);
        queue.addLast(40);
        queue.addLast(50);

        System.out.println("--- Original Queue ---");
        System.out.print("Queue: ");
        recursivePrint(queue);
        System.out.println("\n");

        System.out.println("--- Recursive Print in Reverse Order ---");
        System.out.print("Reversed: ");
        recursivePrintReverse(queue);
        System.out.println("\n");

        System.out.println("--- Recursive Search ---");
        System.out.println("Search for 30: " + recursiveSearch(queue, 30));
        System.out.println("Search for 100: " + recursiveSearch(queue, 100));
        System.out.println("Search for 10: " + recursiveSearch(queue, 10));

        System.out.println("\n--- Recursive Find Min and Max ---");
        System.out.println("Minimum element: " + findMin(queue));
        System.out.println("Maximum element: " + findMax(queue));

        System.out.println("\n--- Recursive Sum ---");
        System.out.println("Sum of all elements: " + recursiveSum(queue));

        System.out.println("\n--- Queue Before Reverse ---");
        System.out.print("Queue: ");
        recursivePrint(queue);
        System.out.println();

        System.out.println("\n--- Reverse Queue ---");
        reverseQueue(queue);
        System.out.print("Reversed Queue: ");
        recursivePrint(queue);
        System.out.println("\n");
    }
}
