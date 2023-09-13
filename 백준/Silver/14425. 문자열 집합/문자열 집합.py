import sys
N, M = map(int, sys.stdin.readline().split())

s = set()
count = 0
for _ in range(N):
    input_s = (sys.stdin.readline())[:-1]
    s.add(input_s)
for _ in range(M):
    check = (sys.stdin.readline())[:-1]
    if check in s:
        count += 1
print(count)