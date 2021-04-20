package com.bizpoll.home;

public class Hello_01 {
	
	public static void main(String[] args) {
		
		int i=10;
		int j =10;
		int k =30;
		
		i/=j;
		j-=i;
		k%=j;
		System.out.printf("%d,%d,%d\n",i,j,k);
	}

}
