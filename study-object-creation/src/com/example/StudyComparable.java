package com.example;

import static java.lang.Double.compare;
import static java.lang.Integer.compare;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class StudyComparable {

	public static void main(String[] args) {
		BigDecimal x = new BigDecimal("1.0");
		BigDecimal y = new BigDecimal("1.01");
		System.err.println("x.equals(y): " + x.equals(y));
		System.err.println("x.compareTo(y): " + x.compareTo(y));
		List<BigDecimal> decimals = new ArrayList<>(List.of(x, y));
		System.out.println(decimals);
		Comparator<BigDecimal> ascOrder = BigDecimal::compareTo;
		Comparator<BigDecimal> descOrder = ascOrder.reversed();
		Collections.sort(decimals, ascOrder

		);
		System.out.println(descOrder.getClass());
		System.out.println(decimals);
		List<Employee> employees = new ArrayList<>();
		Employee jack = new Employee("1", "jack bauer", 37, 100_000.);
		Employee james = new Employee("2", "james sawyer", 42, 75_000.);
		Employee kate = new Employee("3", "kate austen", 37, 100_000.);
		employees.add(jack);
		employees.add(james);
		employees.add(kate);
		Collections.sort(employees);
		Consumer<Employee> printEmployee = System.out::println;
		Comparator<Employee> descOrderBySalary = (e1, e2) -> compare(e2.getSalary(), e1.getSalary());
		Comparator<Employee> ascOrderByAge = (e1, e2) -> compare(e1.getAge(),e2.getAge());
		Comparator<Employee> ascOrderById = (e1, e2) -> e1.compareTo(e2);
		employees.sort(descOrderBySalary.reversed().thenComparing(ascOrderByAge.reversed()).thenComparing(ascOrderById));
		employees.forEach(printEmployee);
	}

}

class Employee implements Comparable<Employee> {
	private String id;
	private String fullname;
	private int age;
	private double salary;

	public Employee(String id, String fullname, int age, double salary) {
		this.id = id;
		this.fullname = fullname;
		this.age = age;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullname=" + fullname + ", age=" + age + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Employee o) {
		return this.id.compareTo(o.id);
	}

}
