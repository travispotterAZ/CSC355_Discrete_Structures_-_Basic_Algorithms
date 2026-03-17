public class Tree {
    private Node root;
    private int size;
    private int height;
    
    // Constructor
    public Tree() {
        this.root = null;
        this.size = 0;
        this.height = 0;  
    }

    //PUT (insert)
    public void put(int key, int value) { //Insert method
        if(this.root == null) { //Set root node if empty (null)
            this.root = new Node(key, value);
            this.height = 0;
            this.size = 1;
            return;
        }
        
        insertRecursive(this.root, key, value, this.height); //If root is already set, start a recursive call to find position for new Node
        return;
    }

    private Node insertRecursive(Node current, int key, int value, int currHeight) { //Recursive insert method
        //Nodes are returned to previous call to set left/rigth child pointers

        if(current == null){ //Found a null position, insert new Node here
            this.size++;
            if(currHeight < 0){ //Update height of tree if new node is added at a deeper level
                this.height = this.height + 1;
                currHeight = 0;
            }
            Node newNode = new Node(key, value);
            newNode.height = 0; //bottom of a chain
            return newNode;
        }

        else if(key < current.key){ //Go left
            current.left = insertRecursive(current.left, key, value, currHeight - 1);
        }

        else if (key > current.key){  //Go right
            current.right = insertRecursive(current.right, key, value, currHeight - 1);
        }

        else{ //Key already exists, update value
            current.value = value;
        }

        int maxChildHeight =  getMaxNodeHeight(current.left, current.right); 


        current.height = 1 + maxChildHeight;
        current.size = 1 + getNodeSize(current.left) + getNodeSize(current.right); //Update size of current node (Use getNodeSize to avoid null error thrown)
        return current; //Return current node to previous call
    }

    public int getMaxNodeHeight(Node left, Node right){ //used for avoiding null node height access
        int leftHeight = (left != null) ? left.height : 0;
        int rightHeight = (right != null) ? right.height : 0;
        
        if(leftHeight > rightHeight){
            return leftHeight;
        }
        else{
            return rightHeight;
        }
    }

    public int getNodeSize(Node node){ //makes sure no null node trys to acess a size
        if(node == null){
            return 0;
        }
        return node.size;
    }

    //GET
    public int get(int key){
            return searchRecursive(this.root, key);
    }

    public int searchRecursive(Node current, int key){ //used in get & contains
        if(current == null){
            return -1; //Key not found
        }

        else if(key == current.key){
            return current.value; //Key found
        }
        
        else if(key < current.key){ //Go left
            return searchRecursive(current.left, key);
        }

        else if(key > current.key){ //Go right
            return searchRecursive(current.right, key);
        }
        
        return -1;
    }

    //isEMPTY
    public boolean isEmpty() {
        return this.size == 0;
    }

    //SIZE of tree
    public int size(){
        return this.size;
    }

    //HEIGHT of tree
    public int height(){
        return this.height;
    }

    //HEIGHT of specific key
    public int height(int key){
        return heightRecursive(this.root, key);
    }
    //used for height of specific key
    public int heightRecursive(Node current, int key){ 
        if(current == null){
            return -1; //Key not found
        }

        else if(key == current.key){
            return current.height; //Key found
        }
        
        else if(key < current.key){ //Go left
            return heightRecursive(current.left, key);
        }

        else{ //Go right
            return heightRecursive(current.right, key);
        }

    }

    //CONTAINS
    public boolean contains(int key){
        return (searchRecursive(this.root, key) != -1);
    }

    //SIZE of specific key subset tree (inclusice)
    public int size(int key){
        return sizeRecursive(this.root, key);
    }
    //used for size of specific key
    public int sizeRecursive(Node current, int key){ 
        if(current == null){
            return -1; //Key not found
        }

        else if(key == current.key){
            return current.size; //Key found
        }
        
        else if(key < current.key){ //Go left
            return sizeRecursive(current.left, key);
        }

        else if(key > current.key){ //Go right
            return sizeRecursive(current.right, key);
        }
        
        return 0;
    }
}
