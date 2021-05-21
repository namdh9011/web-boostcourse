package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam02 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//Car만 선언해주면 자동으로 Engine클래스도 사용한다.
		//사용자가 Engine클래스를 알고있을 필요가 없다.
		Car car = (Car) ac.getBean("c");
		car.run();
	}

}
