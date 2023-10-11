import sys

def TGN(r, e, c):
    if r < e-c:
        return("advertise")
    elif r == e-c:
        return("does not matter")
    elif r > e-c:
        return("do not advertise")
    
N = int(input())

for _ in range(N):
    r, e, c = map(int, sys.stdin.readline().split())
    print(TGN(r, e, c))
