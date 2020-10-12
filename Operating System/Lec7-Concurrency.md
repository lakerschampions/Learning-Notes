### Counter
counter++ consists of three separate actions:
- read the value of counter from memory and store it in a register
- add one to the value in the register
- store the value of the register in counter in memory

### Bound Buffers
Consider a bounded buffer in which N items can be stored<br>
A counter is maintained to count the number of items currently in thebuffer
  - Incremented when an item is added
  - Decremented when an item is removed
  
Similar concurrency problems as with the calculation of sums happen in the bounded buffer (producer/consumer) problem

### Deadlocks
- Each deadlocked process/thread is waiting for a resource held by an other deadlocked process/thread (which cannot run and hence cannot release the resources)
- This can happen between any number of processes/threads and for any number of resources

#### Four conditions must hold for deadlocks to occur 
- Mutual exclusion: a resource can be assigned to at most one process at a time
- Hold and wait condition: a resource can be held whilst requesting new resources
- No preemption: resources cannot be forcefully taken away from a process
- Circular wait: there is a circular chain of two or more processes, waiting for a resource held by the other processes
