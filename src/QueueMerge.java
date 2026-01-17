import java.util.LinkedList;

public class QueueMerge {

    /**
     * Simple merge of two queues
     * Combines elements from both queues into a new queue
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     * 
     * @param queue1 first queue
     * @param queue2 second queue
     * @return merged queue
     */
    public static LinkedList<Integer> mergeQueues(LinkedList<Integer> queue1, LinkedList<Integer> queue2) {
        System.out.println("Merging two queues...");
        
        LinkedList<Integer> mergedQueue = new LinkedList<>();

        // Add all elements from first queue
        while (!queue1.isEmpty()) {
            mergedQueue.addLast(queue1.removeFirst());
        }

        // Add all elements from second queue
        while (!queue2.isEmpty()) {
            mergedQueue.addLast(queue2.removeFirst());
        }

        System.out.println("Merge completed!");
        return mergedQueue;
    }

    /**
     * Merge two queues without modifying originals
     * Creates copies and merges them
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     * 
     * @param queue1 first queue
     * @param queue2 second queue
     * @return merged queue
     */
    public static LinkedList<Integer> mergQueuesNonDestructive(LinkedList<Integer> queue1, LinkedList<Integer> queue2) {
        System.out.println("Merging two queues (non-destructive)...");
        
        LinkedList<Integer> mergedQueue = new LinkedList<>();

        // Add all elements from first queue (non-destructive)
        for (int element : queue1) {
            mergedQueue.addLast(element);
        }

        // Add all elements from second queue (non-destructive)
        for (int element : queue2) {
            mergedQueue.addLast(element);
        }

        System.out.println("Merge completed!");
        return mergedQueue;
    }

    /**
     * Merge two sorted queues into a single sorted queue
     * Assumes both input queues are already sorted
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     * 
     * @param queue1 first sorted queue
     * @param queue2 second sorted queue
     * @return merged sorted queue
     */
    public static LinkedList<Integer> mergeSortedQueues(LinkedList<Integer> queue1, LinkedList<Integer> queue2) {
        System.out.println("Merging two sorted queues...");
        
        LinkedList<Integer> mergedQueue = new LinkedList<>();
        
        // Create copies to avoid modifying originals
        LinkedList<Integer> temp1 = new LinkedList<>(queue1);
        LinkedList<Integer> temp2 = new LinkedList<>(queue2);

        while (!temp1.isEmpty() || !temp2.isEmpty()) {
            if (temp1.isEmpty()) {
                mergedQueue.addLast(temp2.removeFirst());
            } else if (temp2.isEmpty()) {
                mergedQueue.addLast(temp1.removeFirst());
            } else {
                // Compare front elements and add smaller one
                if (temp1.getFirst() <= temp2.getFirst()) {
                    mergedQueue.addLast(temp1.removeFirst());
                } else {
                    mergedQueue.addLast(temp2.removeFirst());
                }
            }
        }

        System.out.println("Sorted merge completed!");
        return mergedQueue;
    }

    /**
     * Merge multiple queues into a single queue
     * 
     * Time Complexity: O(n1 + n2 + ... + nk)
     * Space Complexity: O(n1 + n2 + ... + nk)
     * 
     * @param queues array of queues to merge
     * @return merged queue
     */
    public static LinkedList<Integer> mergeMultipleQueues(LinkedList<Integer>[] queues) {
        System.out.println("Merging " + queues.length + " queues...");
        
        LinkedList<Integer> mergedQueue = new LinkedList<>();

        for (LinkedList<Integer> queue : queues) {
            for (int element : queue) {
                mergedQueue.addLast(element);
            }
        }

        System.out.println("Merge of " + queues.length + " queues completed!");
        return mergedQueue;
    }

    /**
     * Merge queues with interleaving pattern
     * Alternates between queues when merging
     * 
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     * 
     * @param queue1 first queue
     * @param queue2 second queue
     * @return merged queue with interleaved elements
     */
    public static LinkedList<Integer> mergeInterleaved(LinkedList<Integer> queue1, LinkedList<Integer> queue2) {
        System.out.println("Merging with interleave pattern...");
        
        LinkedList<Integer> mergedQueue = new LinkedList<>();
        LinkedList<Integer> temp1 = new LinkedList<>(queue1);
        LinkedList<Integer> temp2 = new LinkedList<>(queue2);

        // Alternate taking elements from both queues
        while (!temp1.isEmpty() || !temp2.isEmpty()) {
            if (!temp1.isEmpty()) {
                mergedQueue.addLast(temp1.removeFirst());
            }
            if (!temp2.isEmpty()) {
                mergedQueue.addLast(temp2.removeFirst());
            }
        }

        System.out.println("Interleaved merge completed!");
        return mergedQueue;
    }

    /**
     * Display queue elements
     * 
     * @param queue the queue to display
     * @param label label for display
     */
    public static void displayQueue(LinkedList<Integer> queue, String label) {
        System.out.print(label + ": ");
        for (int element : queue) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Queue Merge Operations ===\n");

        // Test 1: Simple merge
        System.out.println("--- Test 1: Simple Merge ---");
        LinkedList<Integer> q1 = new LinkedList<>();
        q1.addLast(1);
        q1.addLast(2);
        q1.addLast(3);

        LinkedList<Integer> q2 = new LinkedList<>();
        q2.addLast(4);
        q2.addLast(5);
        q2.addLast(6);

        displayQueue(q1, "Queue 1");
        displayQueue(q2, "Queue 2");

        LinkedList<Integer> merged = mergeQueues(q1, q2);
        displayQueue(merged, "Merged Queue");

        // Test 2: Non-destructive merge
        System.out.println("\n--- Test 2: Non-Destructive Merge ---");
        LinkedList<Integer> q3 = new LinkedList<>();
        q3.addLast(10);
        q3.addLast(20);
        q3.addLast(30);

        LinkedList<Integer> q4 = new LinkedList<>();
        q4.addLast(40);
        q4.addLast(50);

        displayQueue(q3, "Queue 3");
        displayQueue(q4, "Queue 4");

        LinkedList<Integer> merged2 = mergQueuesNonDestructive(q3, q4);
        displayQueue(q3, "Queue 3 (after merge)");
        displayQueue(q4, "Queue 4 (after merge)");
        displayQueue(merged2, "Merged Queue");

        // Test 3: Merge sorted queues
        System.out.println("\n--- Test 3: Merge Sorted Queues ---");
        LinkedList<Integer> sorted1 = new LinkedList<>();
        sorted1.addLast(1);
        sorted1.addLast(3);
        sorted1.addLast(5);
        sorted1.addLast(7);

        LinkedList<Integer> sorted2 = new LinkedList<>();
        sorted2.addLast(2);
        sorted2.addLast(4);
        sorted2.addLast(6);
        sorted2.addLast(8);

        displayQueue(sorted1, "Sorted Queue 1");
        displayQueue(sorted2, "Sorted Queue 2");

        LinkedList<Integer> mergedSorted = mergeSortedQueues(sorted1, sorted2);
        displayQueue(mergedSorted, "Merged Sorted Queue");

        // Test 4: Interleaved merge
        System.out.println("\n--- Test 4: Interleaved Merge ---");
        LinkedList<Integer> q5 = new LinkedList<>();
        q5.addLast(1);
        q5.addLast(2);
        q5.addLast(3);

        LinkedList<Integer> q6 = new LinkedList<>();
        q6.addLast(10);
        q6.addLast(20);

        displayQueue(q5, "Queue 5");
        displayQueue(q6, "Queue 6");

        LinkedList<Integer> mergedInterleaved = mergeInterleaved(q5, q6);
        displayQueue(mergedInterleaved, "Interleaved Merged Queue");

        // Test 5: Merge multiple queues
        System.out.println("\n--- Test 5: Merge Multiple Queues ---");
        @SuppressWarnings("unchecked")
        LinkedList<Integer>[] queues = new LinkedList[3];
        queues[0] = new LinkedList<>();
        queues[0].addLast(1);
        queues[0].addLast(2);

        queues[1] = new LinkedList<>();
        queues[1].addLast(3);
        queues[1].addLast(4);

        queues[2] = new LinkedList<>();
        queues[2].addLast(5);
        queues[2].addLast(6);

        for (int i = 0; i < queues.length; i++) {
            displayQueue(queues[i], "Queue " + (i + 1));
        }

        LinkedList<Integer> mergedMultiple = mergeMultipleQueues(queues);
        displayQueue(mergedMultiple, "Merged Multiple Queues");
    }
}
