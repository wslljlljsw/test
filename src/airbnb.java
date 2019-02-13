import java.util.*;


public class airbnb {
	
	static List<String> evaluateActions(List<String> actions) {
		String dead = "[dead]";
		HashMap<String,String> support = new HashMap<>();
		HashMap<String,Integer> power = new HashMap<>();
		HashMap<String,ArrayList<String>> location = new HashMap<>();
		HashMap<String, String> result = new HashMap<>();
		ArrayList<String> output = new ArrayList<>();
		
		for(String action : actions) {
			String[] s = action.split(" ");
			ArrayList<String> list = location.getOrDefault(s[2].equals("Move")?s[3]:s[1], new ArrayList<String>());
			if(list.size() == 1 && support.containsKey(list.get(0))) {
				String supported = support.get(list.get(0));
				power.put(supported,power.get(supported)-1);
			}
			list.add(s[0]);
			location.put(s[2].equals("Move")?s[3]:s[1], list);
			power.put(s[0], power.getOrDefault(s[0], 0)+1);
			
			if(s[2].equals("Support") && list.size() == 1) {
				support.put(s[0], s[3]);
				power.put(s[3], power.getOrDefault(s[3], 0)+1);
			}
		}
//			if(s[2].equals("Hold")) {
//				ArrayList<String> list = location.getOrDefault(s[1], new ArrayList<String>());
//				if(list.size() == 1 && support.containsKey(list.get(0))) {
//					String supported = support.get(list.get(0));
//					power.put(supported,power.get(supported)-1);
//				}
//				list.add(s[0]);
//				location.put(s[1], list);
//				power.put(s[0], power.getOrDefault(s[0], 0)+1);
//			}
//			else if(s[2].equals("Move")) {
//				ArrayList<String> list = location.getOrDefault(s[3], new ArrayList<String>());
//				if(list.size() == 1 && support.containsKey(list.get(0))) {
//					String supported = support.get(list.get(0));
//					power.put(supported,power.get(supported)-1);
//				}
//				list.add(s[0]);
//				location.put(s[3], list);
//				power.put(s[0], power.getOrDefault(s[0], 0)+1);
//			}
//			else if(s[2].equals("Support")) {
//				ArrayList<String> list = location.getOrDefault(s[1], new ArrayList<String>());
//				if(list.size() == 1 && support.containsKey(list.get(0))) {
//					String supported = support.get(list.get(0));
//					power.put(supported,power.get(supported)-1);
//				}
//				list.add(s[0]);
//				location.put(s[1], list);
//				power.put(s[0], power.getOrDefault(s[0], 0)+1);
//				
//				if(list.size() == 1) {
//					support.put(s[0], s[3]);
//					power.put(s[3], power.getOrDefault(s[3], 0)+1);
//				}
//			}
//		}
		
		for(String loc : location.keySet()) {
			ArrayList<String> list = location.get(loc);
			int maxpow = 0;
			int maxnum = 0;
			String bestarmy = "";
			for(String army : list) {
				if(power.get(army) > maxpow) {
					maxpow = power.get(army);
					maxnum = 1;
					bestarmy = army;
				}
				else if(power.get(army) == maxpow) maxnum++;
			}
			if(maxnum > 1) {
				for(String army : list) {
					result.put(army, dead);
				}
			}
			else {
				for(String army : list) {
					if(!army.equals(bestarmy)) result.put(army, dead);
					else result.put(army, loc);
				}
			}
		}
		
		for(String action : actions) {
			String[] s = action.split(" ");
			output.add(s[0]+" "+result.get(s[0]));
		}
		return output;
    }
}
