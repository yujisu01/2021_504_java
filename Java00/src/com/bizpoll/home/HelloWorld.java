package com.bizpoll.home;

class parent {
	int compute(int num) {
		if(num<=1)
			return num;
		return compute(num-1) + compute(num-2);
	}

}
class child extends parent{
	int compute (int num) {
		if(num<=1)
			return num;
		return compute(num-1) + compute(num-3);
		
	}
}
public class HelloWorld {
	public static void main(String[] args) {
		parent obj = new child();
		
		System.out.println(obj.compute(4));
	}
}