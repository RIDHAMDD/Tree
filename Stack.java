public class Stack<E> {

    private Node<E> head;// The Stack class here uses a linked list implementation with a Node class to
                         // represent each element in the stack.
    int count = 0;

    @SuppressWarnings("hiding") // Supress as it is showing an error "Type parameter E is hiding type E"
    public class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void push(E newItem) {// adds a new item to the top of the stack by creating a new Node with the given
                                 // value and pointing it to the current top element

        Node<E> newNode = new Node<>(newItem, head);
        head = newNode;
        count++;
    }

    public E pop() {// removes and returns the top element from the stack
        if (head == null) {// If the stack is empty
            System.out.println("Stack is Empty");
        }
        Node<E> temp = head;
        head = head.next; // next element is now on thee top
        count--;// Decrases size
        return temp.value;// Returns the the top element
    }

    public E peek() {
        if (head == null) {
            System.out.println("Stack is Empty");
        }
        return head.value;// returns the value of the top element in the stack without removing it.
    }

    public Boolean isEmpty() {
        return head == null;// eturns true if the stack is empty or false otherwise
    }

    public int size() {// returns the number of elements in the stack
        return count;
    }
}
