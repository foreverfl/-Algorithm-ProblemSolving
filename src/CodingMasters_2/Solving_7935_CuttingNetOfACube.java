package CodingMasters_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solving_7935_CuttingNetOfACube {
    public static void main(String[] args) throws IOException {
        // 입력값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[10][10];
        for (int i = 0; i < 10; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 최대값 찾기
        System.out.println(findMaxInCube(map));

    }

    public static int findMaxInCube(int[][] map) {
        List<int[][]> cubes = getCubePatterns();

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int[][] cube : cubes) {
                    int sum = 0;
                    if (canPlaceCube(cube, i, j)) {
                        for (int[] square : cube) {
                            sum += map[i + square[0]][j + square[1]];
                        }
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        return max;
    }

    public static List<int[][]> getCubePatterns() {
        List<int[][]> cubes = new ArrayList<>();
        // 첫째 줄
        cubes.add(new int[][] { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 1, 3 }, { 2, 0 } });
        cubes.add(new int[][] { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 1, 3 }, { 2, 1 } });
        cubes.add(new int[][] { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 1, 3 }, { 2, 2 } });
        cubes.add(new int[][] { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 1, 3 }, { 2, 3 } });
        // 둘째 줄
        cubes.add(new int[][] { { 0, 0 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 0 } });
        cubes.add(new int[][] { { 0, 0 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 1 } });
        // 셋째 줄
        cubes.add(new int[][] { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 }, { 2, 2 }, { 2, 3 } });
        cubes.add(new int[][] { { 0, 0 }, { 1, -1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } });
        cubes.add(new int[][] { { 0, 0 }, { 1, -2 }, { 1, -1 }, { 1, 0 }, { 2, 0 }, { 2, 1 } });
        // 넷째 줄
        cubes.add(new int[][] { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 }, { 1, 3 }, { 1, 4 } });
        cubes.add(new int[][] { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 }, { 2, 2 }, { 2, 3 } });

        List<int[][]> rotatedCubes = new ArrayList<>();
        for (int[][] cube : cubes) {
            rotatedCubes.add(cube);
            rotatedCubes.add(rotatePattern(cube, 90));
            rotatedCubes.add(rotatePattern(cube, 180));
            rotatedCubes.add(rotatePattern(cube, 270));
        }
        return rotatedCubes;
    }

    // 회전 함수
    public static int[][] rotatePattern(int[][] pattern, int degree) {
        int[][] rotated = new int[pattern.length][2];
        for (int i = 0; i < pattern.length; i++) {
            int x = pattern[i][0];
            int y = pattern[i][1];
            int[] newCoordinates = rotateCoordinates(x, y, degree);
            rotated[i] = newCoordinates;
        }
        return rotated;
    }

    // 좌표를 회전시키는 함수
    public static int[] rotateCoordinates(int x, int y, int degree) {
        int[] newCoordinates = new int[2];
        switch (degree) {
            case 90:
                newCoordinates[0] = -y;
                newCoordinates[1] = x;
                break;
            case 180:
                newCoordinates[0] = -x;
                newCoordinates[1] = -y;
                break;
            case 270:
                newCoordinates[0] = y;
                newCoordinates[1] = -x;
                break;
            default: // 원본 좌표를 반환
                newCoordinates[0] = x;
                newCoordinates[1] = y;
        }
        return newCoordinates;
    }

    // 원본 cube를 건드리지 않고 체크하기
    public static boolean canPlaceCube(int[][] cube, int x, int y) {
        for (int[] square : cube) {
            int nx = x + square[0];
            int ny = y + square[1];
            if (nx < 0 || nx >= 10 || ny < 0 || ny >= 10) {
                return false;
            }
        }
        return true;
    }

}
