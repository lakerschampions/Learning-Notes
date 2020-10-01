## Goals for Today
- G51SYS from an operating system’s point of view
- Address spaces
- Interrupts

## G51CSA
![img](https://raw.githubusercontent.com/lakerschampions/Notes_in_School/master/Operating%20System/img/G51CSA.png)
### CPU Design
A CPU’s basic cycle consist of **fetch**, **decode**, and **execute** (pipelines, or superscalar) <br>
Every CPU has own **instruction set** and **registers**. Registers are used to store data and for special functions. The compiler/programmer decides what to keep in the registers. Context switching must save and restore the CPU’s internal state, including its registers
