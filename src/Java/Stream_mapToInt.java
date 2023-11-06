package Java;

import java.util.stream.Stream;

public class Stream_mapToInt {
    public static void main(String[] args) {
        String[] numbers = { "1", "2", "3", "4", "5" };

        // 문자열 배열을 int 스트림으로 변환
        int sum = Stream.of(numbers)
                .mapToInt(Integer::parseInt) // 각 문자열을 정수로 변환
                .sum();

        System.out.println("합계: " + sum);
    }
}
