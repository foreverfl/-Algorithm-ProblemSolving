package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class _7883_DividingPseudoPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (canBePartitioned(N)) {
            System.out.println("possible");
        } else {
            System.out.println("impossible");
        }

    }

    public static List<Integer> findPseudoPrimes(int n) {
        List<Integer> pseudoPrimes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (isPseudoPrime(i)) {
                pseudoPrimes.add(i);
            }
        }
        return pseudoPrimes;
    }

    public static boolean isPseudoPrime(int number) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                factors.add(i);
                if (factors.size() > 2) {
                    return false;
                }
            }
        }

        return factors.size() == 2 &&
                BigInteger.valueOf(factors.get(0)).isProbablePrime(10) &&
                BigInteger.valueOf(factors.get(1)).isProbablePrime(10);
    }

    public static boolean canBePartitioned(int n) {
        List<Integer> pseudoPrimes = findPseudoPrimes(n);
        if (pseudoPrimes.size() < 3)
            return false;

        for (int i = 0; i < pseudoPrimes.size(); i++) {
            for (int j = i + 1; j < pseudoPrimes.size(); j++) {
                for (int k = j + 1; k < pseudoPrimes.size(); k++) {
                    int sum = pseudoPrimes.get(i) + pseudoPrimes.get(j) + pseudoPrimes.get(k);
                    int fourthNumber = n - sum;
                    if (fourthNumber > 0 && fourthNumber != pseudoPrimes.get(i) && fourthNumber != pseudoPrimes.get(j)
                            && fourthNumber != pseudoPrimes.get(k)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
