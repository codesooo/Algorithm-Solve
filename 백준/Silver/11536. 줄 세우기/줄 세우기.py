import sys
nameList = []
N = int(input())
for _ in range(N):
    name = sys.stdin.readline()
    nameList.append(name)
increase = sorted(nameList)
decrease = sorted(nameList, reverse=True)

if nameList == increase:
    print("INCREASING")
elif nameList == decrease:
    print("DECREASING")
else:
    print("NEITHER")