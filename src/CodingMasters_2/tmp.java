package CodingMasters_2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class tmp {
    public static void main(String[] args) {
        // for (int i = 2; i <= 100; i++) { // 여기서 검사 범위를 정합니다.
        // if (isPseudoPrimeOriginal(i) != isPseudoPrimeModified(i)) {
        // System.out.println("Number with different results: " + i);
        // }
        // }

        int num = 12;
        System.out.println(isPseudoPrimeOriginal(num));
        System.out.println(isPseudoPrimeModified(num));
    }

    public static boolean isPseudoPrimeOriginal(int number) {
        int count = 0;
        for (int i = 2; i <= number; i++) {
            if (number % i == 0 && BigInteger.valueOf(i).isProbablePrime(50)) {
                count++;
            }
        }
        return count == 2;
    }

    public static boolean isPseudoPrimeModified(int number) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                factors.add(i);
                if (factors.size() > 2) {
                    return false;
                }
            }
        }
        if (factors.size() == 2) {
            return BigInteger.valueOf(factors.get(0)).isProbablePrime(10) &&
                    BigInteger.valueOf(factors.get(1)).isProbablePrime(10);
        }
        return false;
    }
}
