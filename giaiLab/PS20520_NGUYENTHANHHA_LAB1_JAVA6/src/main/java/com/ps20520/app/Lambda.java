package com.ps20520.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ps20520.bean.Student;

public class Lambda {
	static List<Student> list = Arrays.asList(
			new Student("Nguyễn Văn A", true, 7.5),
			new Student("Nguyễn Văn B", false, 5.5),
			new Student("Nguyễn Văn C", true,9.5),
			new Student("Nguyễn Văn D", false,6.5)
			
			);
		public static void main(String[] args) {
			//demo1();
			//demo2();
			//demo3();
			demo4();
			
		}

	

		private static void demo4() {
			// TODO Auto-generated method stub
			Demo4Interface dem4 = x ->
			System.out.println(x);
			dem4.m1(1);
		}



		private static void demo3() {
			// TODO Auto-generated method stub
			//Bình thường sẽ xếp từ thấp - cao, nếu có dấu trừ ở trước sv1 sẽ xếp từ cao đến thấp
			Collections.sort(list,(sv1,sv2) -> -sv1.getMarks().compareTo(sv2.getMarks()));
			demo2();
		}



		private static void demo1() {
			// TODO Auto-generated method stub
			List<Integer> list = Arrays.asList(1,9,4,7,5,2);
			list.forEach(n -> System.out.println(n));
		}
		private static void demo2() {
			// TODO Auto-generated method stub
			
			list.forEach(sv -> { 
				System.out.println(">> Name : "+ sv.getName());
				System.out.println(">> Marks : "+ sv.getMarks());
			});
					
		}
		@FunctionalInterface
		interface Demo4Interface{ 
			void m1(int x);
			default void m2() {}
			public static void m3() {}
		}
}
