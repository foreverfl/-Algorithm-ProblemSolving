package boj_Copied;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Copying_BOJ_11404_Floid {
        
    public static int cityCount;
    public static int[][] distance;
    public static final int INF = 1000000000;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        cityCount = Integer.parseInt(br.readLine());
        
        int busCount = Integer.parseInt(br.readLine());
        
        distance = new int[cityCount+1][cityCount+1];
        
        for(int i=1; i <= cityCount; i++) {
            for(int j=1; j <= cityCount; j++) {
                if(i == j) continue;
                distance[i][j] = INF;
            }
        }
        
        while(busCount-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            
            distance[start][end] = Math.min(distance[start][end], time);    
        }
 
        floydWarshall();
        print();
    }
    
    public static void floydWarshall() {
        // ������ �Ǵ� ���İ��� ��� K
        for(int k = 1; k <= cityCount; k++) {
            // ����ϴ� ��� i
            for(int i=1; i <= cityCount; i++) {
                // �����ϴ� ��� j
                for(int j=1; j <= cityCount; j++) {
                    //i���� k�� ���ƴٰ� k���� j ���� ���� �Ÿ��� i���� j ���� ���� �Ÿ��� ���ؼ� ���� ���� �ּҰŸ��̴�.
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
    }
    
    public static void print() {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= cityCount; i++) {
            for(int j=1; j <= cityCount; j++) {
                if(distance[i][j] >= INF) sb.append("0 ");
                else sb.append(distance[i][j] + " ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}


/*�Է�
n(������ ����)
m(������ ����)
...
m+2(a, b, c)(���۵���, ��������, �ѹ� Ÿ�µ� �ʿ��� ���)
a=b�� �������� �ʴ´�.
c<100000

���
0              �ּҺ�� �ּҺ�� �ּҺ�� �ּҺ��
�ּҺ��     0          �ּҺ�� �ּҺ�� �ּҺ��
�ּҺ�� �ּҺ��      0         �ּҺ�� �ּҺ��
�ּҺ�� �ּҺ�� �ּҺ��      0         �ּҺ��
�ּҺ�� �ּҺ�� �ּҺ�� �ּҺ��       0

n * n �迭��!!
 * 
 * 
 */
