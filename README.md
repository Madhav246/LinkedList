# LinkedList
Like arrays, Linked List is a linear data structure. Unlike arrays, linked list elements are not stored at a contiguous location; the elements are linked using pointers. They include a series of connected nodes. Here, each node stores the data and the address of the next node.

![image](https://user-images.githubusercontent.com/54050193/197471318-1684f972-75af-4fba-9b03-d7aa7c575541.png)

# Why Linked List? 
Arrays can be used to store linear data of similar types, but arrays have the following limitations:

The size of the arrays is fixed:
So we must know the upper limit on the number of elements in advance. Also, generally, the allocated memory is equal to the upper limit irrespective of the usage. 

Insertion of a new element / Deletion of a existing element in an array of elements is expensive: 
The room has to be created for the new elements and to create room existing elements have to be shifted but in Linked list if we have the head node then we can traverse to any node through it and insert new node at the required position.

# Advantages of Linked Lists over arrays:
Dynamic Array.
Ease of Insertion/Deletion.

# Drawbacks of Linked Lists: 
Random access is not allowed. We have to access elements sequentially starting from the first node(head node). So we cannot do a binary search with linked lists efficiently with its default implementation. 
Extra memory space for a pointer is required with each element of the list. 
Not cache friendly. Since array elements are contiguous locations, there is locality of reference which is not there in case of linked lists.

# Types of Linked Lists:
# Simple Linked List :
In this type of linked list, one can move or traverse the linked list in only one direction

# Doubly Linked List :
In this type of linked list, one can move or traverse the linked list in both directions (Forward and Backward)

# Circular Linked List :
In this type of linked list, the last node of the linked list contains the link of the first/head node of the linked list in its next pointer and the first/head node contains the link of the last node of the linked list in its prev pointer.

# Basic operations on Linked Lists:
Deletion, Insertion, Search, Display.

# Time Complexity	
Search --> 
Worst Case : O(n)	      
Average Case : O(n)

Insert -->
Worst Case : O(1)	      
Average Case : O(1)

Deletion -->
Worst Case : O(1)	      
Average Case : O(1)

Auxiliary Space: O(N)
