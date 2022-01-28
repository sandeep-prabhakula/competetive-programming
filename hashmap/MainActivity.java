package hashmap;

public class MainActivity {

	public static void main(String[] args) {
		HashMap map = new HashMap(10);
		map.put(22);
		map.put(32);
		map.put(42);
		map.put(52);
		map.put(62);
		
		// returns the entire bucket present in the index;
		map.get(72);
		
		System.out.println(map.containsKey(72));
	}

}
