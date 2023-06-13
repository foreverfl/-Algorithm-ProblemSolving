class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


class BinaryTree:
    def __init__(self):
        self.root = None

    # 전위 순회 (Preorder traversal)
    def preorder_traversal(self, node):
        if node:
            print(node.data, end=" ")
            self.preorder_traversal(node.left)
            self.preorder_traversal(node.right)

    # 중위 순회 (Inorder traversal)
    def inorder_traversal(self, node):
        if node:
            self.inorder_traversal(node.left)
            print(node.data, end=" ")
            self.inorder_traversal(node.right)

    # 후위 순회 (Postorder traversal)
    def postorder_traversal(self, node):
        if node:
            self.postorder_traversal(node.left)
            self.postorder_traversal(node.right)
            print(node.data, end=" ")


# 이진 트리 생성
tree = BinaryTree()
tree.root = Node(1)
tree.root.left = Node(2)
tree.root.right = Node(3)
tree.root.left.left = Node(4)
tree.root.left.right = Node(5)

# 전위 순회 출력(루트 - 왼쪽 - 오른쪽)
print("전위 순회:")
tree.preorder_traversal(tree.root)
print()

# 중위 순회 출력(왼쪽 - 루트 - 오른쪽)
print("중위 순회:")
tree.inorder_traversal(tree.root)
print()

# 후위 순회 출력(왼쪽 - 오른쪽 - 루트)
print("후위 순회:")
tree.postorder_traversal(tree.root)
print()