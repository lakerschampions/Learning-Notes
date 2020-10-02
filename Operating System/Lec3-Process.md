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
