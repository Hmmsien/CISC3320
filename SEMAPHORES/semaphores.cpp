#include<semaphore.h>
#include <thread>
#include <iostream>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>

using namespace std;

//Declare the semaphores 
sem_t printers;
sem_t plotters;
sem_t scanners;

void resource();

int main() {
    //initialize the semaphores
    sem_init(&printers, 0, 5);
    sem_init(&plotters, 0, 6); 
    sem_init(&scanners, 0, 4);

    //loops through a sequence 4 times.
    for(int i=1; i<=4;i++){
        if(!fork()){ 
            resource();
        }
    }

    return 0;
}

void resource() {
    //to determine which resource it will request
    int numOfResource = rand() % 3 + 1; //random number generator (1-3) 
    switch (numOfResource)
    {
    case 1:
        sem_wait(&printers);
        cout << "A Printer is requested.\n Done by process: " + getpid();
        break;
    case 2:
        sem_wait(&plotters);
        cout << "A plotters is requested.\n Done by process: " + getpid();
        break;
    case 3:
        sem_wait(&scanners);
        cout << "A scanners is requested.\n Done by process: " + getpid();
        break;   
    }

}