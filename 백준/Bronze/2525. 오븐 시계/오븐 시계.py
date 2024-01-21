curH,curM = map(int,input().split())
min = int(input())

curH += min//60
curM += min%60

if curM>=60 :
    curH += curM//60
    curM = curM%60

if curH>=24 :
    curH %= 24

print(curH,curM)