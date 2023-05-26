students = list(range(1, 31))

for _ in range(28):
    student = int(input())
    if student in students:
        students.remove(student)

students = sorted(students)

for i in range(len(students)):
    print(students[i])
