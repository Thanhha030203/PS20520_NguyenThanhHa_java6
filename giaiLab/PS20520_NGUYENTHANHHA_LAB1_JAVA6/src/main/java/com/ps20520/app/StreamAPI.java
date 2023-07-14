package com.ps20520.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ps20520.bean.Student;

public class StreamAPI {
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
			double average = list.stream()
					.mapToDouble(s -> s.getMarks())
					.average().getAsDouble();
			System.out.println("Average : "+ average);
			
			double sum = list.stream()
					.mapToDouble(s -> s.getMarks())
					.sum();
			System.out.println("Sum : "+ sum);
			double min_mark = list.stream()
					.mapToDouble(s -> s.getMarks())
					.min().getAsDouble();
			System.out.println("Min_mark : "+ min_mark);
			
			boolean all_pass = list.stream().allMatch(s -> s.getMarks()>=5);
			System.out.println("All- pass"+ all_pass);
			
			Student min = list.stream()
					.reduce(list.get(0),(main,sv)-> sv.getMarks()<main.getMarks()?sv:main);
			System.out.println("Min-Student : "+ min);
			
		}

		private static void demo3() {
			// TODO Auto-generated method stub
			List<Student> re = list.stream()
				.filter(s -> s.getMarks() >=7.5)
				.peek(sv -> sv.setName(sv.getName().toUpperCase()))// ở đây peek được coi là duyệt danh sách từ danh sách đã được lọc của filter
				.collect(Collectors.toList());
			
			re.stream().forEach(System.out::println);
		}

		private static void demo2() {
			// TODO Auto-generated method stub
			List<Integer> list = Arrays.asList(1,2,3,4,5);
			List<Double> list2 = list.stream()
			.filter(n -> n%2 ==0)
			.map(i -> Math.sqrt(i))
			.peek(d -> System.out.println(d))//d là i đã được căn bậc 2
			.collect(Collectors.toList());
			
		}

		private static void demo1() {
			// TODO Auto-generated method stub
			Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
			stream1.forEach(System.out::println);
			List<Integer> list = Arrays.asList(1,2,3,4,5);
			list.stream().forEach(System.out::println);
			
		}
}
