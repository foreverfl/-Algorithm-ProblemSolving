package programmers_Copied;

public class Copied_Programmers_60059_LockAndKey {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}}, new int[][] {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));
    }


    public static boolean solution(int[][] key, int[][] lock) {
        int m = key.length;
        int n = lock.length;
        
        // 배열 확장시키기
        int len = n + m * 2 - 2;
        int[][] map = new int[len][len];  
        
          for(int i = m - 1; i < m + n - 1; i++){
            for(int j = m - 1; j < m + n - 1; j++){
                map[i][j] = lock[i - (m - 1)][j - (m - 1)];
            }
        }
        
        for(int i = 0; i < 4; i++){
            if(check(map, key, n)){
                return true;
            }
            rotate(key);
        }
        
        
        return false;
    }

    public static boolean check(int[][] map, int[][] key, int lockLen){
        int keyLen = key.length;
        int mapLen = map.length;
        for(int i = 0; i < mapLen - keyLen + 1; i++){
            for(int j = 0; j < mapLen - keyLen + 1; j++){
                
                // map에 key를 더함
                for(int k = 0; k < keyLen; k++){
                    for(int l = 0; l < keyLen; l++){
                        map[i + k][j + l] += key[k][l];
                    } 
                }
                
                // 자물쇠 부분이 전부 1이 됐는지 확인
                boolean flag = true;
                for(int k = keyLen - 1; k < keyLen + lockLen - 1; k++){
                    for(int l = keyLen - 1; l < keyLen + lockLen - 1; l++){
                        if(map[k][l] != 1){ // 1이 아니면 홈이 안 맞는 것
                            flag = false;
                            break;
                        }
                    }
                    if(!flag)
                        break;
                }
                
                if(flag)
                    return true; // 전부 1이였다면 true
                
                // map을 원상 복귀
                for(int k = 0; k < keyLen; k++){
                    for(int l = 0; l < keyLen; l++){
                        map[i + k][j + l] -= key[k][l];
                    }
                }
                
            }
        }
        
        return false;
    }
    
    public static void rotate(int[][] key){
        int len = key.length;
        int[][] temp = new int[len][len];
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[j][len - 1 - i] = key[i][j];
            }
        }
        
        for (int i = 0; i < len; i++) {
            System.arraycopy(temp[i], 0, key[i], 0, len);
        }        
    }
}

// reference: https://code-lab1.tistory.com/152