package kr.or.connect.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Autowired
	private Engine v8;

	public Car() {
		System.out.println("Car 생성자");
	}

//이것을 없애는 대신 @Autowired 해주는 것.
	public void setEngine(Engine e) {
		this.v8 = e;
	}

	public void run() {
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec();
	}
/*
 * 이부분을 Spring IoC 컨테이너가 해주는 것이다.
	public static void main(String[] args) {
		Engine e = new Engine();
		Car c = new Car();
		c.setEngine(e);
		c.run();
	}
*/
}
