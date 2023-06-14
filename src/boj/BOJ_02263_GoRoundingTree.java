package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_02263_GoRoundingTree {
    public static class TreeNode  {
        int val;
        TreeNode left;
        TreeNode right;
        
        public TreeNode (int val) {
            this.val = val;
        }
    }

    public static void constructPreorder(int[] inorder, int[] postorder, int inStart, int inEnd,
                                         int postStart, int postEnd, Map<Integer, Integer> map,
                                         StringBuilder sb) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }

        int rootVal = postorder[postEnd];

        int rootIndex = map.get(rootVal);

        int leftSubtreeSize = rootIndex - inStart;

        sb.append(rootVal).append(" ");

        constructPreorder(inorder, postorder, inStart, rootIndex - 1,
                postStart, postStart + leftSubtreeSize - 1, map, sb);

        constructPreorder(inorder, postorder, rootIndex + 1, inEnd,
                postStart + leftSubtreeSize, postEnd - 1, map, sb);
    }
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
       
        int[] inorder = new int[n];
        String[] tmp = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(tmp[i]);
        }

        int[] postorder = new int[n];
        tmp = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(tmp[i]);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        StringBuilder sb = new StringBuilder();
        constructPreorder(inorder, postorder, 0, n - 1, 0, n - 1, map, sb);

        System.out.println(sb.toString());
    }
}
