## Threads
A process consists of two fundamental units
- Resources: all related resources are grouped together
- Execution trace, i.e., an entity that gets executed

A process can share its resources between multiple execution traces.

Every thread has its own execution context (e.g. program counter, stack, registers)<br>
All threads have access to the process’ shared resources.
- E.g. files, one thread opens a file, all threads of the same process can access the file 
- Global variables, memory, etc. (⇒ synchronisation!)<br>

Similar to processes, threads have: States and transitions (new, running, blocked, ready, terminated), A thread control block
![img](https://raw.githubusercontent.com/lakerschampions/Notes_in_School/master/Operating%20System/img/shareresource.png)

Threads incur **less overhead** to create/terminate/switch (address space remains the same for threads of the same process)
Some CPUs (hyperthreaded ones) have direct hardware support for multi-threading.

Inter-thread communication is easier/faster than interprocess communication (threads share memory by default)<br>
No protection boundaries are required in the address space (threads are cooperating, belong to the same user, and have a common goal) <br>
Synchronisation has to be considered carefully!

Multiple related activities apply to the same resources, these resources should be accessible/shared
Processes will often contain multiple blocking tasks
- I/O operations (thread blocks, interrupt marks completion)
- Memory access: **pages faults** are result in blocking

Such activities should be carried out in parallel/concurrently<br>
Application examples: webservers, make program, spreadsheets, word processors, processing large data volumes

## User Threads(Many-to-One)
Thread management (creating, destroying, scheduling, thread control block manipulation) is carried out in **user space** with the help of a user
library.<br>
The process maintains a thread table managed by the runtime system without the kernel’s knowledge

### Advantages:
- Threads are in user space (i.e., no mode switches required)
- Full control over the thread scheduler
- OS independent (threads can run on OS that do not support them)

### Disadvantages:
- Blocking system calls suspend the entire process (user threads are mapped onto a single process, managed by the kernel)
- No true parallelism (a process is scheduled on a single CPU)
- Clock interrupts are non-existent (i.e. user threads are non-preemptive)
- Page faults result in blocking the process


## Kernel Threads(one to one)
The kernel manages the threads, user application accesses threading facilities through API and system calls<br>
- Thread table is in the kernel, containing thread control blocks (subset of process control blocks)
- If a thread blocks, the kernel chooses thread from same or different process (↔ user threads)

### Advantages:
- True parallelism can be achieved
- No run-time system needed

### Disvantages:
- Frequent mode switches take place, resulting in lower performance
  
Windows and Linux apply this approach

## Hybrid Implementations(many to many)
User threads are multiplexed onto kernel threads<br>
Kernel sees and schedules the kernel threads (a limited number)<br>
User application sees user threads and creates/schedules these (an “unrestricted” number)

![img](https://raw.githubusercontent.com/lakerschampions/Notes_in_School/master/Operating%20System/img/comparision.png)
