package programmers_Copied;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Copied_Programmers_42894_BlockGame {
    public static void main(String args[]) {
        System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 4, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 4, 4, 0, 0, 0 }, { 0, 0, 0, 0, 3, 0, 4, 0, 0, 0 }, { 0, 0, 0, 2, 3, 0, 0, 0, 5, 5 },
                { 1, 2, 2, 2, 3, 3, 0, 0, 0, 5 }, { 1, 1, 1, 0, 0, 0, 0, 0, 0, 5 } }));
    }

    static class Item {
        int r, c;

        Item(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int solution(int[][] board) {
        int answer = 0;

        ArrayList<ArrayList<Item>> aList = new ArrayList<>();
        ArrayList<Integer> canList = new ArrayList<>();

        for (int i = 0; i < 201; i++)
            aList.add(new ArrayList<Item>());

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != 0)
                    aList.get(board[i][j]).add(new Item(i, j));
            }
        }

        for (int i = 0; i < aList.size(); i++) {
            ArrayList<Item> aListList = aList.get(i);
            if (aListList.size() != 4)
                continue;

            Item i1 = aListList.get(0);
            Item i2 = aListList.get(1);
            Item i3 = aListList.get(2);
            Item i4 = aListList.get(3);

            if (i2.r == i3.r && i3.r == i4.r && i2.c + 1 == i3.c && i3.c + 1 == i4.c && i1.r + 1 == i2.r) { // 밑변 확인
                if (i1.c == i2.c) {
                    // |___
                    canList.add(i);
                } else if (i1.c == i4.c) {
                    // ___|
                    canList.add(i);
                } else if (i1.c == i3.c) {
                    // ㅗ
                    canList.add(i);
                }
            } else if (i1.c == i2.c && i2.c == i4.c && i1.r + 1 == i2.r && i2.r + 1 == i4.r
                    && i3.r == i4.r && i3.c + 1 == i4.c) {
                // _|
                canList.add(i);
            } else if (i1.c == i2.c && i2.c == i3.c && i1.r + 1 == i2.r && i2.r + 1 == i3.r
                    && i3.r == i4.r && i3.c + 1 == i4.c) {
                // |_
                canList.add(i);
            }
        }

        Collections.sort(canList, new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                Item item1 = aList.get(i1).get(3);
                Item item2 = aList.get(i2).get(3);

                if (item1.r == item2.r) {
                    return Integer.compare(item1.c, item2.c);
                } else
                    return Integer.compare(item1.r, item2.r);
            }
        });

        for (int i : canList) {
            ArrayList<Item> list = aList.get(i);
            boolean flag = true;

            int firstC = list.get(0).c;
            for (int j = 1; j < list.size(); j++) {
                int r = list.get(j).r;
                int c = list.get(j).c;

                if (c == firstC)
                    continue;

                while (r >= 0) { // 해당 열에서 위가 비어있는지 확인함
                    if (board[r][c] != 0 && board[r][c] != i) {
                        flag = false;
                        break;
                    }
                    r -= 1;
                }
            }

            if (flag) {
                for (Item item : list)
                    board[item.r][item.c] = 0;
                answer += 1;
            }

        }

        return answer;
    }
}
