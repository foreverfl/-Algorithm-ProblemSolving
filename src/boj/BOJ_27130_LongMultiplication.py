a = input()
b = input()
b_str = str(b)

print(a)
print(b)
for i in reversed(b_str):
    print(int(i) * int(a))

print(int(a) * int(b))
