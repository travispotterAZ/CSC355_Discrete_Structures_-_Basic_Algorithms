import java.util.Scanner;

public class SimplyLinkedList {
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Insert N elements into the list
    public void Insertion(int numInserts, Scanner scanner) {
        for (int i = 0; i < numInserts; i++) {
            System.out.print("Input Element: ");
            int value = scanner.nextInt();
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
            } 
            
            else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }
    }

    // Delete node by first, last, or value
    public void Deletion(Scanner scanner) {
        System.out.println("First (F), Last (L), By Element (B)");
        System.out.print("Input Option: ");
        char option = scanner.next().charAt(0);

        if (option == 'F') {
            System.out.println("Node [" + head.data + "] deleted.");
            head = head.next;
            return;
        }

        if (option == 'L') {
            Node current = head;
            if (current.next == null) { //head nodes is also last node (only node)
                System.out.println("Last Node [" + current.data + "] deleted.");
                head = null;
                return;
            }

            while (current.next.next != null) { //iterate to second to last node
                current = current.next;
            }

            System.out.println("Last Node [" + current.next.data + "] deleted.");
            current.next = null; //update second to last node to no longer point to "last node"
            return;
        }

        System.out.print("Input Node for Deletion: ");  //specific value
        int target = scanner.nextInt();

        if (head.data == target) {
            head = head.next;   //no longer inlcude head
            System.out.println("Node [" + target + "] deleted.");
            return;
        }

        Node current = head;
        while (current.next != null) { 
            if (current.next.data == target) { //check the next nodes data, if it matches point to the node after it
                current.next = current.next.next;
                System.out.println("Node [" + target + "] deleted.");
                return;
            }
            current = current.next;
        }

        System.out.println("Node [" + target + "] not found.");
    }

    // Search for an element and measure time
    public double Search(int target) {
        Node current = head;
        double startTime = System.nanoTime(); //record start of search

        while (current != null) {
            if (current.data == target) {
                double endTime = System.nanoTime();  //record time target is found
                System.out.println("Element [" + target + "] found.");
                System.out.println("Search time (SimplyLinkedList): " + (endTime - startTime) + " ns"); //difference is time taken
                return (endTime - startTime);
            }
            current = current.next;
        }

        double endTime = System.nanoTime(); //time to reach end of list & node not found
        System.out.println("Element [" + target + "] not found.");
        System.out.println("Search time (SimplyLinkedList): " + (endTime - startTime) + " ns");
        return (endTime - startTime);
    }

    // Traverse and print the list
    public void Traversal() {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.data + "]");
            if (current.next != null) { System.out.print(" <-> "); }
            current = current.next;
        }
        System.out.println();
    }

    public Node getHead() {
        return head;
    }
}