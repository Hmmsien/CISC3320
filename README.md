# CISC3320
Assignment #1 Process Creation completed by Huimin Chen(24017423)

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
