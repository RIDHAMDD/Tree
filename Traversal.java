public class Traversal<T> {

    public void inOrder(TreeNode<T> root) { // Recursive implementation of In order traversal
        if (root != null) { // Left -> Root -> Right
            inOrder(root.getLeft()); // Recursively traverse the left subtree
            System.out.print(root.value + " "); // Print the value of the current node
            inOrder(root.getRight()); // Recursively traverse the right subtree
        }
        return;
    }

    public void inOrderQuick(TreeNode<T> root) {// Implementation of in-order traversal in O(1) space and O(n) time
        TreeNode<T> temp = root;
        if (temp == null) {// If "temp" is null, the method returns. As there is no Tree to print Inorder
                           // traversal
            return;
        }
        Stack<TreeNode<T>> stack = new Stack<>();// This line iinitialises an empty stack of type.
        while (!stack.isEmpty() || temp != null) {
            if (temp != null) {// goes forward until the every node is visited
                stack.push(temp);// Keeps adding all the Left node it encouters
                temp = temp.getLeft();// Goes to the leftmost node
            } else {
                temp = stack.pop();// Startd poping the stack of left nodes one by one
                System.out.print(temp.getVal() + " ");// printing parent of the current left node
                temp = temp.getRight();// printing right children of that parent if any
            }
        }
    }

    public void preOrder(TreeNode<T> root) {// Recursive implementation of Pre Order traversal
        if (root != null) { // Root -> Left-> Right
            System.out.print(root.value + " "); // print the value of the current node which is root
            preOrder(root.getLeft()); // recursively traverse the Left subtree
            preOrder(root.getRight()); // recursively traverse the Right subtree
        }
        return;
    }

    public void postOrder(TreeNode<T> root) { // Recursive implementation of Post Order traversal
        if (root != null) { // Left -> Right-> Root
            postOrder(root.getLeft()); // Recursively traverse the left subtree in post-order.
            postOrder(root.getRight()); // Recursively traverse the Right subtree in post-order.
            System.out.print(root.value + " "); // print the value of the root
        }
        return;
    }

    public static boolean sumTree(TreeNode<Integer> root) {
		TreeNode<Integer> node = root;
        // This if condition checks if the given node is null or if it has no left or right child node
		if (node == null || (node.getLeft() == null && node.getRight() == null)) {
			return true; //returns true as an empty tree is considered a sum tree.
		}
		int SumofLeft, SumofRight; // Temporary variables to hold the sum of the left and right child nodes.
		if (node.getLeft() == null) { //if it has no Left child then sum is Zero
			SumofLeft = 0;
		}
		if (node.getRight() == null) { //if it has no Right child then sum is Zero
			SumofRight = 0;
		}
		SumofLeft = node.getLeft().getVal();
		SumofRight = node.getRight().getVal();
		if (node.getVal() == SumofLeft + SumofRight) // chercking if root is equal to sum of left and right childs
			if (sumTree(node.getLeft())) //checking if the left sub tree of root is also a sum tree using a recurssion
				if (sumTree(node.getRight())) { //checking if the right sub tree of root is also a sum tree using a recurssion
					return true; //if reached here, it means its a sum tree
				}
		return false; //otherwise returns false
	}

    public static void main(String[] args) {
        // Tree 1
        TreeNode<Integer> n1 = new TreeNode<>(1); // Creating a Node with value 1, We haven't placed it inside tree yet
        TreeNode<Integer> n2 = new TreeNode<>(2); // Creating a Node with value 2, We haven't placed it inside tree yet
        TreeNode<Integer> n3 = new TreeNode<>(3); // Creating a Node with value 3, We haven't placed it inside tree yet
        TreeNode<Integer> n4 = new TreeNode<>(4); // Creating a Node with value 4, We haven't placed it inside tree yet
        TreeNode<Integer> n5 = new TreeNode<>(5); // Creating a Node with value 5, We haven't placed it inside tree yet
        TreeNode<Integer> n6 = new TreeNode<>(6); // Creating a Node with value 6, We haven't placed it inside tree yet
        TreeNode<Integer> n7 = new TreeNode<>(7); // Creating a Node with value 7, We haven't placed it inside tree yet
        Tree<Integer> tree1 = new Tree<>(n1); // creating a tree named tree1
        tree1.addLeft(n1, n2); //           (1)
        tree1.addRight(n1, n3);//           / \
        tree1.addLeft(n3, n4); //         (2) (3)
        tree1.addRight(n3, n5);//         / \ / \
        tree1.addLeft(n2, n6); //     (6) (7) (4) (5)
        tree1.addRight(n2, n7);

         // Tree 2 (Sum Tree)
         TreeNode<Integer> f1 = new TreeNode<>(8); // Creating a Node with value 1, We haven't placed it inside tree yet
         TreeNode<Integer> f2 = new TreeNode<>(5); // Creating a Node with value 2, We haven't placed it inside tree yet
         TreeNode<Integer> f3 = new TreeNode<>(3); // Creating a Node with value 3, We haven't placed it inside tree yet
         TreeNode<Integer> f4 = new TreeNode<>(2); // Creating a Node with value 4, We haven't placed it inside tree yet
         TreeNode<Integer> f5 = new TreeNode<>(1); // Creating a Node with value 5, We haven't placed it inside tree yet
         TreeNode<Integer> f6 = new TreeNode<>(4); // Creating a Node with value 6, We haven't placed it inside tree yet
         TreeNode<Integer> f7 = new TreeNode<>(1); // Creating a Node with value 7, We haven't placed it inside tree yet
         Tree<Integer> tree2 = new Tree<>(f1); // creating a tree named tree2
         tree2.addLeft(f1, f2); //          (8)
         tree2.addRight(f1, f3);//          / \
         tree2.addLeft(f3, f4); //      (5)    (3)
         tree2.addRight(f3, f5);//     /   \   /   \
         tree2.addLeft(f2, f6); //   (4) (1)  (2)   (1)
         tree2.addRight(f2, f7);

        Traversal<Integer> treeTraversal = new Traversal<>();
        System.out.println("inOrder");
        treeTraversal.inOrder(n1);
        System.out.println();
        System.out.println("-------------");
        System.out.println("inOrderQuick");
        treeTraversal.inOrderQuick(n1);
        System.out.println();
        System.out.println("-------------");
        System.out.println("preOrder");
        treeTraversal.preOrder(n1);
        System.out.println();
        System.out.println("-------------");
        System.out.println("postOrder");
        treeTraversal.postOrder(n1);
        System.out.println();
        System.out.println("-------------");
        System.out.print("sumTree  ");
        System.out.println(Traversal.sumTree(f1));
        System.out.print("Not sumTree  ");
        System.out.println(Traversal.sumTree(n1));
    }
}
