package Semaphores;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MultiFileSemaphore {
    private ThreadQueue q;
    private FileStack files;
    public MultiFileSemaphore (FileStack files) {
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
    private class FileStack {

        private FileNode top;

        public void push (PrintWriter file) {
            FileNode f = new FileNode();
            f.file = file;
            if (top != null) {
                f.next = top;
            }
            top = f;
        }

        public PrintWriter pop () {
            FileNode f = top;
            top = top.next;
            return f.file;
        }

        private class FileNode {
            private FileNode next;
            private PrintWriter file;
        }
    }
}
