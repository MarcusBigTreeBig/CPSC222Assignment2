package Semaphores;

import java.io.FileWriter;

/**
 * Semaphore that contains a certain amount of files that can be written to
 * Implemented using a stack that threads can directly pull files out of and push into
 * Each of the files are of the FileWriter class
 */

public class MultiFileSemaphore {
    private ThreadQueue q;
    private FileStack files;

    /**
     * creates a semaphore
     * Starts with no files in the stack
     * Starts with no threads waiting to access a file
     */
    public MultiFileSemaphore () {
        q = new ThreadQueue();
        files = new FileStack();
    }

    /**
     * pushes a file onto the stack containing the files
     *
     * @param file the file to be pushed
     */
    public synchronized void giveFile (FileWriter file) {
        files.push(file);
    }

    /**
     * takes a file from the stack
     *
     * @return the file taken
     */
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

    /**
     * Implements the queue where threads can wait to access the files
     */
    private class ThreadQueue {

        private ThreadNode front;
        private ThreadNode rear;

        /**
         *
         * @param t adds this thread to the queue
         */
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

        /**
         *
         * @return a thread taken from the queue
         */
        public Thread dequeue () {
            if (front == null) {
                return null;
            }
            ThreadNode n = front;
            front = front.previous;
            front.next = null;
            return n.thread;
        }

        /**
         * Stores threads in a node that can be used for the queue
         */
        private class ThreadNode {
            private ThreadNode next;
            private ThreadNode previous;
            private Thread thread;
        }
    }

    /**
     * Implements the class that can be used to store the files in the semaphore
     */
    private class FileStack {

        private FileNode top;

        /**
         *
         * @param file is pushed to the stack
         */
        public void push (FileWriter file) {
            FileNode f = new FileNode();
            f.file = file;
            if (top != null) {
                f.next = top;
            }
            top = f;
        }

        /**
         *
         * @return the file taken from the stack
         */
        public FileWriter pop () {
            FileNode f = top;
            top = top.next;
            return f.file;
        }

        /**
         * Stores the files in a node that can be used for the stack
         */
        private class FileNode {
            private FileNode next;
            private FileWriter file;
        }
    }
}
