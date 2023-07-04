package programmers_Copied;

public class Copied_Programmers_68646_PoppingBalloons {
    public static void main(String[] args) {
        // System.out.println(solution(new int[]{9, -1, -5}));
        System.out.println(solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }
    public static int solution(int[] a) {
        int[] leftMin = new int[a.length]; //각 인덱스에서 왼쪽 원소의 최소값을 저장
        int[] rightMin = new int[a.length]; //각 인덱스에서 오른쪽 원소의 최대값을 저장
        int l = a[0]; //왼쪽 값 중 최소값
        int r = a[a.length - 1]; //오른쪽 값 중 최소값
        
        for(int i = 1; i < a.length - 1; i++) {
            if(l > a[i])
                l = a[i];

            leftMin[i] = l;
        }
        for(int i = a.length - 2; i > 0; i--) {
            if(r > a[i])
                r = a[i];

            rightMin[i] = r;
        }
        
        if(a.length == 1)
            return 1; 
        
        int answer = 2; // 원소가 2개 이상일때 무조건 2개 이상은 남음

        for(int i = 1; i <= a.length - 2; i++) {
            if(a[i] > leftMin[i] && a[i] > rightMin[i])
                continue;

            answer++;
        }
        return answer;
    }
}

// reference: https://moonsbeen.tistory.com/180