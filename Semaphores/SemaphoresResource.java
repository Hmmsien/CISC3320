package Semaphores;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class SemaphoresResource {
    
    //Declare the semaphores
    public Semaphore printers, plotters, scanners;
    
    //Initialize the semaphores with the appropriate values
    private void initSemaphores() {
        printers = new Semaphore(5);
        plotters = new Semaphore(6);
        scanners = new Semaphore(4);
    }
    public static void main(String[] args) throws Exception {
        SemaphoresResource rm = new SemaphoresResource();
        
        //call function to initialize the semaphores
        rm.initSemaphores();

        //Loops through a sequence 4 times
        for(int i=1; i<=4; i++) {
            //Create a child process to request a resource
            new Resource(rm).start();
            //Sleep for random time between 1 to 3 seconds
            Thread.sleep(ThreadLocalRandom.current().nextInt(1, 3 + 1)*1000);
        }
    }
}
