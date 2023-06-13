package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BOJ_04256_Tree {
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static Node buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length)
            return null;

        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static Node buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        int rootValue = preorder[preStart];
        Node root = new Node(rootValue);

        int rootIndex = findRootIndex(inorder, inStart, inEnd, rootValue);
        int leftSubtreeSize = rootIndex - inStart;

        root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart, rootIndex - 1);
        root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }

    private static int findRootIndex(int[] inorder, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == value)
                return i;
        }
        return -1;
    }

        /*  1. 왼쪽 서브트리를 먼저 방문하기 위해 현재 노드를 스택에 넣습니다.
            2. 현재 노드에서 왼쪽 자식 노드로 이동하면서 왼쪽 서브트리를 순회합니다. 왼쪽 자식 노드가 없을 때까지 스택에 계속해서 왼쪽 자식 노드를 추가합니다.
            3. 왼쪽 서브트리를 순회한 후, 오른쪽 서브트리를 방문하기 위해 현재 노드를 스택에서 꺼냅니다.
            4. 오른쪽 서브트리로 이동하면서 오른쪽 서브트리를 순회합니다. 오른쪽 자식 노드가 없을 때까지 스택에 계속해서 오른쪽 자식 노드를 추가합니다.
            5. 마지막으로 현재 노드를 처리합니다. 이때, 현재 노드의 값을 출력하거나 다른 작업을 수행합니다.
        */
    public static List<Integer> postorderTraversal(Node root, int n) {
        List<Integer> postOrder = new ArrayList<>();
      
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        Node prev = null;
        while (!stack.isEmpty()) {
            Node current = stack.peek();

            if (prev == null || prev.left == current || prev.right == current) {
                if (current.left != null)
                    stack.push(current.left);
                else if (current.right != null)
                    stack.push(current.right);
            } else if (current.left == prev) {
                if (current.right != null)
                    stack.push(current.right);
            } else {
                postOrder.add(current.data);
                stack.pop();
            }

            prev = current;
        }

        return postOrder;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] preorder = new int[n];
            int[] inorder = new int[n];
            String[] tmp = br.readLine().split(" ");
            for(int i = 0; i < n; i++){
                preorder[i] = Integer.parseInt(tmp[i]);
            }

            tmp = br.readLine().split(" ");
            for(int i = 0; i < n; i++){
                inorder[i] = Integer.parseInt(tmp[i]);
            }

            Node root = buildTree(preorder, inorder);
            List<Integer> postOrder = postorderTraversal(root, n);
            for(int num : postOrder) {
                System.out.print(num + " ");
            }
            System.out.println();

        } 
    }

}
