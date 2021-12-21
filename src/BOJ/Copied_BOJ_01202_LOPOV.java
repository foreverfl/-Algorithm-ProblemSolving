package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
class Jewelry {
    int mass;
    int value;
 
    Jewelry(int mass, int value) {
        this.mass = mass;
        this.value = value;
    }
}
 
public class Copied_BOJ_01202_LOPOV {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
 
        Jewelry[] jewelries = new Jewelry[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
 
            jewelries[i] = new Jewelry(m, v);
        }
        
        // Mass is aligned by ascending order.
        // If mass is same, value is aligned by descending order.
        Arrays.sort(jewelries, new Comparator<Jewelry>() {
 
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.mass == o2.mass) {
                    return o2.value - o1.value;
                }
                return o1.mass - o2.mass;
            }
 
        });
 
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        // Bag's mass is aligned by ascending order.
        Arrays.sort(bags);
 
        // Priority queue is always aligned by ascending order of value.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0, j = 0; i < K; i++) {
            // jewelries which is smaller than the bag's mass are input in the priority queue.
            while (j < N && jewelries[j].mass <= bags[i]) {
                pq.offer(jewelries[j++].value);
            }
 
            // The priority queue is in the descending order, the first element is the most expensive value.
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}

// algorithm: greedy algorithm.


// reference: https://steady-coding.tistory.com/56