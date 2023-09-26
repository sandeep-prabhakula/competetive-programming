class Solution {

    public static LinkedListNode<Integer> mergeKLists(LinkedListNode<Integer>[] listArray) {

        // Write your code here.

        PriorityQueue<Integer>pq = new PriorityQueue();
		for(LinkedListNode<Integer>head:listArray){
			while(head!=null){
				pq.add(head.data);
				head = head.next;
			}
		}
		LinkedListNode<Integer>head = new LinkedListNode<Integer>(0);
		LinkedListNode<Integer>dummy = head; 
		while(!pq.isEmpty()){
			int top = pq.poll();
			head.next = new LinkedListNode(top);
			head = head.next;
		}
		return dummy.next;

    }

}
