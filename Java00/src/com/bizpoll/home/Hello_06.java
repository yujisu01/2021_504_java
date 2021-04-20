package com.bizpoll.home;

public class Hello_06 {
	
	public static void main(String[] args) {
		
		String str = "Programming";
		// n은 일단 11개
		int n = str.length();
		
		//11개저장
		char[] st = new char[n];
		 
		//10개
		n--;
		
		//10-10=0, 10-9=1, 10-8=2.... [0]번째값,[1번째값],[2번째값]..
		// 이렇게 출력한다.(?) 
		for(int k = n; k >=0; k--) {
			st[n-k]=str.charAt(k);
		}
		for(char k : st) {
			System.out.printf("%c",k);
		}

			

	}

}
