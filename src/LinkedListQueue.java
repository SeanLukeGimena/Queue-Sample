public class LinkedListQueue {

    // Node class for linked list representation
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    // Constructor
    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    /**
     * Enqueue - Add an element to the rear of the queue
     * Time Complexity: O(1)
     * 
     * @param element the element to be added
     */
    public void enqueue(int element) {
        Node newNode = new Node(element);
        
        if (rear == null) {
            // Queue is empty
            front = newNode;
            rear = newNode;
        } else {
            // Add to the rear
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Enqueued: " + element);
    }

    /**
     * Dequeue - Remove and return the front element from the queue
     * Time Complexity: O(1)
     * 
     * @return the front element or -1 if queue is empty
     */
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        }

        int element = front.data;
        front = front.next;
        size--;

        // If queue becomes empty, update rear as well
        if (front == null) {
            rear = null;
        }

        System.out.println("Dequeued: " + element);
        return element;
    }

    /**
     * Peek - View the front element without removing it
     * Time Complexity: O(1)
     * 
     * @return the front element or -1 if queue is empty
     */
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return front.data;
    }

    /**
     * Check if the queue is empty
     * 
     * @return true if queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Get the current size of the queue
     * 
     * @return the number of elements in the queue
     */
    public int getSize() {
        return size;
    }

    /**
     * Display all elements in the queue
     * Time Complexity: O(n)
     */
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Queue elements (front to rear): ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Search for an element in the queue
     * Time Complexity: O(n)
     * 
     * @param element the element to search for
     * @return true if element is found, false otherwise
     */
    public boolean search(int element) {
        Node current = front;
        while (current != null) {
            if (current.data == element) {
                System.out.println("Element " + element + " found in queue");
                return true;
            }
            current = current.next;
        }
        System.out.println("Element " + element + " not found in queue");
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Queue Implementation (LinkedList-based) ===\n");

        LinkedListQueue queue = new LinkedListQueue();

        System.out.println("--- Enqueue Operations ---");
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.enqueue(400);
        queue.enqueue(500);

        queue.display();
        System.out.println("Queue size: " + queue.getSize());
        System.out.println("Front element (Peek): " + queue.peek());

        System.out.println("\n--- Dequeue Operations ---");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.display();
        System.out.println("Queue size: " + queue.getSize());

        System.out.println("\n--- Search Operations ---");
        queue.search(200);
        queue.search(100);
        queue.search(500);
        queue.search(999);

        System.out.println("\n--- Additional Operations ---");
        queue.enqueue(600);
        queue.enqueue(700);
        queue.enqueue(800);
        queue.display();
        System.out.println("Queue size: " + queue.getSize());

        System.out.println("\n--- Empty Queue Test ---");
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
        queue.peek();
        queue.dequeue();
    }
}
