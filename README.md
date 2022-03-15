# CISC3320

## Assignment #1 Process Creation 

Problem statement:
Using fork command to create child process and grandchild process. 
Then output the string information to describe each process identies and PID.

Requirement:
The P (parent) process shall print its PID along with the string 
“I am the grandparent process”.
The C (child) process shall print its PID, and the string 
“I am the parent process”. 
The GC (grandchild) process shall print its PID and the string 
“I am a grandchild process”.

Assumptions:
Using fork() command to create first child process
Then use a nested fork() to create the grandchild process
And use getpid() to display the PID

-------------------------------------------------------
## Assignment #2  Semaphores

Problem statement:
write a program that uses semaphores to simulate mediated access to three computer resources:  
1.	5 printers
2.	6 plotters
3.	4 scanners

Requirement:
1. Declare and initialize the semaphores with the appropriate values.
2. Create a routine that loops through a sequence 4 times. In each iteration the process 
  a. forks a child process. 
    i. uses a random number generator (1-3) to determine which resource it will request
    ii. uses native semaphore function or one that you create to request the appropriate resource
    iii. Print the process’ PID and the requested resource type
    iv. Print the process’ PID  and the success/failure of the request
    v. if the resource is available - sleep for a random time between 1-3 seconds and then release the resource using appropriate the semaphore function
    vi. if the resource is not available – sleep for a random between 2-4 seconds and repeat the request (go to step ii).  
    vii. Terminate
  b. Sleeps for a random time between 1-3 seconds

-------------------------------------------------------------------
