class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None


def buildTree(preorder, inorder):
    if not preorder or not inorder or len(preorder) != len(inorder):
        return None

    return buildTreeHelper(preorder, 0, len(preorder) - 1, inorder, 0, len(inorder) - 1)


def buildTreeHelper(preorder, preStart, preEnd, inorder, inStart, inEnd):
    if preStart > preEnd or inStart > inEnd:
        return None

    rootValue = preorder[preStart]
    root = Node(rootValue)

    rootIndex = findRootIndex(inorder, inStart, inEnd, rootValue)
    leftSubtreeSize = rootIndex - inStart

    root.left = buildTreeHelper(
        preorder, preStart + 1, preStart + leftSubtreeSize, inorder, inStart, rootIndex - 1)
    root.right = buildTreeHelper(
        preorder, preStart + leftSubtreeSize + 1, preEnd, inorder, rootIndex + 1, inEnd)

    return root


def findRootIndex(inorder, start, end, value):
    for i in range(start, end + 1):
        if inorder[i] == value:
            return i
    return -1


def postorderTraversal(root):
    if not root:
        return []

    postOrder = []
    stack = []
    prev = None

    while stack or root:
        if root:
            stack.append(root)
            root = root.left
        else:
            current = stack[-1]
            if current.right and current.right != prev:
                root = current.right
            else:
                postOrder.append(current.data)
                prev = current
                stack.pop()

    return postOrder


T = int(input())

for _ in range(T):
    n = int(input())
    preorder = list(map(int, input().split()))
    inorder = list(map(int, input().split()))

    root = buildTree(preorder, inorder)
    postOrder = postorderTraversal(root)

    print(*postOrder)
