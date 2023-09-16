import sys
while True:
    s = (sys.stdin.readline())[:-1]
    if s == '0':
        break
    elif s[::-1] == s:
        print('yes')
    else:
        print('no')