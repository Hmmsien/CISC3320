package Semaphores;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class SemaphoresP {
    public Semaphore printer, plotter, scanner;
  
  
   private void initSemaphores() {
       printer = new Semaphore(5);
       plotter = new Semaphore(6);
       scanner = new Semaphore(4);
   }

   public static void main(String[] args) throws Exception {
        SemaphoresP rm = new SemaphoresP();
       //Declare and initialize the semaphores with appropriate values
       rm.initSemaphores();
       //Loops through a sequence of 4 times
       for(int i=1; i<=4; i++) {
           //Create a child process to request a resource
           new Resource(rm).start();  
           //Sleep for random time between 2 to 5 seconds
           Thread.sleep(ThreadLocalRandom.current().nextInt(2, 5 + 1)*1000);
       }
      
   }
}
