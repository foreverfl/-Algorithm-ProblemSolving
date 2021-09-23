package JUNGOL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _618 {

	public static void main(String[] args) {
		List<Person1> person1 = new ArrayList<Person1>();
		List<Person2> person2 = new ArrayList<Person2>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			String name = sc.next();
			int height = sc.nextInt();
			double weight = sc.nextDouble();
			person1.add(new Person1(name, height, weight));
			person2.add(new Person2(name, height, weight));
		}
		Collections.sort(person1);

		System.out.println("name");
		for (int i = 0; i < person1.size(); i++) {
			Person1 list = person1.get(i);
			System.out.println(list.name + " " + list.height + " " + list.weight);
		}
		System.out.println();

		Collections.sort(person2);

		System.out.println("weight");
		for (int i = 0; i < person2.size(); i++) {
			Person2 list = person2.get(i);
			System.out.println(list.name + " " + list.height + " " + list.weight);
		}
	}

}

class Person1 implements Comparable<Person1> {

	String name;
	int height;
	double weight;

	public Person1(String name, int height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight; // this는 해당 메소드 내의 값을 의미함... 순서 거꾸로 ㄴㄴ
	}

	@Override
	public int compareTo(Person1 o) {
		return name.charAt(0) - o.name.charAt(0);
	}

}

class Person2 implements Comparable<Person2> {

	String name;
	int height;
	double weight;

	public Person2(String name, int height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	@Override
	public int compareTo(Person2 o) {
		if (o.weight > weight)
			return 1;
		else if (o.weight < weight)
			return -1;
		else
			return 0;

	}

}
