package baekjoon;

public class Test {

	public static void main(String args[]) {
		System.out.println(fib_divide_conquer(10));
	}

	public static int fib_divide_conquer(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else
			return fib_divide_conquer(n - 1) + fib_divide_conquer(n - 2);
	}
}
