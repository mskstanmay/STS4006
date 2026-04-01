# Sort Bitonic Doubly Linked List
Sorting a bitonic doubly linked list into a fully sorted doubly linked list

## Definition  
A **bitonic doubly linked list** is a list in which the elements first appear in **increasing order** and then in **decreasing order** (or vice versa).  
Sorting a bitonic doubly linked list involves rearranging the nodes so that the entire list becomes sorted in ascending order.

## Concept
- A **doubly linked list (DLL)** consists of nodes containing:
  - `data` → value stored in the node
  - `prev` → reference to the previous node
  - `next` → reference to the next node
- A bitonic DLL has two parts:
  - An **ascending sequence**
  - A **descending sequence**
- The point where the order changes is called the **peak node**

## Approach  
Sorting Using Split, Reverse, and Merge

This approach sorts the bitonic DLL by converting it into two sorted lists and merging them.

### Key Idea
- Identify the **peak node** where increasing order ends
- Split the list into two parts:
  - First part → increasing order
  - Second part → decreasing order
- Reverse the second part to make it increasing
- Merge the two sorted lists into a single sorted list

### Steps
1. Traverse the DLL to find the **peak node**
2. Split the list at the peak node:
   - First list: from head to peak node
   - Second list: from node after peak to the end
3. Reverse the second list
4. Merge the two sorted lists
5. The merged list is the final sorted doubly linked list

## Example

Input:
1 <-> 5 <-> 8 <-> 12 <-> 11 <-> 7 <-> 6 <-> 2  

Peak Element:
12  

After Splitting:
Increasing Part: 1 <-> 5 <-> 8 <-> 12  
Decreasing Part: 11 <-> 7 <-> 6 <-> 2  

After Reversing Decreasing Part:
2 <-> 6 <-> 7 <-> 11  

Final Output:
1 <-> 2 <-> 5 <-> 6 <-> 7 <-> 8 <-> 11 <-> 12  

## Output Explanation
- The bitonic list is converted into two sorted lists
- Both lists are merged to form a single fully sorted doubly linked list

## Time and Space Complexity

**Time Complexity:** `O(n^2)`  
The algorithm may involve nested traversals during sorting and merging.

**Space Complexity:** `O(1)`  
Sorting is done by rearranging node pointers without using extra data structures.
