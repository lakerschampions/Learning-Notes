# Definitions

## Curried Functions
Functions that take their arguments one at a time are called **curried functions**.Curried functions are more **flexible** than functions on tuples, because useful functions can often be made by partially applying a curried function. 

## Polymorpgic Functions
A function is called **polymorphic** ("of many forms") if its type contains one or more type variables. <br>
```length :: [a] → Int ```

## Overloaded Functions 
A polymorphic function is called **overloaded** if its type contains one or more class constraints. <br/>
```
Num - Numeric types
Eq - Equality types
Ord - Ordered types 
```
