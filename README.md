# mazeSolver


This program (CSC115 Assignment 4), uses Stack ADT (array based), Exceptions, and recursive methods to solve a text-based maze.
The strategy will be to push all of the maze positions onto the stack.
If a dead-end is reached, recently visited positions can be
popped off the stack (equivalent to backtracking in the maze) until the last fork in the road, 
and a different route can be attempted.
When the end location of the maze is reached, the stack is holding all of the positions traveled
on the path from the start to finish.
