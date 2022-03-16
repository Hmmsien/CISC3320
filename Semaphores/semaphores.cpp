#include<semaphore.h>
#include <thread>
#include <iostream>
#include <stdio.h>
#include <unistd.h>

using namespace std;

//Declare the semaphores 
sem_t printers，plotters，scanners;

void resource();
void printer();
void plotter();
void scanner();

int main() {
    //initialize the semaphores
    sem_init(&printers, 0, 5);
    sem_init(&plotters, 0, 6); 
    sem_init(&scanners, 0, 4);

    //loops through a sequence 4 times.
    for(int i=1; i<=4;i++){
        fork();   
        resource();
    }

    return 0;
}

void resource() {
    //to determine which resource it will request
    int numOfResource = rand() % 3 + 1; //random number generator (1-3) 
    switch (numOfResource)
    {
    case 1:
        pthread_create(&printers,NULL,printer,NULL);
        cout << "A Printer is requested.\n Done by process: " + getpid();
        break;
    case 2:
        pthread_create(&plotters,NULL,plotter,NULL);
        cout << "A plotters is requested.\n Done by process: " + getpid();
        break;
    case 3:
        pthread_create(&scanners,NULL,func1,NULL);
        cout << "A scanners is requested.\n Done by process: " + getpid();
        break;   
    }

}

void printer() {
    sem_wait(&printers);
    cout << "printer";
}

void plotter(){
    sem_wait(&plotter);
    cout << "plotter";
}

void scanner(){
    sem_wait(&scanner);
    cout << "scanner";
}