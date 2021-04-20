package com.bizpoll.home;

public class Hello_03 {

	public static void main(String[] args) {

		// 정수형 배열 8개선언
		int a[] = new int[8];
		
		int i = 0;
		int n = 10;
		
		// n이 0보다 큰동안, 아래 연산을 수행한다
		while (n > 0) {
			// i++는 후치 증가연산자 이므로, a[i]에 2로 나눈 나머지를 저장한후,
			// 		(10, 5, 
			a[i++] = n % 2;
			n /= 2;
		}
		for (i = 7; i >= 0; i--) {
			System.out.println(a[i]);
		}
	}

}
