package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_01377_BubbleSort {

    private static class element implements Comparable<element>  {
        int val;
        int idx;

        @Override
        public String toString() {
            return "Value: " + val + ", Index: " + idx;
        }

        @Override
        public int compareTo(element o) {
            return Integer.compare(this.val, o.val);
        }

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        element[] original = new element[N + 1];
        original[0] = new element();

        for(int i = 1; i <= N; i++) {
            original[i] = new element();
            original[i].val = Integer.parseInt(br.readLine());
            original[i].idx = i;
        }

        element[] copied = new element[original.length];
        copied[0] = new element();
        for (int i = 1; i <= N; i++) {
            copied[i] = new element();
            copied[i].val = original[i].val;
            copied[i].idx = original[i].idx;
         }
        Arrays.sort(original);

        int[] indices = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            indices[i] = original[i].idx - copied[i].idx;
        }

        int max = Arrays.stream(indices).max().getAsInt();
        System.out.println(max + 1);
        
    }
}

// reference: https://scarlettb.tistory.com/114
