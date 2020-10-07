###  What do we understand by "Collections" in Java?
- A collection is an object that represents a group of objects
- The Collections API is a unified framework for representing and manipulating collections, independent of their implementation
### What does the abbreviation API stand for?
- Application Programming Interface
### What is the difference between a library and an API?
- An API is an interface or communication protocol between a client and a server, intended to simplify the building of client-side software. A library contains re-usable chunks of code

### Java Collections Framework principle ideas:
- We have container objects that contain objects
- All containers are either "collections" or "maps"
- All containers provide a common set of method signatures, in addition to their unique set of method signatures
### The framework contains data structures
- e.g. arrays; lists; maps
### The framework contains algorithmic operations
- e.g. searching; sorting

### Collection
- Something that holds a dynamic collection of objects
### Map
- Defines mapping between keys and objects (two collections)
### Iterable
- Collections are able to return an iterator object that can scan over the contents of a collection one object at a time

###  Core collection framework interfaces
- Iterable: Represents an iterator object
- Collection: Represents a group of objects (elements)
- Map: Maps keys to values; no duplicate keys
- Queue: Represents FIFO queues or LIFO stacks
- Deque: Represents a double ended queue
- Set: A collection that cannot contain duplicate elements
- List: An ordered sequence of elements that allows duplicate elements
### Interface location
- Most interfaces can be found in the java.util.* package
- The "Iterable" interface resides in the java.lang.* package

### Aggregation and composition
- Aggregation: A uses B
- Composition: A owns B
