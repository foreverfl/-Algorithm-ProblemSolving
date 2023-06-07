import sys


class Element:
    def __init__(self, val, idx):
        self.val = val
        self.idx = idx

    def __str__(self):
        return "Value: " + str(self.val) + ", Index: " + str(self.idx)


N = int(sys.stdin.readline())
original = [None] * (N + 1)
original[0] = Element(0, 0)

for i in range(1, N + 1):
    original[i] = Element(0, 0)
    original[i].val = int(sys.stdin.readline())
    original[i].idx = i

copied = [None] * len(original)
copied[0] = Element(0, 0)
for i in range(1, N + 1):
    copied[i] = Element(0, 0)
    copied[i].val = original[i].val
    copied[i].idx = original[i].idx

original.sort(key=lambda x: x.val)

indices = [0] * (N + 1)
for i in range(1, N + 1):
    indices[i] = original[i].idx - copied[i].idx

max_val = max(indices)
print(max_val + 1)
