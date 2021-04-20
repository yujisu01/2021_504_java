package com.bizpoll.home;

public class Hello_02 {
	
	public static void main(String[] args) {
		
		int result;
		int a= 100;
		int b= 200;
		int c= 300;
		
		// a보다 b가 큰것이 참이면, b++해준다.
		// a보다 b가 작은것이 참이면, --c 해준다.
		// a보다 b가 큰것이 참이므로, b++해줬기 때문에, 201이 출력된다.
		result = a<b ? b++:--c;
		
		System.out.println("b="+ b + ",c="+ c );
		System.out.printf("%d,%d,%d",result,b,c);
		
	}

}
