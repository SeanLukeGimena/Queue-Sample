import java.util.LinkedList;

public class QueueSearch {

    /**
     * Linear Search - Basic search through queue
     * This is DISRUPTIVE as it modifies the original queue
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * 
     * @param queue the queue to search
     * @param target the element to find
     * @return true if found, false otherwise
     */
    public static boolean linearSearchDisruptive(LinkedList<Integer> queue, int target) {
        System.out.println("Performing disruptive linear search for: " + target);
        
        while (!queue.isEmpty()) {
            int element = queue.removeFirst();
            if (element == target) {
                System.out.println("Element " + target + " found!");
                // Note: Queue is now modified
                return true;
            }
        }
        
        System.out.println("Element " + target + " not found!");
        return false;
    }

    /**
     * Linear Search - Non-disruptive search through queue
     * This preserves the original queue structure
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n) for temporary storage
     * 
     * @param queue the queue to search
     * @param target the element to find
     * @return true if found, false otherwise
     */
    public static boolean linearSearchNonDisruptive(LinkedList<Integer> queue, int target) {
        System.out.println("Performing non-disruptive linear search for: " + target);
        
        LinkedList<Integer> tempQueue = new LinkedList<>();
        boolean found = false;

        // Transfer elements to temp queue while searching
        while (!queue.isEmpty()) {
            int element = queue.removeFirst();
            if (element == target) {
                found = true;
                System.out.println("Element " + target + " found!");
            }
            tempQueue.addLast(element);
        }

        // Restore original queue
        while (!tempQueue.isEmpty()) {
            queue.addLast(tempQueue.removeFirst());
        }

        if (!found) {
            System.out.println("Element " + target + " not found!");
        }

        return found;
    }

    /**
     * Search with position tracking
     * Returns the position of the element in the queue (0-based)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param queue the queue to search
     * @param target the element to find
     * @return position if found, -1 otherwise
     */
    public static int findPosition(LinkedList<Integer> queue, int target) {
        System.out.println("Finding position of: " + target);
        
        LinkedList<Integer> tempQueue = new LinkedList<>();
        int position = 0;
        int targetPosition = -1;

        while (!queue.isEmpty()) {
            int element = queue.removeFirst();
            if (element == target) {
                targetPosition = position;
            }
            tempQueue.addLast(element);
            position++;
        }

        // Restore original queue
        while (!tempQueue.isEmpty()) {
            queue.addLast(tempQueue.removeFirst());
        }

        if (targetPosition != -1) {
            System.out.println("Element found at position: " + targetPosition);
        } else {
            System.out.println("Element not found!");
        }

        return targetPosition;
    }

    /**
     * Search and count occurrences of an element
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param queue the queue to search
     * @param target the element to find
     * @return count of occurrences
     */
    public static int countOccurrences(LinkedList<Integer> queue, int target) {
        System.out.println("Counting occurrences of: " + target);
        
        LinkedList<Integer> tempQueue = new LinkedList<>();
        int count = 0;

        while (!queue.isEmpty()) {
            int element = queue.removeFirst();
            if (element == target) {
                count++;
            }
            tempQueue.addLast(element);
        }

        // Restore original queue
        while (!tempQueue.isEmpty()) {
            queue.addLast(tempQueue.removeFirst());
        }

        System.out.println("Found " + count + " occurrence(s)");
        return count;
    }

    /**
     * Search for multiple elements
     * 
     * Time Complexity: O(n * m) where m is number of targets
     * Space Complexity: O(n)
     * 
     * @param queue the queue to search
     * @param targets array of elements to find
     */
    public static void searchMultiple(LinkedList<Integer> queue, int[] targets) {
        System.out.println("Searching for multiple elements: " + java.util.Arrays.toString(targets));
        
        for (int target : targets) {
            findPosition(queue, target);
        }
    }

    /**
     * Display queue elements without modifying it
     * 
     * @param queue the queue to display
     */
    public static void displayQueue(LinkedList<Integer> queue) {
        System.out.print("Queue: ");
        for (int element : queue) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Queue Search Operations ===\n");

        LinkedList<Integer> queue1 = new LinkedList<>();
        queue1.addLast(15);
        queue1.addLast(25);
        queue1.addLast(35);
        queue1.addLast(45);
        queue1.addLast(55);

        System.out.println("--- Original Queue ---");
        displayQueue(queue1);

        System.out.println("\n--- Non-Disruptive Linear Search ---");
        linearSearchNonDisruptive(queue1, 35);
        displayQueue(queue1);

        System.out.println("\n--- Find Position ---");
        findPosition(queue1, 45);
        displayQueue(queue1);

        System.out.println("\n--- Find Position (Not Found) ---");
        findPosition(queue1, 100);
        displayQueue(queue1);

        System.out.println("\n--- Count Occurrences ---");
        LinkedList<Integer> queue2 = new LinkedList<>();
        queue2.addLast(10);
        queue2.addLast(20);
        queue2.addLast(10);
        queue2.addLast(30);
        queue2.addLast(10);
        queue2.addLast(40);

        displayQueue(queue2);
        countOccurrences(queue2, 10);
        displayQueue(queue2);

        System.out.println("\n--- Search Multiple Elements ---");
        int[] targets = {20, 10, 50, 30};
        searchMultiple(queue2, targets);

        System.out.println("\n--- Disruptive Linear Search (Empties Queue) ---");
        LinkedList<Integer> queue3 = new LinkedList<>();
        queue3.addLast(5);
        queue3.addLast(10);
        queue3.addLast(15);
        queue3.addLast(20);

        displayQueue(queue3);
        linearSearchDisruptive(queue3, 15);
        displayQueue(queue3);
        System.out.println("Queue is now empty due to disruptive search!");
    }
}
