s = input()
l = len(s)//2

if len(s) % 2 == 0:
    s1 = s[:l]
    s2 = s[l:]
else:
    s1 = s[:l]
    s2 = s[l+1:]

re_s2 = "".join(reversed(s2))
if s1 == re_s2:
    print(1)
else:
    print(0)