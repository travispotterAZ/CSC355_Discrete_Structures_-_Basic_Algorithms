public class BinaryTreeTest {
    public static void main(String[] args) {
        Tree tree = new Tree();

        // Test isEmpty on empty tree
        System.out.println("Tree empty? " + tree.isEmpty());                            // true
        System.out.println("Tree size: " + tree.size());                                // 0
        System.out.println("Tree height: " + tree.height());                            // 0

        // Insert nodes
        tree.put(10, 100);
        tree.put(5, 50);
        tree.put(15, 150);
        tree.put(3, 30);
        tree.put(7, 70);
        tree.put(12, 120);
        tree.put(18, 180);

        // Test isEmpty, size, height
        System.out.println("\nAfter insertions:");
        System.out.println("Tree empty? " + tree.isEmpty());                            // false
        System.out.println("Tree size: " + tree.size());                                // 7
        System.out.println("Tree height: " + tree.height());                            // 2

        // Test get
        System.out.println("\nGet values:");
        System.out.println("Get 10: " + tree.get(10));                              // 100
        System.out.println("Get 7: " + tree.get(7));                                // 70
        System.out.println("Get 20: " + tree.get(20));                              // -1 (not found)

        // Test contains
        System.out.println("\nContains key?");
        System.out.println("Contains 5: " + tree.contains(5));                      // true
        System.out.println("Contains 20: " + tree.contains(20));                    // false

        // Test height for specific nodes
        System.out.println("\nNode heights:");
        System.out.println("Height of 10 (root): " + tree.height());                      //2
        System.out.println("Height of 5: " + tree.height(5));                        //1
        System.out.println("Height of 3 (leaf): " + tree.height(3));                 //0
        System.out.println("Height of 20 (not exist): " + tree.height(20));          //-1

        // Test size for specific nodes
        System.out.println("\nSubtree sizes:");                                        
        System.out.println("Size of subtree at 10 (root): " + tree.size());              //7
        System.out.println("Size of subtree at 5: " + tree.size(5));                //3
        System.out.println("Size of subtree at 3: " + tree.size(3));                //1
        System.out.println("Size of subtree at 20 (not exist): " + tree.size(20));  //-1

        // Test updating a value
        tree.put(7, 77);
        System.out.println("\nAfter updating 7:");
        System.out.println("Get 7: " + tree.get(7));                                // 77

        System.out.println("\nAll tests completed!");
    }
}

