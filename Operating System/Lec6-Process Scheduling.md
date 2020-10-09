## Priority Queues
- Jobs can have different priority levels that are fixed
- Jobs of the same priority are run in round robin fashion
- Priority queues are usually implemented by using multiple queues, one for each priority level 

## Multi-level Feedback Queues
- Different scheduling algorithms can be used for the individual queues (e.g., round robin, SJF, FCFS)
- Feedback queues allow priorities to change dynamically, i.e., jobs can move between queues:
  - Move to lower priority queue if too much CPU time is used (prioritise I/O and interactive processes)
  - Move to higher priority queue to prevent starvation and avoid inversion of control
  
- Defining characteristics of feedback queues include:
  - The number of queues
  - The scheduling algorithms used for the individual queues
  - Migration policy between queues
  - Initial access to the queues
  - Feedback queues are highly configurable and offer significant flexibility
  
 ### Window 7
- An interactive system using a preemptive scheduler with dynamic priority levels
- Two priority classes with 16 different priority levels exist
  - “Real time” processes/threads have a fixed priority level
  - “Variable” processes/threads can have their priorities boosted temporarily
- A round robin algorithm is used within the queues
- Priorities are based on the process base priority (between 0-15) and thread base priority (±2 relative to the process priority)
- A thread’s priority dynamically changes during execution between its base priority and the maximum priority within its class
  - Interactive I/O bound processes (e.g. keyboard) receive a larger boost
  - Boosting priorities prevents priority inversion
  
### Schduling in Linux
#### The Completely Fair Scheduler
- Process scheduling has evolved over different versions of Linux to account for multiple processors/cores, processor affinity, and load balancing between cores
- Linux distinguishes between two types of tasks for scheduling:
  - Real time tasks (to be POSIX compliant), divided into:
    - Real time FIFO tasks
    - Real time Round Robin tasks
  - Time sharing tasks using a preemptive approach (similar to variable in Windows)
- The most recent scheduling algorithm in Linux for time sharing tasks is the “completely fair scheduler” (CFS, before the 2.6 kernel, this was an O(1) scheduler)

#### Real-time tasks
- Real time FIFO tasks have the highest priority and are scheduled using a FCFS approach, using preemption if a higher priority job shows up
- Real time round robin tasks are preemptable by clock interrupts and have a time slice associated with them
- Both approaches cannot guarantee hard deadlines

#### Time Sharing Tasks (equal priority)
- The CFS divides the CPU time between all processes
- If all N processes have the same priority:
  - They will be allocated a “time slice” equal to 1/N times the available CPU time
  - I.e., if N equals 5, every process will receive 20% of the processor’s time
- The length of the time slice and the “available CPU time” are based on the targeted latency (⇒ every process should run at least once during this interval)
- If N is very large, the context switch time will be dominant, hence a lower bound on the “time slice” is imposed by the minimum granularity
  - A process’s time slice can be no less than the minimum granularity (response time will deteriorate)

#### Time Sharing Tasks (different priority)
- A weighting scheme is used to take different priorities into account 
- If process have different priorities:
  - Every process i is allocated a weight wi that reflects its priority
- The tasks with the lowest proportional amount of “used CPU time” are selected first

#### Scheduling Decisions
- Single processor machine: which process (thread) to run next (one dimensional)
- Scheduling decisions on a multi-processor/core machine include:
  - Which process (thread) to run where, i.e., which CPU?
  - Which process (thread) to run when?
  
#### Shared Queues
- A single or multi-level queue shared between all CPUs
- Advantage: automatic load balancing
- Disadvantages: Contention for the queues (locking is needed); “All CPUs are equal, but some are more equal than others”: does not account for processor affinity:
  - Cache becomes invalid when moving to a different CPU
  - Translation look aside buffers (TLBs - part of the MMU) become invalid
- Windows will allocate the highest priority threads to the individual CPUs/cores

#### Private Queues
- Each CPU has a private (set) of queues
- Advantages: CPU affinity is automatically satisfied; Contention for shared queue is minimised
- Disadvantages: less load balancing
- Push and pull migration between CPUs is possible

#### Thread Types
**Related:** multiple threads that communicate with one another and ideally run together (e.g. search algorithm)
**Unrelated:** e.g. processes threads that are independent, possibly started by different users running different programs

#### Space Scheduling
Approach:
 - N threads are allocated to N dedicated CPUs
 - N threads are kept waiting until N CPUs are available
 - Non-preemptive, i.e. blocking calls result in idle CPUs (less context switching overhead but results in CPU idle time)
 
The number N can be dynamically adjusted to match processor capacity
