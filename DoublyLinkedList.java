import java.util.Scanner;

public class DoublyLinkedList {
    public class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
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
                newNode.prev = current;
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
            if (head != null){ head.prev = null; } //update new head prev pointer to null
            return;
        }

        Node current = head;
        if (option == 'L') {
            while (current.next != null) { //iterate till last node
                current = current.next;
            }
            
            if (current.prev != null) {     //now on last node, make node before it no longer have a next node pointed to.
                current.prev.next = null;
            } 
            
            else { head = null; } //if last node is head node
            
            System.out.println("Last Node [" + current.data + "] deleted.");
            return;
        }

        System.out.print("Input Node for Deletion: "); //specific case for target integer element
        int target = scanner.nextInt();
        
        current = head;
        while (current != null) {
            if (current.data == target) {
                if (current.prev != null) {current.prev.next = current.next;} //if target is not head case, update previous node to skip target

                else {head = current.next;} //if target is head, then update head to next node
                
                if (current.next != null) {current.next.prev = current.prev;} //if the target had a next node, update the next node's previous

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
        double startTime = System.nanoTime(); //record time search starts

        while (current != null) {
            if (current.data == target) {
                double endTime = System.nanoTime(); //record time target is found
                System.out.println("Element [" + target + "] found.");
                System.out.println("Search time (DoublyLinkedList): " + (endTime - startTime) + " ns"); //difference would equal time spent searching
                return (endTime - startTime);
            }
            current = current.next;
        }

        long endTime = System.nanoTime(); //record time end of list is reacheded and target is not found
        System.out.println("Element [" + target + "] not found.");
        System.out.println("Search time (DoublyLinkedList): " + (endTime - startTime) + " ns");
        return (endTime - startTime);
    }

    // Prompt user for traversal direction
    public void Traversal(Scanner scanner) {

        System.out.println("Traverse Forward (F) or Backward (B)?");
        System.out.print("Input Option: ");
        char option = scanner.next().charAt(0);

        if (option == 'F') {
            traverseForward();
        } else if (option == 'B') {
            traverseBackward();
        } else {
            System.out.println("Invalid option. Please enter F or B.");
        }
    }

    // Forward traversal
    public void traverseForward() {
        Node current = head;
        while (current != null) {
            System.out.print("[" + current.data + "]");
            if (current.next != null) { System.out.print(" <-> "); }
            
            current = current.next;
        }
        System.out.println();
    }

    // Backward traversal
    public void traverseBackward() {
        Node current = head;
        while (current != null && current.next != null) { //traverse to last node
            current = current.next;
        }

        while (current != null) {
            System.out.print("[" + current.data + "]");
            if (current.prev != null) { System.out.print(" <-> "); } 
            current = current.prev;
        }
        System.out.println();
    }


    public Node getHead() {
        return head;
    }
}