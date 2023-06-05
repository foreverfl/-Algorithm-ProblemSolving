package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Copied_BOJ_02141_PostOffice {
    private static class Town implements Comparable<Town>{
        long dist;
        long cnt;

        // Default constructor
        public Town() {
        }

        @Override
        public int compareTo(Town other) {
            if(this.dist == other.dist) {
				return (int) (this.cnt - other.cnt);
			}
            return (int) (this.dist - other.dist);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0;
        Town[] towns = new Town[N];
        
        for(int i = 0 ; i < N ; i++) {
            long[] inputs = Arrays.stream(br.readLine().split(" "))
                            .mapToLong(Long::parseLong)
                            .toArray();

            towns[i] = new Town(); 
            towns[i].dist = inputs[0];
            towns[i].cnt = inputs[1];    
            result += inputs[1];        
        }

        Arrays.sort(towns);

        long sum = 0;
		
		for(Town town : towns) {
			sum += town.cnt;
			if(sum >= (result + 1) / 2) { // 전체 인구 수의 절반 이상이 누적된 시점, 홀수일 경우 올림 처리
				System.out.println(town.dist);
				break;
			}
		}
    }
}

// reference: https://dang2dangdang2.tistory.com/118