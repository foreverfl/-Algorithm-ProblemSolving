package programmers_Copied;

import java.util.Arrays;

public class Copied_Programmers_43238_Immigration {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }

    public static long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * (long) n; // right는 가장 비효율적으로 심사했을 때 걸리는 시간
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long people = 0;
            
            for (int time : times) {
                people += mid / time; // 모든 심사관들이 mid분 동안 심사한 사람의 수
                if (people >= n)  // 모든 심사관을 거치지 않아도 심사가 가능한 경우
                    break;
            }
            
            
            if (people >= n) {
                answer = mid;
                right = mid - 1;
            }
            
            else if (people < n) {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
}

// reference: https://sohee-dev.tistory.com/123