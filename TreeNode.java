public class TreeNode<T> {
    public T value;
    private TreeNode<T> parent = null;
    private TreeNode<T> left = null;
    private TreeNode<T> right = null;

    public TreeNode(T v) {
        this.value = v;
    }

    public T getVal() {
        return value;
    }

    public void addLeft(TreeNode<T> t) {//sets the "Left" node to "t". It also sets the "parent" node variable of "t" to the current instance of the class.
        this.left = t;
        t.parent = this;
    }

    public void addRight(TreeNode<T> t) {//sets the "Right" node to "t". It also sets the "parent" node variable of "t" to the current instance of the class.
        this.right = t;
        t.parent = this;
    }

    public TreeNode<T> getLeft() {//This method returns the value of the "LEft" node.
        return this.left;
    }

    public TreeNode<T> getRight() {//This method returns the value of the "Right" node.
        return this.right;
    }

    public TreeNode<T> getParent() {//This method returns the value of the "parent" node.
        return this.parent;
    }
    public String toString() { //This method returns a string representation of the node's value.
        String st="";
        st+= value;
        return st;
    }
}
