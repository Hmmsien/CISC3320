#include <stdio.h>
#include <unistd.h>

int main()
{
 	// Creating a child process if fork() return 0.
        if(!fork()){ 
        printf("I am the parent process. PID: %d\n", getpid()); 
        if(!fork()){ // Create new child process under the previous child process.
            printf("I am the grandchild process. PID:%d\n", getpid()); 
        }
    } else {
        printf("I am the grandparent process. PID:%d\n", getpid()); //This is the parent process.
    }
}
