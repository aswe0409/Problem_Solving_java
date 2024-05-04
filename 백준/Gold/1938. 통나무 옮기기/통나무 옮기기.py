from collections import deque

dx=[0,0,1,-1]
dy=[1,-1,0,0]
moving=['U','D','L','R','T']
N=int(input())
room=[[0]*N for _ in range(N)]
tmp=[input().rstrip()for _ in range(N)]

visited=[[[1e9]*N for _ in range(N)] for _ in range(3)]
fcenter_x=0
fcenter_y=0
f_state=-1
ecenter_x=0
ecenter_y=0
e_state=-1


for x in range(N):
    for y in range(N):
        if tmp[x][y]=='B':
            room[x][y]=0
            if f_state==-1:
                fcenter_x=x
                fcenter_y=y
                f_state=0
            #가로
            elif f_state==0 and y==fcenter_y+1:
                fcenter_x=x
                fcenter_y=y
                f_state=1
            #새로
            elif f_state==0 and x==fcenter_x+1:
                fcenter_x=x
                fcenter_y=y
                f_state=2
        elif tmp[x][y]=='E':
            room[x][y]=0
            if e_state==-1:
                ecenter_x=x
                ecenter_y=y
                e_state=0
            #가로
            elif e_state==0 and y==ecenter_y+1:
                ecenter_x=x
                ecenter_y=y
                e_state=1
            #세로
            elif e_state==0 and x==ecenter_x+1:
                ecenter_x=x
                ecenter_y=y
                e_state=2
        else:
            room[x][y]=int(tmp[x][y])


answer=1e9

def move(x,y,state,m):
    if m=='U':
        return x-1,y,state
    elif m=='D':
        return x+1,y,state
    elif m=='L':
        return x,y-1,state
    elif m=='R':
        return x,y+1,state
    elif m=='T':
        if state==1:
            state=2
        else:
            state=1
        return x,y,state

#움직이는게 가능한지 각 동작마다 판단하는 함수
def go_ok(x,y,m,state):

    flag=True
    if m=='U':
        #가로
        if state==1:
            if x-1<0:
                return False
            for j in range(y-1,y+2):
                if room[x-1][j]==1:
                    flag=False
        #세로
        elif state==2:
            if x-2<0:
                return False
            if room[x-2][y]==1:
                flag=False

    elif m=='D':
        # 가로
        if state == 1:
            if x +1>=N:
                return False
            for j in range(y - 1, y + 2):
                if room[x +1][j] == 1:
                    flag=False

        # 세로
        elif state == 2:
            if x +2 >= N:
                return False
            if room[x+2][y]==1:
                flag=False

    elif m=='L':
        # 가로
        if state == 1:
            if y-2<0:
                return False
            if room[x][y-2]==1:
                flag=False
        # 세로
        elif state == 2:
            if y-1< 0:
                return False
            for i in range(x-1 , x+2):
                if room[i][y-1] == 1:
                    flag=False

    elif m=='R':
        # 가로
        if state == 1:
            if y + 2 >= N:
                return False
            if room[x][y+2]==1:
                flag=False

        # 세로
        elif state == 2:
            if y + 1 >=N:
                return False
            for i in range(x - 1, x + 2):
                if room[i][y + 1] == 1:

                    flag=False

    elif m=='T':
        if x-1<0 or x+1>=N:
            return False
        if y-1<0 or y+1>=N:
            return False

        for i in range(x-1,x+2):
            for j in range(y-1,y+2):
                if room[i][j]==1:
                    flag=False
    return flag
q=deque()

q.append([fcenter_x,fcenter_y,f_state])
visited[f_state][fcenter_x][fcenter_y]=0
while q:
    x,y,state=q.popleft()
    if x==ecenter_x and y==ecenter_y and state==e_state:
        answer=min(answer,visited[state][x][y])
        break

    for d in range(5):
        go=moving[d]
        #1. 이동가능여부 확인
        if go_ok(x,y,go,state):
            #2 이동후 간 거리가 이미 간 곳인지 아닌지 확인
            nx,ny,n_state=move(x,y,state,go)
            if visited[n_state][nx][ny]!=1e9:continue
            visited[n_state][nx][ny]=visited[state][x][y]+1
            q.append([nx,ny,n_state])
if answer==1e9:
    answer=0
print(answer)