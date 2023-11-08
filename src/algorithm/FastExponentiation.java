package algorithm;

public class FastExponentiation {
    public static void main(String[] args) {
        long a = 3; // 밑
        long b = 50; // 지수

        // 빠른 거듭제곱 알고리즘을 사용하여 a^b 계산
        long result = fastExponentiation(a, b);

        System.out.println(a + "의 " + b + " 거듭제곱은 " + result + "입니다.");
    }

    public static long fastExponentiation(long a, long b) {
        long result = 1; // 결과를 저장할 변수, a^0 = 1로 시작
        long base = a; // 거듭제곱의 밑

        while (b > 0) {
            if (b % 2 == 1) {
                // 현재 지수의 가장 낮은 비트가 1이면 결과에 밑을 곱함
                result *= base;
            }
            // 밑을 제곱 (다음 비트로 이동)
            base *= base;
            // 지수를 오른쪽으로 한 비트 시프트 (이진수에서 한 자리를 낮춤)
            b /= 2;
        }

        return result;
    }

}
