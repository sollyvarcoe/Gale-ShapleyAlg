package stableMatching;

import java.util.*;

public class stableMatcher {
	private List<String> Offerers;
	private List<String> Recievers;
	private Map<String, List<String>> offererPreferences;
	private Map<String, List<String>> recieverPreferences;
	
	public stableMatcher(List<String> Offerers, List<String> Recievers, 
			Map<String, List<String>> offererPreferences, Map<String, List<String>> recieverPreferences) {
		this.Offerers = Offerers;
		this.Recievers = Recievers;
		this.offererPreferences = offererPreferences;
		this.recieverPreferences = recieverPreferences;
		match(Offerers, Recievers, offererPreferences, recieverPreferences);
		
		
	}
	
	private Map<String, String> match(List<String> Offerers, List<String> Recievers, 
			Map<String, List<String>> offererPreferences, Map<String, List<String>> recieverPreferences) {
		Map<String, String> matched = new TreeMap<String, String>();
		List<String> availableOfferers = new LinkedList<String>();
		availableOfferers.addAll(Offerers);
		
		while(!availableOfferers.isEmpty()) {
			String availableOfferer = availableOfferers.get(0);
			availableOfferers.remove(0);
			List<String> availableOffererPref = offererPreferences.get(availableOfferer);
			
				for (String reciever : availableOffererPref) {
					String currentOfferer = matched.get(reciever);
					if (currentOfferer == null) {
						matched.put(reciever, availableOfferer);
						break;
					}
					else {
						List<String> recieverPref = recieverPreferences.get(reciever);
						if(recieverPref.indexOf(currentOfferer) > recieverPref.indexOf(availableOfferer)) {
							matched.put(reciever, availableOfferer);
							availableOfferers.add(currentOfferer);
							break;
						}
					}
				}
					
		}
		return matched;
	}
	
	public Map<String, String> getMatches(){
		return this.match(Offerers, Recievers, offererPreferences, recieverPreferences);

	}
	
	public void printMatches(Map<String, String> matches) {

		for (Map.Entry<String, String> match : matches.entrySet()) {
			System.out.println(match.getKey() + " matches with " + match.getValue());
		}
	}
	
}
