l = int(input())
a = int(input())
b = int(input())
c = int(input())
d = int(input())

if a % c == 0 :
  ret1 = a // c
else :
  ret1 = (a // c) + 1

if b % d == 0 :
  ret2 = b // d
else :
  ret2 = (b // d) + 1

print(l - max(ret1, ret2))