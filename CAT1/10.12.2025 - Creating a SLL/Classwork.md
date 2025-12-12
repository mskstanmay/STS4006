Linked lists

`Node { Data, address of next node}`

Head: The first node of the list
Tail: The last node of the list

    Example: [5,address of next node]->[6,null]


- Singly Linked List
    - this has one way traversal
    - Node: `Node { Data, address of next node}`

- Doubly Linked List
    - this has two way traversal
    - previous and next node address both are stored
    - Node: `Node { address of prev node, Data, address of next node}`

- Singly Circular Linked List
    - if the tail is connected with any of the previous nodes.
    - Node: `Node { Data, address of next node}`
    
- Doubly Circular Linked List
    - if the tail is connected to any one fo teh previous nodes.
    - Node: `Node { address of prev node, Data, address of next node}`