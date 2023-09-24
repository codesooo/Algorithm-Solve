import sys
N = int(input())
NList = []
count = {}
for _ in range(N):
    s= sys.stdin.readline()[:-1]
    NList.append(s[s.find('.')+1:len(s)])
for i in NList:
    try:
        count[i] += 1
    except:
        count[i] = 1
count = sorted(count.items())
for j in count:
    print(j[0],j[1])