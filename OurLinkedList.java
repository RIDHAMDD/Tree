public class OurLinkedList<T> { //Implementation of a LinkedList
	private Node head;

	public class Node {
		public T value;
		public Node next;

		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
		}
	}

	public void addFront(T newItem) {  // add toAdd to the front of the list
		Node newNode = new Node(newItem, head);
		head = newNode;
	}

	public void add(T toAdd) { // add toAdd to the end of the list

		Node curr = head;
		if (curr == null) { // special case: adding to empty list
			addFront(toAdd);
			return;
		}

		while (curr.next != null) { // advance curr so it points at the last node
			curr = curr.next;
		}
		Node newNode = new Node(toAdd, null);
		curr.next = newNode;
	}

	public String toString() {
		Node curr = head;
		String result = "";
		while (curr != null) {
			result += curr.value;
			if (curr.next != null) {
				result += "-";
			}
			curr = curr.next;
		}
		return result;
	}
}
