package stableMatching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		List<String> clients   = Arrays.asList(new String[] {"D", "E", "F"});
		List<String> employees = Arrays.asList(new String[] {"A", "B", "C"});
		@SuppressWarnings("serial")
		Map<String, List<String>> clientsPrefer = new HashMap<String, List<String>>(){{
			put("D", Arrays.asList("B", "A", "C"));
			put("E", Arrays.asList("B", "C", "A"));
			put("F", Arrays.asList("C", "A", "B"));
		}};
		@SuppressWarnings("serial")
		Map<String, List<String>> employeesPrefer = new HashMap<String, List<String>>(){{
			put("A", Arrays.asList("D", "E", "F"));
			put("B", Arrays.asList("F", "E", "D"));
			put("C", Arrays.asList("D", "E", "F"));
		}};
		
		stableMatcher matcher = new stableMatcher(clients, employees, clientsPrefer, employeesPrefer);
		Map<String, String> matches = matcher.getMatches();
		matcher.printMatches(matches);
		
	
	}
}
