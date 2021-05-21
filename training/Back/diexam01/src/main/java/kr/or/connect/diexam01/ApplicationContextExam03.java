package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam03 {

	public static void main(String[] args) {
		ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		//Car만 선언해주면 자동으로 Engine클래스도 사용한다.
		//사용자가 Engine클래스를 알고있을 필요가 없다.
//		Car car = (Car) ac.getBean("car");		//클래스 명으로 불러오는 것도 가능하고
		Car car = (Car) ac.getBean(Car.class);	//클래스 타입을 불러오는 것도 가능
		car.run();
	}

}
