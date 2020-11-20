# File System

## User View
- File abstraction hides away implementation details
- File naming policies
- User file attributes(e.g. size, protection, owner, protection, dates)
- Directory structures and organisation
- System calls to interact with the file system
  - File manipulation: open(), close(), read(), write(), . . .
  - Directory manipulation: create(), delete(), readdir(), rename(), link(), unlink(), list(), update()

<br>

## Implementation View
in terms of its low level implementation

### Hard Disk Structures
Disks are usually divided into multiple partitions
- Master boot record is located at start of the entire drive:
	-	Used to boot the computer (BIOS reads and executes MBR)
	- Contains partition table at its end with active partition
	- One partition is listed as active containing a boot block to load the operating system
 
### Unix Partition
- The partition boot block: 
	- Contains code to boot the operating system
	- Every partition has boot block – even if it does not contain OS
- Super block contains the partition’s details, e.g., partition size, number of blocks, I-node table size
- Free space management contains, e.g., a bitmap or linked list that indicates the free blocks
- I-nodes: an array of data structures, one per file, telling all about the files
- Root directory: the top of the file-system tree
- Data: files and directories

### Free Space Management
- Bitmaps
	- The size of the bitmap grows with the size of the disk but is constant for a given disk
	- Bitmaps take comparably less space than linked lists
- Linked list
	- We use free blocks to hold the numbers of the free blocks
  - Blocks are linked together
  - The size of the list grows with the size of the disk and shrinks with the size of the blocks

<br>

## File System Structures
- Single level: all files in the same directory (reborn in consumer electronics)
- Two or multiple level directories (hierarchical): tree structures
  - Absolute path name: from the root of the file system
  - Relative path name: the current working directory is used as the starting point
- Directed acyclic graph (DAG): allows files to be shared (i.e. links to files or sub-directories) but cycles are forbidden
- Generic graph structure in which links and cycles can exist


<br>

## File Table
- An in-memory mount table (table with different partitions that have been mounted)
- An in-memory directory cache of recently accessed directory information
- A system-wide open file table, containing a copy of the FCB for every currently open file in the system, including location on disk, file size, and “open count’ (#processes that use the file)
- A per-process open file table, containing a pointer to the system open file table

![img](https://raw.githubusercontent.com/lakerschampions/Notes_in_School/master/Operating%20System/img/file_table.png)
