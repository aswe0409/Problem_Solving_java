n = int(input())
k = input()
odd, even = 0,0

for i in k:
    if int(i) % 2 != 0:
        odd +=1
    else:
        even +=1
if odd > even:
    print(1)
elif odd < even:
    print(0)
else:
    print(-1)