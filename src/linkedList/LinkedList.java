package linkedList;

// Java program to implement
// a Single Linked List
public class LinkedList {
    // head of list
    Node head;

    // Method to insert a new node
    public static LinkedList insert(LinkedList list, int data) {
        // Create a new node with given data
        Node newNode = new Node(data);
        newNode.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (list.head == null) {
            list.head = newNode;
        } else {
            // Else traverse till the last node
            // and insert the new node there
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new node at last node
            last.next = newNode;
        }

        return list;
    }

    // Methdod to print the Linked List
    public static void printList(LinkedList list) {
        Node currentNode = list.head;

        System.out.println("LinkedList: ");

        // Traverse through the LinkedList
        while (currentNode != null) {
            // Print the data at the current node
            System.out.println(currentNode.data + " ");

            // Go to the next node
            currentNode = currentNode.next;
        }
    }

    /* DELETION BY KEY */

    // Method to delete a node in the LinkedList by KEY
    public static LinkedList deleteByKey(LinkedList list, int key) {

        // Store head node
        Node currNode = list.head, prev = null;

        //
        // CASE 1:
        // If head node itself holds the key to be deleted

        if (currNode != null && currNode.data == key) {
            // Changed head
            list.head = currNode.next;

            // Display the message
            System.out.println(key + " found and deleted");

            // Return the updated list
            return list;
        }

        //
        // CASE 2:
        // If the key is somewhere other than at head
        //

        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && currNode.data != key) {
            // If currNode does not hold key
            // continue to next node
            prev = currNode;
            currNode = currNode.next;
        }

        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
            prev.next = currNode.next;

            // Display the message
            System.out.println(key + " found and deleted");
        }

        //
        // CASE 3: The key is not present
        //

        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(key + " not found");
        }

        // return the list
        return list;
    }

    // Driver code
    public static void main(String[] args) {

        // Start with an empty list
        LinkedList list = new LinkedList();

        /*
        INSERTION
         */

        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);

        // Print the LinkedList
        printList(list);

        /*
        DELETION BY KEY
         */

        // Delete node with value 1
        // In this case the key is ***at head***
        deleteByKey(list, 1);

        // Print the LinkedList
        printList(list);

        // Delete node with value 1
        // In this case the key is ***in the middle***
        deleteByKey(list, 4);

        // Print the LinkedList
        printList(list);

        // Delete node with value 1
        // In this case the key is ***not present***
        deleteByKey(list, 10);

        // Print the LinkedList
        printList(list);
    }

    // Linked list Node
    // This inner class in made static
    // so that main() can access it
    static class Node {
        int data;
        Node next;

        // Constructor to create a new node
        // Next is bu default initialized
        // as null
        Node(int d) {
            data = d;
            next = null;
        }
    }
}
