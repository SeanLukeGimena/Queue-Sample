public class BasicQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    // Constructor to initialize the queue with a given capacity
    public BasicQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    /**
     * Enqueue - Add an element to the rear of the queue
     * Time Complexity: O(1)
     * 
     * @param element the element to be added
     */
    public void enqueue(int element) {
        if (size == capacity) {
            System.out.println("Queue is full! Cannot enqueue " + element);
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = element;
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
        if (size == 0) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        }
        int element = queue[front];
        front = (front + 1) % capacity;
        size--;
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
        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return queue[front];
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
     * Check if the queue is full
     * 
     * @return true if queue is full, false otherwise
     */
    public boolean isFull() {
        return size == capacity;
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
        if (size == 0) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements (front to rear): ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Basic Queue Implementation (Array-based) ===\n");

        BasicQueue queue = new BasicQueue(5);

        System.out.println("--- Enqueue Operations ---");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.display();
        System.out.println("Queue size: " + queue.getSize());
        System.out.println("Front element (Peek): " + queue.peek());

        System.out.println("\n--- Dequeue Operations ---");
        queue.dequeue();
        queue.dequeue();
        queue.display();
        System.out.println("Queue size: " + queue.getSize());

        System.out.println("\n--- Additional Enqueue After Dequeue ---");
        queue.enqueue(60);
        queue.enqueue(70);
        queue.display();

        System.out.println("\n--- Full Queue Test ---");
        if (queue.isFull()) {
            System.out.println("Queue is full!");
        }
        queue.enqueue(80); // This will fail as queue is full

        System.out.println("\n--- Empty Queue Test ---");
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
        queue.dequeue(); // This will show empty queue message
    }
}
