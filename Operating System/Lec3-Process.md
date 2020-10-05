## Goals
- Introduction to processes and their implementation
- Process states and state transitions
- System calls for process management

## Definition
“a process is a running instance of a program”
- A program is passive and “sits” on a disk
- A process has control structures associated with it, may be active, and may have resources assigned to it (e.g. I/O devices, memory, processor)

A process is registered with the OS using its **“control structures”**: i.e. an entry in the OS’s process table to a **process control blocks (PCB)**.<br>
The process control block contains all information necessary to administer the process and is essential for **context switching** in multiprogrammed system.

## Memory Image
- Contains: The program code, A data segment, stack and heap.
- Every process has its own logical address space, in which the stack and heap are placed at opposite sides to allow them to grow.
- Some OS’es use address space layout randomisation.

## Process States and Transitions
![image](https://raw.githubusercontent.com/lakerschampions/Notes_in_School/master/Operating%20System/img/5states.png)
States:
- A **new** process has just been created (has a PCB) and is waiting to be admitted (it may not yet be in memory)
- A **ready** process is waiting for the CPU to become available (e.g. unblocked or timer interrupt)
- A **running** process “owns” the CPU
- A **blocked** process cannot continue, e.g. is waiting for I/O
- A **terminated** process is no longer executable (the data structures - PCB may be temporarily preserved)

State transitions include:
1. New → ready: admit the process and commit to execution<br>
2. Running → blocked: e.g. process is waiting for input or carried out a system call<br>
3. Ready → running: the process is selected by the process scheduler<br>
4. Blocked → ready: event happens, e.g. I/O operation has finished<br>
5. Running → ready: the process is preempted, e.g., by a timer interrupt or by pause<br>
6. Running → exit: process has finished, e.g. program ended or exception encountered<br>
The interrupts/traps/system calls lie on the basis of the transitions<br>

![image](https://raw.githubusercontent.com/lakerschampions/Notes_in_School/master/Operating%20System/img/QSqueue.png)

## Context Switching
- Multi-programming is achieved by alternating processes and context switching. True parallelism requires multiple processors.
- When a context switch takes place, the system saves the state of the old process and loads the state of the new process (creates overhead)
- A trade-off exists between the length of the time-slice and the context switch time

Switching process:
1. Save process state (program counter, registers) <br>
2. Update PCB (running -> ready/blocked)<br>
3. Move PCB to appropriate queue (ready/blocked)<br>
4. Run scheduler, select new process<br>
5. Update to running state in the new PCB<br>
6. Update memory management unit (MMU)<br>
7. Restore process<br>


A process control block contains three types of attributes:
- Process identification (PID, UID, Parent PID)
- Process control information (process state, scheduling information, etc.)
- Process state information (user registers, program counter, stack pointer, program status word, memory management information, files, etc.)

Process control blocks are kernel data structures, i.e. they are protected and only accessible in kernel mode!

## Tables
An operating system maintains information about the status of
- “resources” in tables
- Process tables (process control blocks)
- Memory tables (memory allocation, memory protection, virtual memory)
- I/O tables (availability, status, transfer information)
- File tables (location, status)

The process table holds a process control block for each process, allocated upon process creation. Tables are maintained by the kernel and are usually cross referenced.

## System Call
The true system calls are “wrapped” in the OS libraries (e.g. libc) following a well defined interface (e.g. POSIX, WIN32 API)
System calls are necessary to notify the OS that the process has terminated.

## Fork
- fork() creates an exact copy of the current process (The first instruction carried out by the child is the first one after the fork call)
- fork() returns the process identifier of the child process to the parent process (iPID > 0)
- fork() returns 0 to the child process (iPID = 0)


## Process Scheduling
The OS is responsible for managing and scheduling processes. It relies on the scheduler (dispatcher) to decide which process to run next, which uses a scheduling algorithm to do so. The type of algorithm used by the scheduler is influenced by the type of operating system (e.g., real time vs. batch)

#### Classification by Time Horizon
**Long term:** applies to new processes and controls the degree of multiprogramming by deciding which processes to admit to the system when A good mix of CPU and I/O bound processes is favourable to keep all resources as busy as possible. Usually absent in popular modern OS
**Medium term:** controls swapping and the degree of multi-programming
**Short term:** decide which process to run next. Manages the ready queue. Invoked very frequently, hence must be fast. Usually called in response to clock interrupts, I/O interrupts, or blocking system calls.

#### Classification by Approach
**Non-preemptive:** processes are only interrupted voluntarily (e.g., I/O operation or “nice” system call – yield()), Windows 3.1 and DOS were non-preemtive
**Preemptive:** processes can be interrupted forcefully or voluntarily. This requires context switches which generate overhead, too many of them should be avoided (recall last lecture). Prevents processes from monopolising the CPU. Most popular modern operating systems are preemptive
