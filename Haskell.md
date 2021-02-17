# Definitions

## Curried Functions
Functions that take their arguments one at a time are called **curried functions**.Curried functions are more **flexible** than functions on tuples, because useful functions can often be made by partially applying a curried function. 

## Polymorpgic Functions
A function is called **polymorphic** ("of many forms") if its type contains one or more type variables. <br>
```length :: [a] -> Int ```

## Overloaded Functions 
A polymorphic function is called **overloaded** if its type contains one or more class constraints. <br/>
```
Num - Numeric types
Eq - Equality types
Ord - Ordered types 
eg.
(+) :: Num a => a -> a -> a
(==) :: Eq a => a -> a -> Bool
(<) :: Ord a => a -> a -> Bool 
```
## Conditional Expressions 
```
signum :: Int → Int
signum n = if n < 0 then -1 else
 if n == 0 then 0 else 1 
 ```
 
## Guarded Equations 
```
signum n | n < 0 = -1
 | n == 0 = 0
 | otherwise = 1 
 ```
## Pattern Matching
```
(&&) :: Bool -> Bool -> Bool
True && True = True
_    && _    = False 
```
## Lists Comprehensions 
### Dependant Generators 
```
[x^2 | x <- [1..5]] 

[(x,y) | x <- [1,2,3], y <- [4,5]]
[(1,4),(1,5),(2,4),(2,5),(3,4),(3,5)]
```
### Guards
```
factors :: Int → [Int]
factors n =
 [x | x ← [1..n], n `mod` x == 0] 
 ```

## Higher-Order Functions
A function is called **higher-order** if it takes a function as an argument or returns a function as a result.

### Why are they useful?
- Common programming idioms can be encoded as functions within the language itself
- Domain specific languages can be defined as collections of higher-order functions.
- Encapsulation using partial function application can be used to hide implementation details.
- Algebraic properties of higher-order functions can be used to reason about programs.
```
twice :: (a → a) → a → a
twice f x = f (f x)
```
## foldr
```
foldr :: (a → b → b) → b → [a] → b
foldr f v [] = v
foldr f v (x:xs) = f x (foldr f v xs)
```
```
sum = foldr (+) 0
product = foldr (*) 1
or = foldr (||) False
and = foldr (&&) True
length = foldr (\_ n -> 1+n) 0
reverse = foldr (\x xs -> xs ++ [x]) []

```

## Lazy Evalution
- Avoids doing unnecessary evaluation.
- Allows programs to be more modular.
- Allows us to program with infinite lists.
<br>
Lazy Evaluation = Outmost reduction + Sharing
