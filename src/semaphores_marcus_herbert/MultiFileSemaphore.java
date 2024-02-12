package semaphores_marcus_herbert;

import java.io.FileWriter;

/**
 * Semaphore that contains a certain amount of files that can be written to
 * Implemented using a stack that threads can directly pull files out of and push into
 * Each of the files are of the FileWriter class
 */

public class MultiFileSemaphore {
    private FileStack files;

    /**
     * creates a semaphore
     * Starts with no files in the stack
     * Starts with no threads waiting to access a file
     */
    public MultiFileSemaphore () {
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
