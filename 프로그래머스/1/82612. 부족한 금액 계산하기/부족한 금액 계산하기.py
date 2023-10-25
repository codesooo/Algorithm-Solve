def solution(price, money, count):
    sum = 0
    i = 1
    while i <= count:
        sum += price * i
        i += 1
    if sum > money:
        return sum - money
    else:
        return 0