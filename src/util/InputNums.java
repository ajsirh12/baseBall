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

	public String inputNums() {
		String result;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("3자리 숫자를 입력하세요.");
		result = sc.next();
		
		chkException(result);
		
		return result;
	}
	
	private void chkException(String str) {
		if(str.length() != 3) {
			throw new IllegalArgumentException();
		}
		if(!chkOverlapNum(str)) {
			throw new IllegalArgumentException();
		}
		if(!chkWords(str)) {
			throw new IllegalArgumentException();
		}
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
}
