package main;

import java.util.Map;
import java.util.Scanner;

import util.InputNums;
import util.ThreeNums;

public class BaseBallMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreeNums baseBall;
		Map<String, Integer> baseBallNums;
		
		InputNums inputNums = new InputNums(); 

		boolean flag = true;
		boolean strike = true;
		
		while(flag) {
			baseBall = new ThreeNums();
			baseBallNums = baseBall.getBaseBallNums();
			
			while(strike) {
				strike = inputNums.chkScore(baseBallNums, inputNums.inputNums());
			}
			if(restart()) {
				strike = true;
			}
			else {
				flag = false;
			}
		}
		System.out.println("End");
		
	}
	
	private static boolean restart() {
		int check;
		
		System.out.println("재시작 : 1      종료 : 2");
		
		Scanner sc = new Scanner(System.in);
		check = sc.nextInt();
		
		if(check == 1) {
			return true;
		}
		else if(check == 2) {
			return false;
		}
		else {
			throw new IllegalArgumentException();
		}
		
		
	}
}
