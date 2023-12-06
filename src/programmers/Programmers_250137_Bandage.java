package programmers;

public class Programmers_250137_Bandage {
    public static void main(String[] args) {
        System.out.println(
                solution(new int[] { 5, 1, 5 }, 30, new int[][] { { 2, 10 }, { 9, 15 }, { 10, 5 }, { 11, 5 } }));
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int nowHealth = health;
        int curingTime = 0;
        int lastTime = attacks[attacks.length - 1][0];
        int attackIdx = 0;
        for (int i = 1; i <= lastTime; i++) {
            if (i == attacks[attackIdx][0]) {
                nowHealth -= attacks[attackIdx][1];
                attackIdx++;
                curingTime = 0;
                if (nowHealth <= 0) {
                    return -1;
                }
            } else {
                curingTime++;
                if (curingTime == bandage[0]) {
                    nowHealth += bandage[2];
                    curingTime = 0;
                }
                nowHealth += bandage[1];

                if (nowHealth > health) {
                    nowHealth = health;
                }
            }
        }

        return nowHealth;
    }
}
