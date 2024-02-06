package Semaphores;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MultiFileSemaphore {
    private ThreadQueue q;
    private ArrayList<PrintWriter> files;
    public MultiFileSemaphore (ArrayList<PrintWriter> files) {
        q = new ThreadQueue();
        this.files = files;
    }


    private class ThreadQueue {

        private ThreadNode front;
        private ThreadNode rear;

        public void enqueue (Thread t) {
            ThreadNode n = new ThreadNode();
            rear.previous = n;
            n.next = rear;
            rear = n;
        }
        public Thread dequeue () {
            ThreadNode n = front;
            front = front.previous;
            front.next = null;
            return n.thread;
        }

        private class ThreadNode {
            private ThreadNode next;
            private ThreadNode previous;
            private Thread thread;
        }
    }
}
