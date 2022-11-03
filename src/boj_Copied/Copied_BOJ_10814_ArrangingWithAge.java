package boj_Copied;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Copied_BOJ_10814_ArrangingWithAge {
	static class Person implements Comparable<Person> {

		int num;
		int age;
		String name;

		public Person(int num, int age, String name) {
			this.num = num; // index
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			if (this.age == o.age) {
				return this.num - o.num;
			}
			return this.age - o.age;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		ArrayList<Person> person = new ArrayList<>();
		
		for (int i = 0; i < T; i++) {
			int age = sc.nextInt();
			String name = sc.next();
			person.add(new Person(i, age, name));
		}

		Collections.sort(person);

		for (int i = 0; i < T; i++) {
			if (person.get(i) != null) {
				System.out.println(person.get(i).age + " " + person.get(i).name);
			}
		}
		sc.close();
	}
}

// reference: https://vanillacreamdonut.tistory.com/104
