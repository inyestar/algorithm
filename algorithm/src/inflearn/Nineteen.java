package inflearn;

import java.util.Map;
import java.util.TreeMap;

public class Nineteen {

	static void recurvie(int i) {
		System.out.println(i);
		recurvie(++i);
	}
	
	public static void main(String[] args) {
		Map<String, String> tree = new TreeMap<>();
		tree.put("a", "a");
		tree.put("b", "b");
		tree.get("a");
	}

}
