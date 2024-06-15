x,y,w,s = map(int, input().split())

#평행이동
temp1 = (x+y) * w
# 대각선 이동
if(x+y) % 2 == 0:
    temp2 = max(x,y) * s
# 대각선 이동 + 평행이동
else:
    temp2 = (max(x,y)-1) * s + w

# 평행이동 + 대각선 이동
temp3 = (min(x, y) * s) + (abs(x-y) * w)

print(min(temp1,temp2,temp3))