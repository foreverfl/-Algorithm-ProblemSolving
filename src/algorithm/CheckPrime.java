package algorithm;

public class CheckPrime {
	private static boolean checkPrime(long num) {
		if (num <= 1)
			return false;

		for (long i = 2; i * i <= num; i++)
			if (num % i == 0)
				return false;

		return true;
	}
}
