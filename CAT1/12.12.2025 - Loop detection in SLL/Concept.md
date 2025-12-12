# Loop detection in singly linked list

>  Given a SLL, and the point to connect it to. Code this in java

## `Approach`

* Take two pointers slow and fast
* Move slow by 1 node and fast by two nodes
* Repeat this until slow and fast are on the same node 
* If this has happened then a loop is present.
