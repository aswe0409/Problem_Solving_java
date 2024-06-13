import sys

s = list(sys.stdin.readline().strip())
t = list(sys.stdin.readline().strip())

#s 를 t 로 만드는게 아니라 거꾸로 t를 s 로 만들어 줄거임

while len(t) > len(s):
    if t[-1] == 'B': 
        t.pop() 
        t.reverse() 
    elif t[-1] == 'A':  
        t.pop() 

if s == t:
    print(1)  
else:
    print(0)