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



The Arrays Class contains Utility class ArrayGen to generate a random Array

* User `ArrayGen.generate(length, maxValue, sorted)` where sorted is a boolean value


More to come
