## Contiguous
- Allocation of free space can be done using **first fit, best fit, next fit**.
- **Simple to implement:** only location of the first block and the length of the file must be stored (in the directory entry)
- **Optimal read/write performance:** blocks are co-located/clustered in nearby/adjacent sectors, hence the seek time is minimised

### Disadvantages of contiguous file systems include:
  - The exact size of a file (process) is not always known beforehand: what if the file size exceeds the initially allocated disk space
  - Allocation algorithms needed to decide which free blocks to allocate to a given file (e.g., first fit, best fit, etc.)
  - Deleting a file results in external fragmentation: de-fragmentation must be carried out regularly (and is slower than for memory)

<br>

## Linked lists
- Only the address of the first block has to be stored to locate a file
- Each block contains a data pointer to the next block (which takes up space)
- Easy to maintain: only the first block (address) has to be maintained in the directory entry
- File sizes can grow dynamically (i.e. file size does not have to be known beforehand): new blocks/sectors can be added to the end of the file
- Similar to paging for memory, every possible block/sector of disk space can be used: i.e., there is no external fragmentation!

### Disadvantage
- Random access is very slow, to retrieve a block in the middle, one has to walk through the list from the start
- There is some internal fragmentation; on average the last half of the block is left unused
	- Internal fragmentation will reduce for smaller block sizes
- May result in random disk access, which is very slow 
	- Larger blocks (containing multiple sectors) will be faster
- Space is lost within the blocks due to the pointer, the data in a block is no longer a power of 2!
- Diminished reliability: if one block is corrupt/lost, access to the rest of the file is lost

<br>


## File Allocation Table (FAT)
### Advantages:
- Block size remains power of 2, i.e., no space is lost due to the pointer
- Index table can be kept in memory allowing fast non-sequential/random access (one still has to walk through the table though)

### Disadvantages:
- The size of the file allocation table grows with the number of blocks, and hence the size of the disk
- For a 200GB disk, with a 1KB block size, 200 million entries are required. Assuming that each entry at the table occupies 4 bytes, this requires 800MB of main memory!

<br>

## I-nodes (lookups)
- Each file has a small data structure (on disk) called I-node (index-node) that contains its attributes and block pointers.
	- In contrast to FAT, an I-node is only loaded when the file is open (stored in system wide open file table)
	- If every I-node consists of n bytes, and at most k files can be open at any point in time, at most n×k bytes of main memory are required
- I-nodes are composed of direct block pointers (usually 10), indirect block pointers, or a combination thereof (e.g., similar to multi-level page tables)
