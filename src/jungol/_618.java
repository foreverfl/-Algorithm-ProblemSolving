package jungol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class _618 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("name");


		System.out.println("weight");
		ArrayList<Weight> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			String name = sc.next();
			int height = sc.nextInt();
			double weight = sc.nextDouble();
			list.add(new Weight(name, height, weight));
		}
		Collections.sort(list);
		Weight.print();

	}

}

class Name implements Comparable<Name> {

	public String name;
	public int height;
	public double weight;

	public Name(String name, int height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	@Override
	public int compareTo(Name name) {
		return name.compareTo(name.name);
	}
	
	public void print() {
		System.out.println(this.name + " " + this.height + " " + this.weight);
	}


}

class Weight implements Comparable<Weight> {

	public String name;
	public int height;
	public double weight;

	public Weight(String name, int height, double weight) {
		this.name = name;
		this.height = height;
		this.weight = weight;
	}

	@Override
	public int compareTo(Weight o) {
		if(weight > o.weight) {
			return 1;
		} else if(weight == o.weight) {
			return 0;
		} else {
			return -1;
		}
	}
	
	public void print() {
		System.out.println(this.name + " " + this.height + " " + this.weight);
	}


}