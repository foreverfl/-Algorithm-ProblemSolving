precedence = {
    '+': 1,
    '-': 1,
    '*': 2,
    '/': 2
}

expression = input()
stack = []
ans = []

for ch in expression:
    if ch.isalnum():
        ans.append(ch)
    elif ch == '(':
        stack.append(ch)
    elif ch == ')':
        while stack and stack[-1] != '(':
            ans.append(stack.pop())
        stack.pop()  # 여는 괄호 '(' 제거
    else:
        while stack and precedence.get(ch, 0) <= precedence.get(stack[-1], 0):
            ans.append(stack.pop())
        stack.append(ch)

while stack:
    ans.append(stack.pop())

print(''.join(ans))