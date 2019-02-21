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
