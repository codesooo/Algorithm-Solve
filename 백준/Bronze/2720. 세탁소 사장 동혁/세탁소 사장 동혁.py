import sys
T = int(input())

quarter = 25
dime = 10
nickel = 5
penny = 1

for _ in range(T):
    C = int(sys.stdin.readline()) 
    C_Q = C // quarter
    C_D = (C - C_Q * quarter) // dime
    C_N = (C - C_Q * quarter - C_D * dime) // nickel
    temp = C - C_Q * quarter - C_D * dime - C_N * nickel
    C_P = (C - C_Q * quarter - C_D * dime - C_N * nickel) // penny
    
    print(C_Q, C_D, C_N, C_P)