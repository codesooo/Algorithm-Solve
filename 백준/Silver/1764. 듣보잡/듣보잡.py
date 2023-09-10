N, M = map(int, input().split())
noHearList = []
noSeeList = []

for _ in range(N):
    no_hear = input()
    noHearList.append(no_hear)

for _ in range(M):
    no_see = input()
    noSeeList.append(no_see)

noHaS = sorted(list(set(noHearList) & set(noSeeList)))

print(len(noHaS))
for i in noHaS:
    print(i)