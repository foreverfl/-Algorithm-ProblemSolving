package algorithm;

import java.math.BigInteger;

public class FastExponentiation {
    public static void main(String[] args) {
        BigInteger base = new BigInteger("2");
        int exponent = 1000;

        // 일반적인 방법
        BigInteger normalPowerResult = normalPower(base, exponent);
        System.out.println("Normal Power Result: " + normalPowerResult);

        // 이진 거듭제곱 방법
        BigInteger binaryPowerResult = binaryPower(base, exponent);
        System.out.println("Binary Power Result: " + binaryPowerResult);
    }

    public static BigInteger normalPower(BigInteger base, int exponent) {
        BigInteger result = BigInteger.ONE;
        int operationCount = 0;

        for (int i = 0; i < exponent; i++) {
            result = result.multiply(base);
            operationCount++;
        }

        System.out.println("Normal Power Operation Count: " + operationCount);
        return result;
    }

    public static BigInteger binaryPower(BigInteger base, int exponent) {
        BigInteger result = BigInteger.ONE;
        int operationCount = 0;

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = result.multiply(base);
                operationCount++;
            }
            base = base.multiply(base);
            exponent /= 2;
            operationCount++;
        }

        System.out.println("Binary Power Operation Count: " + operationCount);
        return result;
    }

}
