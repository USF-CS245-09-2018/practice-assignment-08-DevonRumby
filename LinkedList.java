public class LinkedList implements List{
	Node head;
	LinkedList list;
	@Override
	public void add(Object obj) throws Exception {
		Node curr = head;
		if(head == null) {
			head = new Node(obj);
		}
		else {
			while(curr.hasNext()) {
				curr = curr.next;
			}
			curr.next = new Node(obj);
		}
		
	}

	@Override
	public void add(int pos, Object obj) throws Exception {
		Node curr = head;
		Node move;
		Node newNode = new Node(obj);
		int i = 0;
		if(curr == null) {
			head = new Node(obj);
			return;
		}
		while(curr.hasNext() && i < pos - 1) {
			curr = curr.next;
			i++;
		}
		move = curr.next;
		curr.next = newNode;
		newNode.next = move;
	}

	@Override
	public Object get(int pos) throws Exception {
		Node curr = head;
		int i = 0;
		while(curr.hasNext() && i < pos) {
			curr = curr.next;
			i++;
		}
		return curr.data;
	}

	@Override
	public Object remove(int pos) throws Exception {
		Node curr = head;
		Node temp;
		Node removeNode;
		int i = 0;
		if(pos == 0) {
			head =head.next;
			return curr.data;
		}
		while(curr.hasNext() && i < pos - 1) {
			curr = curr.next;
			i++;
		}
		removeNode = curr.next;
		temp = removeNode.next;
		curr.next = temp;
		return removeNode.data;
	}

	@Override
	public int size() {
		Node curr = head;
		int i = 0;
		if(curr == null) {
			return i;
		}
		while(curr.hasNext()) {
			curr = curr.next;
			i++;
		}
		return i + 1;
	}
	
	class Node{
		Object data;
		Node next;
		Node(Object obj){
			data = obj;
		}
		
		public boolean hasNext() {
			if(next == null) {
				return false;
			}
			return true;
		}
		
	}

}
