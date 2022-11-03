package boj_Copied;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Copied_BOJ_11003_FindingMinimumValue {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		Deque<int[]> q = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			while(!q.isEmpty() && q.peekLast()[0] > num) q.pollLast();
			
			q.offer(new int[] {num,i});
			if(q.peek()[1] < i -(l-1)) {
				q.poll();
			}
			bw.write(q.peek()[0]+" ");
		}
		bw.flush();
		bw.close();
	}
}

// https://loosie.tistory.com/324
