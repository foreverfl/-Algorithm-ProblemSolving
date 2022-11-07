package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {
	private static class Member implements Comparable<Member> {
		int height;
		int weight;

		public Member(int height, int weight) {
			super();
			this.height = height;
			this.weight = weight;
		}

		@Override
		public int compareTo(Member o) {
			return o.height - this.height;
		}

		@Override
		public String toString() {
			return "Member [height=" + height + ", weight=" + weight + "]";
		}

	}

	public static void main(String[] args) {
		List<Member> members = new ArrayList<>();

		members.add(new Member(190, 100));
		members.add(new Member(180, 100));
		members.add(new Member(170, 100));

		Collections.sort(members);

		System.out.println(members);

	}
}
