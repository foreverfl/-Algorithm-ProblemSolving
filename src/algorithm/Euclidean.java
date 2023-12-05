package algorithm;

public class Euclidean {
	public static int eucd(int big, int small) {
		int r = big % small;
		if (r == 0) {
			return small;
		} else {
			return eucd(small, r);
		}
	}
}
