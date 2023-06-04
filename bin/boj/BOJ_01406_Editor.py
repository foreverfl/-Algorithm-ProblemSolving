str = input()
N = int(input())
left_stack = list(str)
right_stack = []

for _ in range(N):
    command = input()
    if command == 'L':
        if left_stack:
            right_stack.append(left_stack.pop())
    elif command == 'D':
        if right_stack:
            left_stack.append(right_stack.pop())
    elif command == 'B':
        if left_stack:
            left_stack.pop()
    elif command[0] == 'P':
        left_stack.append(command[2])

print(''.join(left_stack + right_stack[::-1]))
