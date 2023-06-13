package algorithm;

public class BinaryTreeExample {
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

    public static class BinaryTree {
        Node root;

        public BinaryTree() {
            root = null;
        }

        // 전위 순회 (Preorder traversal)
        public void preorderTraversal(Node node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preorderTraversal(node.left);
                preorderTraversal(node.right);
            }
        }

        // 중위 순회 (Inorder traversal)
        public void inorderTraversal(Node node) {
            if (node != null) {
                inorderTraversal(node.left);
                System.out.print(node.data + " ");
                inorderTraversal(node.right);
            }
        }

        // 후위 순회 (Postorder traversal)
        public void postorderTraversal(Node node) {
            if (node != null) {
                postorderTraversal(node.left);
                postorderTraversal(node.right);
                System.out.print(node.data + " ");
            }
        }
    }

    public static void main(String[] args) {
        // 이진 트리 생성
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        // 전위 순회 출력(루트 - 왼쪽 - 오른쪽)
        System.out.println("전위 순회:");
        tree.preorderTraversal(tree.root);
        System.out.println();

        // 중위 순회 출력(왼쪽 - 루트 - 오른쪽)
        System.out.println("중위 순회:");
        tree.inorderTraversal(tree.root);
        System.out.println();

        // 후위 순회 출력(왼쪽 - 오른쪽)
        System.out.println("후위 순회:");
        tree.postorderTraversal(tree.root);
        System.out.println();
    }

}
