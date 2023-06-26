package programmers;

import java.util.Arrays;

public class Programmers_64062_SteppingStone {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
    }

    public static int solution(int[] stones, int k) {
        int left = 1; 
        int right = Arrays.stream(stones).max().getAsInt(); 

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCross(stones, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left - 1; 
    }

    public static boolean canCross(int[] stones, int k, int numPeople) {
        int count = 0; 
        for (int stone : stones) {
            if (stone < numPeople) {
                count++;
            } else {
                count = 0;
            }

            if (count >= k) {
                return false;
            }
        }

        return true;
    }
}
