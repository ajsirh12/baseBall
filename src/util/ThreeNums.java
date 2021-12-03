package util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ThreeNums {

	public static Map<String, Integer> myMap;
	private Set<String> mySet;
	
	public ThreeNums() {
		myMap = new HashMap<String, Integer>();
		mySet = new HashSet<String>();
		
		while(mySet.size() != 3) {
			mySet.add(randomNum());
		}
		
		makeBaseBallNums(mySet);
	}
	
	private String randomNum() {
		int result = (int) ((Math.random()*235)%10);
		
		return Integer.toString(result);
	}
	
	private Map<String, Integer> makeBaseBallNums(Set set){
		
		Iterator nums = set.iterator();
		
		int num = 0;
		while(nums.hasNext()) {
			myMap.put(nums.next().toString(), num);
			num++;
		}
		
		return myMap;
	}
	
	public Map<String, Integer> getBaseBallNums() {
		return myMap;
	}
}
