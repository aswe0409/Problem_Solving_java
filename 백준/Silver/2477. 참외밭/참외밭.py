n = int(input())
width = []
height = []
total = []

for _ in range(6):
    way, temp = map(int, input().split())
    total.append(temp)
    if(way == 1 or way == 2): # 가로 방향이면
        width.append(temp)
    else:
        height.append(temp)
        
max_width = max(width)
max_height = max(height)

# 세로 최대값 인덱스
maxhidx = total.index(max(height))
# 가로 최대값 인덱스
maxwidx = total.index(max(width))

# 전체 이동에서 세로 최대값의 다음값에서 세로 최대값 이전의 가로값을 빼준 것이 작은 사각형의 가로값
sheight = abs(total[maxhidx-1] - total[(maxhidx-5 if maxhidx == 5 else maxhidx +1)])
# 가로 최대값의 이전 및 다음값을 활용하여 작은 사각형의 세로값 계산
sweight= abs(total[maxwidx-1] - total[(maxwidx-5 if maxwidx == 5 else maxwidx +1)])


area = (max_width * max_height) - (sheight * sweight)
print(area * n)