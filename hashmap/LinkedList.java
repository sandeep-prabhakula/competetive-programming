package hashmap;

public class LinkedList {
	Node head = null;
	public void insert(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	public void traverse(Node head) {
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	public boolean findNode(Node head,int k) {
		while(head!=null) {
			if(head.data==k)return true;
			head = head.next;
		}
		return false;
	}
}
class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
	}
}