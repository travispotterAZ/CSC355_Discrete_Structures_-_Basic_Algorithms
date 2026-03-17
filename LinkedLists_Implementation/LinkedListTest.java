import java.util.Scanner;

public class LinkedListTest {
    public static void main(String[] args) {
        //Insert (I), Delete (D), Search (S), Traversal (T), Exit (E)
        char userIn = ' ';
        int numInserts = 0;
        double searchSimple = 0.0;
        double searchDouble = 0.0;

        SimplyLinkedList link1 = new SimplyLinkedList();

        Scanner scanner = new Scanner(System.in);


        System.out.println("TEST #1: SIMPLY LINKED LIST");
        System.out.println("Insert(I), Delete (D), Search (S), Traversal (T), Exit (E)");
        System.out.print("Input: ");

        userIn = scanner.next().charAt(0);

        while(userIn != 'E'){
            switch(userIn){
                case 'I':
                    System.out.print("Input Number of Inserts: ");
                    numInserts = scanner.nextInt();
                    link1.Insertion(numInserts, scanner);
                    break;
                
                case 'D':
                    link1.Deletion(scanner);
                    break;
                
                case 'S':
                    System.out.print("Input Element for Search: ");
                    int element = scanner.nextInt();
                    searchSimple = link1.Search(element);
                    break;
                
                case 'T':
                    link1.Traversal();
                    break;
                
                case 'E':
                    System.out.println("Program Exited.");
                    return;
                
                default:
                    System.out.println("Operation not found.");
                    break;
            }
            

            System.out.print("Next Operation Input: ");
            userIn = scanner.next().charAt(0);
        }


        System.out.println("Program Simple Linked List exited.");
        System.out.println();

        userIn = ' ';
        numInserts = 0;
        DoublyLinkedList link2 = new DoublyLinkedList();

        System.out.println("TEST #2: Doubly Linked List");
        System.out.println("Insert(I), Delete (D), Search (S), Traversal (T), Exit (E)");
        
        System.out.print("Input: ");
        userIn = scanner.next().charAt(0);

       while(userIn != 'E'){
            switch(userIn){
                case 'I':
                    System.out.print("Input Number of Inserts: ");
                    numInserts = scanner.nextInt();
                    link2.Insertion(numInserts, scanner);
                    break;
                
                case 'D':
                    link2.Deletion(scanner);
                    break;
                
                case 'S':
                    System.out.print("Input Element for Search: ");
                    int element = scanner.nextInt();
                    searchDouble = link2.Search(element);
                    break;
                
                case 'T':
                    link2.Traversal(scanner);
                    break;
                
                case 'E':
                    System.out.println("Program Exited.");
                    return;
                
                default:
                    System.out.println("Operation not found.");
                    break;
            }
            

            System.out.print("Next Operation Input: ");
            userIn = scanner.next().charAt(0);
        }        

        System.out.println("Program Simple Linked List exited.");
        System.out.println("Tests Compltete.");
        System.out.println();
        System.out.println("Simple List Search Time: " + searchSimple);
        System.out.println("Double List Search Time: " + searchDouble);

        

        scanner.close();
    }
}
