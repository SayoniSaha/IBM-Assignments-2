package com.model;

public class Employee {

	private String employeeName;
	private double age;

	public Employee() {
		super();
	}
	public Employee(String empName, double age) {
		super();
		this.employeeName = empName;
		this.age = age;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String empName) {
		this.employeeName = empName;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
}
