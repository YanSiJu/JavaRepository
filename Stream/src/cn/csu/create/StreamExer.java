package cn.csu.create;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import cn.csu.entity.Employee;
import cn.csu.entity.Employee.Status;

public class StreamExer {

	static List<Employee> emps = Arrays.asList(new Employee(102, "李四", 59, 6666.66, Status.BUSY),
			new Employee(101, "张三", 18, 9999.99, Status.FREE), new Employee(103, "王五", 28, 3333.33, Status.VOCATION),
			new Employee(104, "赵六", 8, 7777.77, Status.BUSY), new Employee(104, "赵六", 8, 7777.77, Status.FREE),
			new Employee(104, "赵六", 8, 7777.77, Status.FREE), new Employee(105, "田七", 38, 5555.55, Status.BUSY));

	public static void main(String[] args) {

		// 1.通过collection的API创建stream
		Stream<Employee> ems = emps.stream();
		System.out.println("ems:" + ems + "\n");
		ems.limit(3).forEach(System.out::println);

		System.out.println("\n---------------------------------------\n");

		Stream<Employee> stream = emps.parallelStream();
		System.out.println("stream:" + ems + "\n");
		stream.filter((e) -> {
			System.out.println("中间操作");
			return e.getAge() > 20;
		}).forEach(System.out::println);

		// System.out.println("stream == ems:" + (stream == ems));
		System.out.println("\n---------------------------------------\n");

		// 2.通过Arrays的API创建stream
		String[] array = { "Javascript", "Tensorflow", "caffee", "centOS", "Apollo" };
		Stream<String> s = Arrays.stream(array);
		System.out.println("s :" + s + "\n");
		s.map((str) -> str.toLowerCase()).forEach(System.out::println);
	}
}
