## Implementing Priority Queue using DLL

Each node will have 4 fields
1. prev
2. priority
3. data
4. next

When creating the DLL, the nodes are placed in the priority order.

Example:
    Elements: 1,3,2,4,5
    Priority: 5,3,4,2,1

*Head*
[,3,3,] <=>[,1,5,]
