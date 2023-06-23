package programmers;

import java.util.Arrays;

public class Programmers_12987_NumberGame {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {5, 1, 3, 7}, new int[]{2, 2, 6, 8}));
        System.out.println(solution(new int[] {2, 2, 2, 2}, new int[]{1, 1, 1, 1}));
    }

    public static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int bIndex = 0;
        
        for (int num : A) {
            while (bIndex < B.length && B[bIndex] <= num) {
                bIndex++;
            }
            
            if (bIndex == B.length) {
                break;
            }
            
            answer++;
            bIndex++;
        }

        return answer;
    }
}
