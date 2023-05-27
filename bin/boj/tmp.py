import sys
import time

# input() 함수를 사용한 방식
start_time = time.time()

total_input = 0
for _ in range(1000000):
    num = int(input())
    total_input += num

end_time = time.time()
elapsed_time_input = end_time - start_time


# sys.stdin.readline() 메서드를 사용한 방식
start_time = time.time()

total_readline = 0
for _ in range(1000000):
    num = int(sys.stdin.readline())
    total_readline += num

end_time = time.time()
elapsed_time_readline = end_time - start_time

print("Elapsed Time (input()):", elapsed_time_input)
print("Elapsed Time (sys.stdin.readline()):", elapsed_time_readline)