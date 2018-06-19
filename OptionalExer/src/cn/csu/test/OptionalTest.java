package cn.csu.test;

import java.util.Optional;
import cn.csu.entity.Employee;
import cn.csu.entity.Employee.Status;

public class OptionalTest {

	public static void main(String[] a) {
		Employee employee = new Employee(101, null, 25, 9999.99, Status.FREE);
		Optional<Employee> op = Optional.ofNullable(employee);
		System.out.println("map:" + op.map(Employee::getName).orElse("unknown"));
		System.out.println("flatMap:" + op.flatMap((e) -> Optional.ofNullable(e.getName())).orElseGet(() -> {
			return "unknown";
		}));

		Optional<Employee> o = op.filter((e) -> e.getAge() > 20);
		System.out.println(o);
		
	}

}
