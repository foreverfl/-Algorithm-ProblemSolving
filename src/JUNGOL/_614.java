package JUNGOL;

import java.util.Scanner;

public class _614 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String school = sc.next();
		int grade = sc.nextInt();
		sc.close();

		School school1 = new School("Jejuelementary", 6);
		School school2 = new School(school, grade);

		school1.print();
		school2.print();

	}
}

class School {
	// the fields
	private String school;
	private int grade;

	// using the constructors
	public School(String school, int grade) {
		this.school = school;
		this.grade = grade; 
	}

	public void print() {
		System.out.println(grade + " grade in " + school + " School");
	}

}