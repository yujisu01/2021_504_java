package com.bizpoll.home;

public class Hello_05 {
	public static void main(String[] args) {
		
		String str = "agile";
		int x[] = {1,2,3,4,5};
		char y[] = new char[5];
		int i =0;
		
		while(i< str.length()) {
			y[i] = str.charAt(i);
			i++;
			//System.out.println(y[0]);
		}
		for(int p : x) {
			i--;
			
			System.out.print(y[i]);
			System.out.print(p + "\n");
		}
	}
}
