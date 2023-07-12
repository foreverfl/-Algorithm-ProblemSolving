package programmers_Copied;

public class Copied_Programmers_118668_StudyingAlgorithm {
    public static void main(String[] args) {
        System.out.println(solution(10, 10, new int[][] {{10, 15, 2, 1, 2}, {20, 20, 3, 3, 4}}));
        System.out.println(solution(0, 0, new int[][] {{0, 0, 2, 1, 2}, {4, 5, 3, 1, 2}, {4, 11, 4, 0, 2}, {10, 4, 0, 4, 2}}));
    }

    public static int solution(int alp, int cop, int[][] problems) {
        int goal_a = 0;
        int goal_c = 0;
       
       // 목표치
       for(int i = 0; i < problems.length;i++){
           goal_a = Math.max(problems[i][0], goal_a);
           goal_c = Math.max(problems[i][1], goal_c);
       }
       
       // 이미 문제를 다 풀 수 있는 경우
       if(goal_a <= alp && goal_c <= cop){
           return 0;
       }
       
       // 하나만 목표치보다 높을 경우 idx 오류를 방지하기 위해 처리
       if(alp >= goal_a)
           alp = goal_a;
       
       if(cop >= goal_c)
           cop = goal_c;
       
       
       int[][] dp = new int[goal_a + 2][goal_c + 2];
       
       for(int i = alp; i <= goal_a; i++){
           for(int j = cop; j <= goal_c; j++){
               dp[i][j] = Integer.MAX_VALUE;
         }
       }
       
       dp[alp][cop] = 0;
       
        for(int i = alp; i <= goal_a; i++){
           for(int j = cop; j <= goal_c; j++){
               
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1); // 알고력 트레이닝
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1); // 코딩력 트레이닝
                
                for(int[] p : problems){

                    if(i >= p[0] && j >= p[1]){
                        
                        if(i + p[2] > goal_a && j + p[3] > goal_c) // 둘 다 목표치를 넘겼을 때
                            dp[goal_a][goal_c] = Math.min(dp[goal_a][goal_c], dp[i][j] + p[4]);                    

                        else if (i + p[2] > goal_a) // 알고력만 목표치를 넘겼을 때
                            dp[goal_a][j + p[3]] = Math.min(dp[goal_a][j + p[3]], dp[i][j] + p[4]);                    

                        else if (j + p[3] > goal_c) // 코딩력만 목표치를 넘겼을 때
                            dp[i + p[2]][goal_c] = Math.min(dp[i + p[2]][goal_c], dp[i][j] + p[4]);                    

                        else if (i + p[2] <= goal_a && j + p[3] <= goal_c) // 둘 다 목표치를 못 넘겼을 때
                            dp[i + p[2]][j + p[3]] = Math.min(dp[i + p[2]][j + p[3]], dp[i][j] + p[4]); 
                        
                    }
                                 
                }
            }
         }

       return dp[goal_a][goal_c];
   
   }
}

// reference: https://taehoung0102.tistory.com/211