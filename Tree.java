public class Tree<T> { // A generic Tree data structure class.
    private TreeNode<T> root;

    public Tree(TreeNode<T> head) { // Creates a new instance of the Tree class with the specified root node.
        this.root = head;
    }

    public TreeNode<T> getRoot() { // Gets the root node of the tree & returns the root node of that tree.
        return root;
    }

    public void addLeft(TreeNode<T> r1, TreeNode<T> r2) { // Adds a left child node to the specified parent node.
        r1.addLeft(r2);
    }

    public void addRight(TreeNode<T> s1, TreeNode<T> s3) { // Adds a Right child node to the specified parent node.
        s1.addRight(s3);
    }

    public int depth(TreeNode<T> node) {
        // If the node has no left or right children, then it is a leaf node, and its depth is 1.
        if (node.getLeft() == null && node.getRight() == null)
            return 1;
        // If the node has a left child but no right child, add 1 to the depth of the
        // left child and call the method again.
        if (node.getLeft() != null && node.getRight() == null)
            return 1 + this.depth(node.getLeft());
        // If the node has a right child but no left child, add 1 to the depth of the
        // right child and call the method again.
        if (node.getRight() != null && node.getLeft() == null)
            return 1 + this.depth(node.getRight());
        // If the node has both left and right children, return the maximum depth
        // between them.
        if (node.getLeft() != null && node.getRight() != null)
            return Math.max(1 + this.depth(node.getLeft()), 1 + this.depth(node.getRight()));
        // the code should never gets to this
        return -1;
    }

    public OurLinkedList<T> pathToRoot(TreeNode<T> node) { // Returns the path from a given node to the root of the tree.
        OurLinkedList<T> path = new OurLinkedList<>(); // Create an empty linked list to store the path
        TreeNode<T> curr = node; // Set the current node to the given node
        while (curr.getParent() != null) { // Iterate through the Tree until the root node is reached
            path.addFront(curr.value); // Adds the value of the current node to the beginning of the path
            curr = curr.getParent(); // Set the current node to its parent
        }
        path.addFront(curr.value); // Add the root node to the beginning of the path
        return path; // Return the linked list representing the path
    }

    public OurLinkedList<T> siblings(TreeNode<T> node) {
        OurLinkedList<T> sib = new OurLinkedList<>(); // Create a new linked list to store siblings
        TreeNode<T> curr = node; // Initialize the temporary node to the given node
        if (curr.value == root.value) { // If the current node is the root, there are no siblings
           sib.add(null); // Add null to the linked list to indicate that there are no siblings
            return sib;
        }
        curr = curr.getParent(); // Move up one generation to get the parent node
        if(curr.getLeft() == null || curr.getRight() == null){
        sib.add(null); // Add null to the linked list to indicate that there are no siblings
            return sib;
        }
        sib.add(curr.getLeft().value); // Add the values of the left child node to the linked list
        sib.add(curr.getRight().value); // Add the values of the right child node to the linked list
        return sib;
    }

    public void toString(TreeNode<T> root) {
        TreeNode<T> curr = root; // Initialize the temporary node to the given node
        if (curr != null) { // Root -> Left-> Right
            System.out.print(curr.value + " "); // print the value of the current node which is root
            toString(curr.getLeft()); // recursively traverse the Left subtree
            toString(curr.getRight()); // recursively traverse the Right subtree
        }
        return;
    }

    public TreeNode<T> LeastCommonSubsume(TreeNode<T> node1, TreeNode<T> node2) {// returns the deepest node which is a
                                                                                 // parent to both of them.
        TreeNode<T> curr1 = node1.getParent();
        TreeNode<T> curr2 = node2.getParent();
        if (curr1 == curr2)// If both nodes have the same parent, return the parent
            return curr1;
        while (curr1.getParent() != null) { // Traverses up the tree from node1 to find the least common ancestor with
                                            // node2
            curr1 = curr1.getParent();
            if (curr1 == curr2)
                return curr1;
        }
        while (curr2.getParent() != null) { // Traverses up the tree from node2 to find the least common ancestor with
                                            // node1
            curr2 = curr2.getParent();
            if (curr1 == curr2)
                return curr2;
        }
        return node1; // If no common ancestor is found, return node1 as a base case
    }

    public static void main(String[] args) {
        TreeNode<Integer> b1 = new TreeNode<>(1); // Creating a Node with value 1, We haven't placed it inside tree yet
        TreeNode<Integer> b2 = new TreeNode<>(2); // Creating a Node with value 2, We haven't placed it inside tree yet
        TreeNode<Integer> b3 = new TreeNode<>(3); // Creating a Node with value 3, We haven't placed it inside tree yet
        TreeNode<Integer> b4 = new TreeNode<>(4); // Creating a Node with value 4, We haven't placed it inside tree yet
        TreeNode<Integer> b5 = new TreeNode<>(5); // Creating a Node with value 5, We haven't placed it inside tree yet
        TreeNode<Integer> b6 = new TreeNode<>(6); // Creating a Node with value 6, We haven't placed it inside tree yet
        TreeNode<Integer> b7 = new TreeNode<>(7); // Creating a Node with value 7, We haven't placed it inside tree yet
        Tree<Integer> tree1 = new Tree<>(b1); // creating a tree named tree1
        tree1.addLeft(b1, b2); // (1)
        tree1.addRight(b1, b3);// / \
        tree1.addLeft(b3, b4); // (2) (3)
        tree1.addRight(b3, b5);// / \ / \
        tree1.addLeft(b2, b6); // (6) (7) (4) (5)
        tree1.addRight(b2, b7);

        TreeNode<Integer> o1 = new TreeNode<>(8); // Creating a Node with value 8, We haven't placed it inside tree yet
        TreeNode<Integer> o2 = new TreeNode<>(3); // Creating a Node with value 3, We haven't placed it inside tree yet
        TreeNode<Integer> o3 = new TreeNode<>(10); // Creating a Node with value 10, We haven't placed it inside tree yet
        TreeNode<Integer> o4 = new TreeNode<>(1); // Creating a Node with value 1, We haven't placed it inside tree yet
        TreeNode<Integer> o5 = new TreeNode<>(6); // Creating a Node with value 6, We haven't placed it inside tree yet
        TreeNode<Integer> o6 = new TreeNode<>(14); // Creating a Node with value 14, We haven't placed it inside tree yet
        TreeNode<Integer> o7 = new TreeNode<>(4); // Creating a Node with value 4, We haven't placed it inside tree yet
        TreeNode<Integer> o8 = new TreeNode<>(7); // Creating a Node with value 7, We haven't placed it inside tree yet
        TreeNode<Integer> o9 = new TreeNode<>(13); // Creating a Node with value 13, We haven't placed it inside tree yet
        Tree<Integer> tree2 = new Tree<>(o1); // creating a tree named tree2
        tree2.addLeft(o1, o2);
        tree2.addRight(o1, o3);
        tree2.addLeft(o2, o4);
        tree2.addRight(o2, o5);
        tree2.addLeft(o5, o7);
        tree2.addRight(o5, o8);
        tree2.addRight(o3, o6);
        tree2.addLeft(o6, o9);

        TreeNode<Integer> s1 = new TreeNode<>(11); // Creating a Node with value 11, We haven't placed it inside tree yet
        TreeNode<Integer> s2 = new TreeNode<>(2); // Creating a Node with value 2, We haven't placed it inside tree yet
        TreeNode<Integer> s3 = new TreeNode<>(14); // Creating a Node with value 14, We haven't placed it inside tree yet
        TreeNode<Integer> s4 = new TreeNode<>(1); // Creating a Node with value 1, We haven't placed it inside tree yet
        TreeNode<Integer> s5 = new TreeNode<>(7); // Creating a Node with value 7, We haven't placed it inside tree yet
        TreeNode<Integer> s6 = new TreeNode<>(15); // Creating a Node with value 15, We haven't placed it inside tree yet
        TreeNode<Integer> s7 = new TreeNode<>(5); // Creating a Node with value 5, We haven't placed it inside tree yet
        TreeNode<Integer> s8 = new TreeNode<>(8); // Creating a Node with value 8, We haven't placed it inside tree yet
        TreeNode<Integer> s9 = new TreeNode<>(6); // Creating a Node with value 6, We haven't placed it inside tree yet
        TreeNode<Integer> s10 = new TreeNode<>(9); // Creating a Node with value 9, We haven't placed it inside tree yet
        Tree<Integer> tree3 = new Tree<>(s1); // creating a tree named tree3
        tree3.addLeft(s1, s2);
        tree3.addRight(s1, s3);
        tree3.addLeft(s2, s4);
        tree3.addRight(s2, s5);
        tree3.addRight(s3, s6);
        tree3.addLeft(s5, s7);
        tree3.addRight(s5, s8);
        tree3.addRight(s8, s10);
        tree3.addLeft(s8, s9);

        TreeNode<Integer> e1 = new TreeNode<>(0); // Creating a Node with value 0, We haven't placed it inside tree yet
        TreeNode<Integer> e2 = new TreeNode<>(1); // Creating a Node with value 1, We haven't placed it inside tree yet
        TreeNode<Integer> e3 = new TreeNode<>(2); // Creating a Node with value 2, We haven't placed it inside tree yet
        TreeNode<Integer> e4 = new TreeNode<>(3); // Creating a Node with value 3, We haven't placed it inside tree yet
        TreeNode<Integer> e5 = new TreeNode<>(4); // Creating a Node with value 4, We haven't placed it inside tree yet
        Tree<Integer> tree4 = new Tree<>(e1); // creating a tree named tree4
        tree4.addRight(e1, e2);
        tree4.addRight(e2, e3);
        tree4.addRight(e3, e4);
        tree4.addRight(e4, e5);

        TreeNode<String> r1 = new TreeNode<>("C"); // Creating a Node with value "C",  We haven't placed it inside tree yet
        TreeNode<String> r2 = new TreeNode<>("A"); // Creating a Node with value "A",We haven't placed it inside tree yet
        TreeNode<String> r3 = new TreeNode<>("O"); // Creating a Node with value "O", We haven't placed it inside tree yet
        TreeNode<String> r4 = new TreeNode<>("T"); // Creating a Node with value "T",We haven't placed it inside tree yet
        TreeNode<String> r5 = new TreeNode<>("B"); // Creating a Node with value "B",We haven't placed it inside tree yet
        TreeNode<String> r6 = new TreeNode<>("W"); // Creating a Node with value "W",We haven't placed it inside tree yet
        TreeNode<String> r7 = new TreeNode<>("S"); // Creating a Node with value "S",We haven't placed it inside tree yet
        TreeNode<String> r8 = new TreeNode<>("S"); // Creating a Node with value "S",We haven't placed it inside tree yet
        Tree<String> tree5 = new Tree<>(r1); // creating a tree named tree5
        tree5.addLeft(r1, r2);
        tree5.addRight(r1, r3);
        tree5.addLeft(r2, r4);
        tree5.addLeft(r4, r7);
        tree5.addLeft(r3, r5);
        tree5.addRight(r3, r6);
        tree5.addRight(r6, r8);

         // Tree 2
         TreeNode<Integer> f1 = new TreeNode<>(8); // Creating a Node with value 8, We haven't placed it inside tree yet
         TreeNode<Integer> f2 = new TreeNode<>(5); // Creating a Node with value 5, We haven't placed it inside tree yet
         TreeNode<Integer> f3 = new TreeNode<>(3); // Creating a Node with value 3, We haven't placed it inside tree yet
         TreeNode<Integer> f4 = new TreeNode<>(2); // Creating a Node with value 2, We haven't placed it inside tree yet
         TreeNode<Integer> f5 = new TreeNode<>(1); // Creating a Node with value 1, We haven't placed it inside tree yet
         TreeNode<Integer> f6 = new TreeNode<>(4); // Creating a Node with value 4, We haven't placed it inside tree yet
         TreeNode<Integer> f7 = new TreeNode<>(1); // Creating a Node with value 1, We haven't placed it inside tree yet
         Tree<Integer> tree6 = new Tree<>(f1); // creating a tree named tree6
         tree6.addLeft(f1, f2); //          (8)
         tree6.addRight(f1, f3);//          / \
         tree6.addLeft(f3, f4); //      (5)    (3)
         tree6.addRight(f3, f5);//     /   \   /   \
         tree6.addLeft(f2, f6); //   (4) (1)  (2)   (1)
         tree6.addRight(f2, f7);

        System.out.println("Depth " + tree1.depth(b2));
        System.out.println("PathtoRoot " + tree2.pathToRoot(o4));
        System.out.println("Siblings " + tree3.siblings(s7));
        tree1.toString(b1);
        System.out.println();
        System.out.println("LeastCommonSubsume " + tree4.LeastCommonSubsume(e2, e4));
        System.out.println("*************");
        tree5.toString(r1);
        System.out.println();
        System.out.println("Depth " + tree5.depth(r2));
        System.out.println("PathtoRoot " + tree5.pathToRoot(r4));
        System.out.println("Siblings " + tree5.siblings(r7));
        System.out.println("LeastCommonSubsume " + tree5.LeastCommonSubsume(r2, r4));
    }
}