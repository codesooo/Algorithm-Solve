T = int(input())


def VPSCheck(s):
    for i in range(len(s)):
        if i == 0:
            if s[i] == ')':
                return 'NO'
        if s[i] == '(':
            for j in range(i+1,len(s)):
                if s[j] == ')':
                    s = list(s)
                    s[j] = '1'
                    s[i] = '2'
                    break
    if '(' in s:
        return 'NO'
    if ')' in s:
        return 'NO'
    else:
        return 'YES'

for _ in range(T):
    t = input()
    print(VPSCheck(t))

