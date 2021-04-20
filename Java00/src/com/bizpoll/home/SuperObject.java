package com.bizpoll.home;

// 283p 45번문제 이해가안된다.
public class SuperObject {
	public void paint() {
		draw();
	}

	public void draw() {
		draw();
		System.out.println("Super Object");
	}

}
class SubObject extends SuperObject{
	public void paint() {
		super.draw();
	}
	public void draw() {
		System.out.println("Sub Object");
	}
}

	

