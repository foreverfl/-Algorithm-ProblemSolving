package algorithm;

public class MillerRabin {

	// Driver program
	public static void main(String args[]) {

		int k = 4; // Number of iterations

		System.out.println("All primes smaller " + "than 100: ");

		for (int n = 1; n < 100; n++)
			if (miller(n, k))
				System.out.print(n + " ");
	}

	private static long power(long x, long y, long mod) {
		long res = 1;
		x %= mod;
		while (y != 0) {
			if (y % 2 != 0)
				res = (res * x) % mod;
			y /= 2;
			x = (x * x) % mod;
		}
		return res;
	}

	// if n is prime, return true
	private static boolean miller(long n, long a) {
		if (a % n == 0)
			return false;
		long k = n - 1;
		while (true) {
			long temp = power(a, k, n);
			if (temp == n - 1)
				return true; // a^k = -1 (mod n)
			if (k % 2 != 0)
				return (temp == 1 || temp == n - 1);
			k /= 2;
		}
	}

}
