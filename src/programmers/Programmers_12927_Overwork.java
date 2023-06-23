package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Programmers_12927_Overwork{
    public static void main(String[] args) {
        System.out.println(solution(4, new int[]{4, 3, 3}));
        System.out.println(solution(1, new int[]{2, 1, 2}));
        System.out.println(solution(3, new int[]{1, 1}));
    }

    public static long solution(int n, int[] works) {
        if (n >= Arrays.stream(works).sum()) {
            return 0; // 모든 작업을 0으로 만들 수 있음
        }   

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int work : works) {
            maxHeap.offer(work);
        }

        while (n > 0) {
            int maxWork = maxHeap.poll();
            maxHeap.offer(maxWork - 1);
            n--;
        }

        long answer = 0;
        for (int work : maxHeap) {
            answer += (long) work * work;
        }



        return answer;
    }
}