## Goals for Today
- G51SYS from an operating system’s point of view
- Address spaces
- Interrupts

## G51CSA
![img](https://raw.githubusercontent.com/lakerschampions/Notes_in_School/master/Operating%20System/img/G51CSA.png)
### CPU Design
- A CPU’s basic cycle consist of **fetch**, **decode**, and **execute** (pipelines, or superscalar). 
- Every CPU has own **instruction set**.
- A CPU has **registers**. Registers are used to store data and for special functions. The compiler/programmer decides what to keep in the registers. Context switching must save and restore the CPU’s internal state, including its registers.

### Memory Management Unit
- One cannot know where in memory an executable will run.
- when coding, variables have memory associated with them - they need to have an address.
- Two different address spaces: logical address space(seen by process and used by complier), physical address space(seen by hardware/OS).
- When compiling code, memory addresses must be assigned to variables and instructions. One does not know what memory addresses will be available in physical
memory. Just assume that the code will start running at address 0.
- On some rare occasions, the process may run at physical address 0:physical address = logical address + 0; On other occasions, it will be running at a completely different location in physical memory and an offset is added: physical address = logical address + offset; The memory management unit is responsible for address translation; Different processes require different address translation (offsets). Context switching requires the MMU to be updated.

### Moore's Law
“The number of transistors on an integrated circuit (chip) doubles roughly every two years”

### Timer Interrupts
- Interrupts temporarily pause a process’s normal operation.
- Different types of interrupts: By CPU clock; I/O interrupts for I/O completion or error codes; Software generated.
- Context switches (i.e. switching between processes) can be initiated by timer interrupts after a “set time”.
![img](https://raw.githubusercontent.com/lakerschampions/Notes_in_School/master/Operating%20System/img/interrupts.png)

#### Steps
1. Timer generates an interrupt <br>
2. CPU finishes current instruction and tests for interrupt<br>
3. Transfer to interrupt service routine<br>
  - Hardware saves current process state (PSW, program counter)
  - Set program counter to interrupt service routine
  - Save registers and other state information
4. Carry out interrupt service routine (scheduler)<br>
5. Restore next process to run<br>
