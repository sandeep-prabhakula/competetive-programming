package hashmap;

import java.util.Arrays;

public class HashMap {
	LinkedList arr[];
	public HashMap(int size) {
		this.arr = new LinkedList[size];
		Arrays.fill(arr,null);
	}
	public int hashFunction(int k) {
		return k%arr.length;
	}
	
	//seperate chaining
	public void put(int k) {
		if(arr[hashFunction(k)]==null) {
			arr[hashFunction(k)] = new LinkedList();
			arr[hashFunction(k)].insert(k);
		}else {
			arr[hashFunction(k)].insert(k);
		}
	}
	
	public void get(int k) {
		boolean isFound = arr[hashFunction(k)].findNode(arr[hashFunction(k)].head, k);
		if(!isFound) {
			System.out.println("No data found with key "+k);
			return ;
		}else {
			arr[hashFunction(k)].traverse(arr[hashFunction(k)].head);
		}
	}
	
	public boolean containsKey(int k) {
		return arr[hashFunction(k)].findNode(arr[hashFunction(k)].head, k);
	}
}
