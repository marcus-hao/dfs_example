# dfs_example
DFS example using a cyclist road network. Written with spaghetti code.

## Quick Start
```
git clone https://github.com/marcus-hao/dfs_example
javac Main.java
java Main
```

## Introduction
The standard DFS algorithm is modifed to terminate early when a destination vertex is reached. This implementation considers an unweighted digraph, where distance is measured by the number of edges required to reach the destination vertex.
Therefore, the algorithm makes no assumption on "weights" when deciding which vertex to visit first, and a shortest path is not guaranteed.

## Application Scenario
A pathfinding application for a cyclist road network is proposed. Due to poor city planning, the infrastructure for cyclists in the city is lacking. For example, some roads only have a cycling lane on one side of the road, forcing cyclists to take a different route on their return trip for safety. This application helps cyclists locate a path from their current location to ther destination that includes cycling lanes.

## Choice of Data Structure
The data structure used to represent the graph is an adjacency list. The adjacency list is wrapped
in a map structure, `Map<Vertex, List<Vertex>>`, where `Vertex` is a user-defined class
for representing locations. This design was chosen because we wanted the flexibility to handle
vertices of arbitrary data types during querying. For instance, our `Vertex` implementation uses
strings instead of integers. Each key in the hash map represents a vertex, and its value is an
`ArrayList` for its adjacent vertices.
In the DFS algorithm, we used a `Set` data structure to keep track of the visited vertices during
traversal. Because this data structure keeps track of unique values, we can determine whether
a vertex has already been visited or not by checking if it is in the `Set`. If the vertex is already in
the `Set`, then the DFS algorithm backtracks to the parent and visits other adjacent vertices.

## General Outline of the Program
While the program makes no assumptions about distance when deciding which vertex to visit during DFS, it is determined by the order in which edges were added to the graph during construction.

For example, if E(u,v) was added before E(u,w), then we visit v first. 

## Conclusion
The application works as described in the specification of the assignment.
For future improvements, a weighted graph implementation will be more suitable for a pathfinding application, as the current DFS algorithm may suggest longer paths than necessary.