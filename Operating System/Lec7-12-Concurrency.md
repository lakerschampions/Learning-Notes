## Counter
counter++ consists of three separate actions:
- *read* the value of counter from memory and store it in a register
- *add* one to the value in the register
- *store* the value of the register in counter in memory

These actions can be interrupted by context switch, they are not atomic.
example:
```
#include <stdio.h>
#include <pthread.h>
int counter = 0;
void * calc(void * number_of_increments) {
  int i;
  for(i = 0; i < *((int*) number_of_increments);i++)
    counter++;
  }
int main() {
  int iterations = 50000000;
  pthread_t tid1,tid2;
  pthread_create(&tid1, NULL, calc, (void *) &iterations);
  pthread_create(&tid2, NULL, calc, (void *) &iterations);
  pthread_join(tid1,NULL);
  pthread_join(tid2,NULL);
  printf("The value of counter is: %d\n", counter);
}
```
<br><br>

## Bound Buffers
Consider a bounded buffer in which N items can be stored<br>
A counter is maintained to count the number of items currently in thebuffer
  - Incremented when an item is added
  - Decremented when an item is removed
  
Similar concurrency problems as with the calculation of sums happen in the bounded buffer (producer/consumer) problem

## Critical Sections, Mutual Exclusion
- A critical section is a set of instructions in which shared resources between processes/threads (e.g. variables) are changed
- Mutual exclusion must be enforced for critical sections
  - Only one process at a time should be in the critical section (mutual exclusion)
  - Processes have to get “permission” before entering their critical section (e.g. request a lock, hold the lock, release the lock)

- Any solution to the critical section problem must satisfy the following requirements:
  - Mutual exclusion: only one process can be in its critical section at any one point in time
  - Progress: any process must be able to enter its critical section at some point in time
    - Processes/threads in the “remaining code” do not influence access to critical sections
  - Fairness/bounded waiting: fairly distributed waiting times/processes cannot be made to wait indefinitely
  
- These requirements have to be satisfied, independent of the order in which sequences are executed

## Deadlocks
- Each deadlocked process/thread is waiting for a resource held by an other deadlocked process/thread (which cannot run and hence cannot release the resources)
- This can happen between any number of processes/threads and for any number of resources

### Four conditions must hold for deadlocks to occur 
- Mutual exclusion: a resource can be assigned to at most one process at a time
- Hold and wait condition: a resource can be held whilst requesting new resources
- No preemption: resources cannot be forcefully taken away from a process
- Circular wait: there is a circular chain of two or more processes, waiting for a resource held by the other processes

<br><br>
## Mutual Exclusion
### Approaches
- Software based: Peterson’s solution
- Hardware based: disabling interrupts, test_and_set(), swap_and_compare()
- OS based: Mutexes, Semaphores
- Monitors: software construct within the programming languages

### Peterson's Solution
```
P0: flag[0] = true;
    turn = 1;
    while (flag[1] == true && turn == 1)
    {
        // busy wait
    }
    // critical section
    ...
    // end of critical section
    flag[0] = false;
    
P1: flag[1] = true;
    turn = 0;
    while (flag[0] == true && turn == 0)
    {
        // busy wait
    }
    // critical section
    ...
    // end of critical section
    flag[1] = false;
```
<br>

### Disabling Interrupts
- Disable interrupts whilst executing a **critical section** and prevent interruption (i.e., interrupts from timers, I/O devices, etc.)
- Disabling interrupts “may” be appropriate on a single CPU machine
- This is insufficient on modern multi-core/multi processor machines

### Atomic Instructions
- Implement test_and_set() and swap_and_compare() instructions as a set of atomic ( = uninterruptible) instructions
  - Reading and setting the variable(s) is done as one “complete” set of instructions
  - If test_and_set() / compare_and_swap() are called simultaneously, they will be executed sequentially
- They are used in in combination with global lock variables, assumed to be true (1) if the lock is in use

```
// Test and set method
boolean test_and_set(boolean * bIsLocked) {
  boolean rv = *bIsLocked;
  *bIsLocked = true;
  return rv;
}
// Example of using test and set method
do {
  // WHILE the lock is in use, apply busy waiting
  while (test_and_set(&bIsLocked));
  // Lock was false, now true
  // CRITICAL SECTION
  ...
  bIsLocked = false;
  ...
  // remainder section
} while (...)


// Compare and swap method
int compare_and_swap(int * iIsLocked, int iExpected, int iNewValue) {
  int iTemp = *iIsLocked;
  if(*iIsLocked == iExpected)
  *iIsLocked = iNewValue;
  return iTemp;
}
// Example using compare and swap method
do {
  // While the lock is in use (i.e. == 1), apply busy waiting
  while (compare_and_swap(&iIsLocked, 0, 1));
  // Lock was false, now true
  // CRITICAL SECTION
  ...
  iIsLocked = 0;
  ...
  // remainder section
} while (...);
```
#### Disadvantages:
- test_and_set() and compare_and_swap() are hardware instructions and (usually) not directly accessible to the user
- Busy waiting is used
- Deadlock is possible, e.g. when two locks are requested in opposite orders in different threads
