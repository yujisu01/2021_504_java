package com.bizpoll.home;

public class Hello_04 {
	
	public static void main(String[] args) {
		
		int i = 10, hap = 0;
		while(i > 1) {
			// i = i-1과 동일하다. i의 값을 1씩 감소시킨다.
			i--;
			// i를 3으로 나눈 나머지가 1이면 hap+= i실행
			// 아니면 탈출
			if(i % 3 == 1) {
				hap+= i;
				
			}
		}
		System.out.println(hap);
	}
	// 10은 연산안되는 이유 : i--를 해서

}
