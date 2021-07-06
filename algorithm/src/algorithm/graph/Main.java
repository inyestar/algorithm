package algorithm.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
		Map<String, List<String>> dict = new HashMap<>();
		dict.put("A", Arrays.asList("B", "C"));
		dict.put("B", Arrays.asList("A", "D"));
		dict.put("C", Arrays.asList("A", "G", "H", "I"));
		dict.put("D", Arrays.asList("B", "E", "F"));
		dict.put("E", Arrays.asList("D"));
		dict.put("F", Arrays.asList("D"));
		dict.put("G", Arrays.asList("C"));
		dict.put("H", Arrays.asList("C"));
		dict.put("I", Arrays.asList("C", "J"));
		dict.put("J", Arrays.asList("I"));
		
		
		Graph call = new BreadthFirstSearch(dict, "A");
		call.doExecute();
	}

}
