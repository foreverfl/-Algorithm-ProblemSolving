package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class BOJ_01933_SkyLine {

	 static int n;
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        n = Integer.parseInt(br.readLine());
	        // 좌표 기준 오름차순 (같으면 높이 기준 내림차순)
	        PriorityQueue<Building> pq = new PriorityQueue<>((o1, o2) -> {
	            if (o1.x == o2.x) {
	                return o2.h - o1.h;
	            }
	            return o1.x - o2.x;
	        });

	        for (int i = 0; i < n; i++) {
	            StringTokenizer st = new StringTokenizer(br.readLine());
	            int l = Integer.parseInt(st.nextToken());
	            int h = Integer.parseInt(st.nextToken());
	            int r = Integer.parseInt(st.nextToken());
	            pq.offer(new Building(l, h));
	            pq.offer(new Building(r, -h));
	        }

	        StringBuilder sb = new StringBuilder();

	        // key 기준 내림 차순
	        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
	        int maxX = 0, maxH = 0;
	        map.put(0, 1);
	        while (!pq.isEmpty()) {
	            Building b = pq.poll();

	            if (b.h > 0) {  // 시작점이면
	                map.put(b.h, map.getOrDefault(b.h, 0) + 1);
	            } else {    // 끝점이면
	                int val = map.get(-b.h);
	                if (val == 1) {
	                    map.remove(-b.h);
	                } else {
	                    map.replace(-b.h, val - 1);
	                }
	            }

	            // maxX ~ b.x 중 가장 높은 H를 뽑음
	            int height = map.firstKey();
	            if (maxX != b.x && maxH != height) {
	                sb.append(b.x + " " + height + " ");
	                maxX = b.x;
	                maxH = height;
	            }
	        }

	        bw.write(sb.toString().trim());
	        bw.close();
	        br.close();
	    }

	    static class Building{
	        int x, h;

	        Building(int x, int h) {
	            this.x = x;
	            this.h = h;
	        }
	    }

}

// reference: https://gre-eny.tistory.com/293
