package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        permute(list, 0);
    }

    public static void permute(List<Integer> list, int level) {

        if (level == list.size() - 1) {
            System.out.println(list);
        } else {
            for (int i = level; i < list.size(); i++) {
                Collections.swap(list, level, i);
                permute(list, level + 1);
                Collections.swap(list, level, i);
            }
        }
    }
}
