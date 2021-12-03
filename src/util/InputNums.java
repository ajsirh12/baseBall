package util;

import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class InputNums {
	
	public boolean chkScore(Map<String, Integer> param, String nums) {
		boolean flag = true;
		
		int strike = 0;
		int ball = 0;
		
		for(int i=0;i<nums.length();i++) {
			Integer loc = param.get(String.valueOf(nums.charAt(i)));
			if(loc == null) {
//				System.out.println("nothing");
			}
			else if(loc == i) {
				strike++;
			}
			else if(loc != i) {
				ball++;
			}
		}
		
		if(strike == 0 && ball == 0) {
			System.out.println("낫싱");
		}
		else if(strike == 3) {
			flag = false;
		}
		else {
			System.out.println(strike + "스트라이크" + ball + "볼");
		}
		
		return flag;
	}

	public String inputNums() throws IllegalArgumentException {
		String result;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("3자리 숫자를 입력하세요.");
		result = sc.next();
		
		if(result.length() != 3) {
			throw new IllegalArgumentException();
		}
		if(!chkOverlapNum(result)) {
			throw new IllegalArgumentException();
		}
		if(!chkWords(result)) {
			throw new IllegalArgumentException();
		}
		
		return result;
	}
	
	private boolean chkOverlapNum(String nums) {
		boolean flag = false;
		
		Set<Character> mySet = new HashSet<Character>();
		for(int i=0;i<nums.length();i++) {
			mySet.add(nums.charAt(i));
		}
		
		if(mySet.size() == 3) {
			flag = true;
		}
		
		return flag;
	}
	
	private boolean chkWords(String nums) {
		boolean flag = false;
		
		try {
			Integer.parseInt(nums);
			flag  = true;
		}
		catch(Exception e) {
			flag = false;
		}
		return flag;
	}
	
	private boolean restart() {
		boolean flag = false;
		
		return flag;
	}

}
