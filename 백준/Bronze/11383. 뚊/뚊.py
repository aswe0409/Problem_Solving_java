n,m = map(int,input().split())
A,B = "",""

for _ in range(n):
    for i in input().rstrip():
        A += i*2
        
for _ in range(n):
    B += input().rstrip()
    
print('Eyfa' if A==B else 'Not Eyfa')