import sys
N = int(input())
s = []
max = 0
cnt = 0
maxTitle = ''

for i in range(N):
    title = sys.stdin.readline()[:-1]
    s.append(title)

s = sorted(s)
set_s = sorted(set(s))
for i in set_s:
    cnt = s.count(i)
    if max < cnt:
        max = cnt
        maxTitle = i
print(maxTitle)