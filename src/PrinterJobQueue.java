public class PrinterJobQueue {

    // PrintJob class to represent a print job
    private static class PrintJob {
        int jobId;
        String fileName;
        int pages;
        String priority;

        PrintJob(int jobId, String fileName, int pages, String priority) {
            this.jobId = jobId;
            this.fileName = fileName;
            this.pages = pages;
            this.priority = priority;
        }

        @Override
        public String toString() {
            return "JobID: " + jobId + " | File: " + fileName + " | Pages: " + pages + " | Priority: " + priority;
        }
    }

    // Node class for linked list representation
    private static class Node {
        PrintJob job;
        Node next;

        Node(PrintJob job) {
            this.job = job;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    // Constructor
    public PrinterJobQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    /**
     * Add a print job to the queue
     * Time Complexity: O(1)
     * 
     * @param job the print job to add
     */
    public void addJob(PrintJob job) {
        Node newNode = new Node(job);
        
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Added to queue: " + job);
    }

    /**
     * Process (remove) the next job from the queue
     * Time Complexity: O(1)
     * 
     * @return the next print job or null if queue is empty
     */
    public PrintJob processJob() {
        if (front == null) {
            System.out.println("No jobs in queue to process!");
            return null;
        }

        PrintJob job = front.job;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }

        System.out.println("Processing: " + job);
        return job;
    }

    /**
     * Peek at the next job without removing it
     * Time Complexity: O(1)
     * 
     * @return the next print job or null if queue is empty
     */
    public PrintJob peekNextJob() {
        if (front == null) {
            System.out.println("No jobs in queue!");
            return null;
        }
        return front.job;
    }

    /**
     * Display all jobs in the queue
     * Time Complexity: O(n)
     */
    public void displayQueue() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("\n--- Current Queue Status ---");
        Node current = front;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.job);
            current = current.next;
            position++;
        }
    }

    /**
     * Get the total number of jobs in the queue
     * 
     * @return number of jobs
     */
    public int getQueueSize() {
        return size;
    }

    /**
     * Check if queue is empty
     * 
     * @return true if queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        System.out.println("=== Printer Job Queue System ===\n");

        PrinterJobQueue printerQueue = new PrinterJobQueue();

        System.out.println("--- Adding Print Jobs ---");
        printerQueue.addJob(new PrintJob(1, "Report.pdf", 10, "Normal"));
        printerQueue.addJob(new PrintJob(2, "Presentation.pptx", 25, "High"));
        printerQueue.addJob(new PrintJob(3, "Invoice.docx", 5, "Urgent"));
        printerQueue.addJob(new PrintJob(4, "Images.zip", 50, "Normal"));
        printerQueue.addJob(new PrintJob(5, "Contract.pdf", 15, "Normal"));

        printerQueue.displayQueue();
        System.out.println("\nTotal jobs in queue: " + printerQueue.getQueueSize());

        System.out.println("\n--- Processing Jobs ---");
        System.out.println("Next job to process: " + printerQueue.peekNextJob());
        printerQueue.processJob();
        System.out.println("Remaining jobs: " + printerQueue.getQueueSize());

        printerQueue.displayQueue();

        System.out.println("\n--- Processing More Jobs ---");
        printerQueue.processJob();
        printerQueue.processJob();
        printerQueue.displayQueue();

        System.out.println("\n--- Adding More Jobs ---");
        printerQueue.addJob(new PrintJob(6, "Budget.xlsx", 8, "High"));
        printerQueue.addJob(new PrintJob(7, "Memo.txt", 2, "Normal"));

        printerQueue.displayQueue();

        System.out.println("\n--- Process Remaining Jobs ---");
        while (!printerQueue.isEmpty()) {
            printerQueue.processJob();
        }

        printerQueue.displayQueue();
    }
}
