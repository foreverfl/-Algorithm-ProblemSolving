package JUNGOL;

import java.util.Scanner;

public class _613 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		String school = sc.next(); 
		int grade = sc.nextInt(); // It is how to input without spacing words.
		sc.close();

		Student stu = new Student(); /* In method, parameters have to come to
		                              * a part which generates an instance
		                              * like this.
		                              * Otherwise, they comes to a part declaring
		                              * a class*/
	
		stu.setName(name);
		stu.setSchool(school);
		stu.setGrade(grade);

		stu.print();
	}

}

class Student {

	private String name;
	private String school;
	private int grade;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void print() {
		System.out.println("Name : " + name);
		System.out.println("School : " + school);
		System.out.println("Grade : " + grade); /* The 'print' has to come
	                                             * in the 'class student.'
	                                             */
	}

}
