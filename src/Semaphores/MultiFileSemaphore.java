package Semaphores;

import java.io.FileWriter;

public class MultiFileSemaphore {
    private ThreadQueue q;
    private FileStack files;
    public MultiFileSemaphore () {
        q = new ThreadQueue();
        files = new FileStack();
    }

    public synchronized void giveFile (FileWriter file) {
        files.push(file);
    }
    public synchronized FileWriter takeFile () {
        while (files.top == null) {
            try {
                wait();
            }
            catch (InterruptedException e) {

            }
        }
        return files.pop();
    }

    private class ThreadQueue {

        private ThreadNode front;
        private ThreadNode rear;

        public void enqueue (Thread t) {
            ThreadNode n = new ThreadNode();
            if (rear != null) {
                rear.previous = n;
            }
            n.next = rear;
            rear = n;
            if (front == null) {
                front = n;
            }
        }
        public Thread dequeue () {
            if (front == null) {
                return null;
            }
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
    private class FileStack {

        private FileNode top;

        public void push (FileWriter file) {
            FileNode f = new FileNode();
            f.file = file;
            if (top != null) {
                f.next = top;
            }
            top = f;
        }

        public FileWriter pop () {
            FileNode f = top;
            top = top.next;
            return f.file;
        }

        private class FileNode {
            private FileNode next;
            private FileWriter file;
        }
    }
}
