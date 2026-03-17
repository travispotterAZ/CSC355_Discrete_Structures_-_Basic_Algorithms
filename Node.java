class Node {
    public int key;
    public int value;
    public int height;
    public int size;
    public Node left;
    public Node right;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.left = this.right = null;
        this.size = 1;
        this.height = 0;
    }

    public int getSize() {
        return this.size;
    }
}


