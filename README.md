# Algorithm-AoA

### Implementation of some basic Algorithms in java.


The **Sort** Package contains the following Alogorithms:

* Insertion Sort (Normally and with Recurscion)
  * Use `Insertion.sort(arr)` for normal insertion sort
  * User `InsertionR.sort(arr)` for recursive Insertion Sort
* Merge Sort (Normally and to do so without changing the original value
  * Use `Merge.sort(arr)` to sort the passed array
  * Use `Merge.sorted(arr)` to recieve a sorted array
* A Simple Selection Sort
  * Use `Selection.sort(arr)`



The **Find** Package contains the following Algorithms:

* Binary Search (Normally and with recursion)
  * For Normal, Use:

    ```java
    BinarySearch binarySearch = new BinarySearch(arr,value); // value is optional and can be passed during function call

    int index = binarySearch.index(value) // No need to pass value if already set, if not set and and not passed, default is 0
    ```
  * For Recursive, Use:

    ```java
    BinarySearch.search(array,value);
    ```
<br/>

The **PathFinder** Package contains the following Algorithm:
* Dijkstra
  * If you have the adjacency matrix of a graph:
  ```java
  Dijkstra dijkstra = DijkStra.getInstance(graph);
  ```
  * If you wanted a randomly generated graph:
  ```java
  Dijkstra dijkstra = DijkStra.getInstance(int nodes, int maxLength); // arguements are optional, will be replaced by default values if not passed
  ```
  * If you want to create your own graph:
  ```java
  Dijkstra dijkstra = DijkStra.getInstance(true); // asks for size later
  // or
  Dijkstra dijkstra = Dijkstra.getInstance(true,n); // n is the size
  ```
    then,

  ```java
  Dijkstra.ShortestPath shortestPath = dijkstra.computeFor(sourceNode); // ShortestPath is an inner class

  // Now you can call various methods of ShortestPath

  shortestPath.print(); // prints an overview of the solution
  shortestPath.getDistance(node); // returns distance from specified node to source node
  shortestPath.getPath(node); // returns a List containing the path from the source to the specified node (excluding the node)
  shortestPath.getPaths(); // returns an array of Lists each containing the path from source to the index's node
  shortestPath.getMap(); // returns an Array containing the shortest distances of each node from the source
  ```
<br/>

The **Utils** Package contains Utility classes like:
* ArrayGen to generate a random Array
  * Use `ArrayGen.generate(length, maxValue, sorted)` where sorted is a boolean value

* GraphGen to generate a graph
  * Use `GraphGen.getRandomGraph(size, maxLength);` to get a random graph
  * Use `GraphGen.generateCustomGraph(size)` or `GraphGen.generateCustomGraph()` to create a graph in console (size will have to entered manually if not specified)

<br />
<br />
More to come
