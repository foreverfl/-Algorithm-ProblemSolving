package algorithm;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class tmp {
    public static void main(String[] args) {
        int numElements = 1000000;
        
        // PriorityQueue 메모리 사용량 측정
        long startPQ = getMemoryUsage();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < numElements; i++) {
            priorityQueue.add(i);
        }
        long endPQ = getMemoryUsage();
        long pqMemoryUsage = endPQ - startPQ;
        
        // ArrayDeque 메모리 사용량 측정
        long startAD = getMemoryUsage();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < numElements; i++) {
            arrayDeque.add(i);
        }
        long endAD = getMemoryUsage();
        long adMemoryUsage = endAD - startAD;
        
        // 메모리 사용량 비교 결과 출력
        System.out.println("PriorityQueue 메모리 사용량: " + pqMemoryUsage + " bytes");
        System.out.println("ArrayDeque 메모리 사용량: " + adMemoryUsage + " bytes");
    }
    
    private static long getMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
