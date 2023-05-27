a = int(input())
b = int(input())
c = int(input())

if a == 60 and b == 60 and c == 60:
    print('Equilateral')
elif a + b + c == 180 and (a == b or b == c or a == c):
    print('Isosceles')
elif a + b + c == 180 and (a != b and b != c and a != c):
    print('Scalene')
elif a + b + c != 180:
    print('Error')
