package Semaphores;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
public class Resource extends Thread{
    SemaphoresResource rm;
public Resource(SemaphoresResource rm) {
this.rm = rm;
}
@Override
public void run() {
//Generate a random number between 1 to 3 to determine which resource it will request
int r = ThreadLocalRandom.current().nextInt(1, 3 + 1);
//The corresponding semaphore is referred by s
//Echo the requested semaphore
Semaphore s=null;
switch (r) {
case 1: {//1-->Printer is requested
System.out.println("A Printer is requested.");
s = rm.printer;
break;
}
case 2: {//2-->Plotter is requested
System.out.println("A Plotter is requested.");
s = rm.plotter;
break;
}
case 3: {//3-->Scanner is requested
System.out.println("A Scanner is requested.");
s = rm.scanner;
break;
}
}
//Show the value of the corresponding semaphore
System.out.println("Value of the semaphore = "+s.availablePermits());
boolean done = false;
while(!done) {
if(s.tryAcquire()) {//Resource is available
System.out.println("Request is a Success!");
try {
//Sleep for random time between 1 to 3 seconds
Thread.sleep(ThreadLocalRandom.current().nextInt(1, 3 + 1)*1000);
} catch (InterruptedException e) {
e.printStackTrace();
}
s.release();
done=true;
}else {//Resource is not available
System.out.println("Request is a Failure!");
try {
//Sleep for random time between 1 to 3 seconds
Thread.sleep(ThreadLocalRandom.current().nextInt(1, 3 + 1)*1000);
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
}
}
