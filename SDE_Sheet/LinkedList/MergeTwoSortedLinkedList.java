import java.io.*;
import java.util.* ;


public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> l1, LinkedListNode<Integer> l2) {
        if(l1==null)return l2;
        if(l2 == null)return l1;
        LinkedListNode<Integer>prev = new LinkedListNode(-1);
        LinkedListNode<Integer>d = prev;
        while(l1!=null && l2!=null){
            if(l1.data<=l2.data){
                prev.next= l1;
                l1 = l1.next;
                prev = prev.next;
            }else{
                prev.next = l2;
                l2 = l2.next;
                prev = prev.next;
            }
        }
        if(l1!=null)prev.next = l1;
        if(l2!=null)prev.next = l2;
        return d.next;
	}
}
