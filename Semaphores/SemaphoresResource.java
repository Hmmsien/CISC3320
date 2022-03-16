package Semaphores;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class SemaphoresResource {
    
    //Declare the semaphores
    public Semaphore printer, plotter, scanner;
    
    private void initSemaphores() {
        printer = new Semaphore(5);
        plotter = new Semaphore(6);
        scanner = new Semaphore(4);
        }
        public static void main(String[] args) throws Exception {
            SemaphoresResource rm = new SemaphoresResource();
        //Declare and initialize the semaphores with appropriate values
        rm.initSemaphores();
        //Loops through a sequence of 4 times
        for(int i=1; i<=4; i++) {
        //Create a child process to request a resource
        new Resource(rm).start();
        //Sleep for random time between 2 to 4 seconds
        Thread.sleep(ThreadLocalRandom.current().nextInt(2, 4 + 1)*1000);
        }
    }
}
