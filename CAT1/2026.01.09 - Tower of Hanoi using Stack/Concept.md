There are 3 stacks
- source
- auxillary
- destination

Disks in increasing size are placed in source stack 1,2,3....
Final position should be same as source in the destination stack

ex: Odd no. of disks [1,2,3] , [] , [] 
    - [2,3] , [] , [1]
    - [3] , [2] , [1]
    - [3] , [1,2] , []
    - [] , [1,2] , [3]
    - [1] , [2] , [3]
    - [1] , [] , [2,3]
    - [] , [] , [1,2,3]

Even no. of disks [1,2] , [] , []
    - [2] , [1] , []
    - [] , [1] , [2]
    - [] , [] , [1,2]

Here we see, no. of moves is `2^n - 1` 


For even number of disks, we move to the auxillary first
For odd number of disks, we move to destination first

Time complexity = O(2^n)
Space complexity = O(n)