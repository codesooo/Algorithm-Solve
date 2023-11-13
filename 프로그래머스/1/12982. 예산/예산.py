def solution(d, budget):
    sum_b = 0
    d.sort()
    for i in range(len(d)):
        sum_b += d[i] 
        if sum_b > budget:
            return i
        elif sum_b == budget:
            return i+1
        elif i == len(d)-1 and sum_b < budget:
            return i+1