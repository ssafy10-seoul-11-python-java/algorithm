from collections import deque


from collections import deque
# 주변에 지뢰가 하나도 없으면 클릭하고 하나라도 있으면 클릭하지 않고 건너 뛴다.
def clickOrNot(x, y):
    global cnt
    next_target = []
    for k in range(8):
        nx = x + dx[k]
        ny = y + dy[k]
        if 0 <= nx < n and 0 <= ny < n:
            if mine[nx][ny] == '.':
                next_target.append((nx, ny))
            elif mine[nx][ny] == '*':
                break
    else:
        # 지뢰가 주변에 하나도 없어 else문으로 오게 되면
        if next_target: 
            mine[x][y] = 'o'  
            cnt += 1 
            spread(next_target) 


def spread(lst):
    q = deque(lst)
    while q:
        x, y = q.popleft()
        mine[x][y] = 'o'  
        next_next_target = []
        for k in range(8): 
            nx = x + dx[k]
            ny = y + dy[k]
            if 0 <= nx < n and 0 <= ny < n:
                if mine[nx][ny] == '.':
                    next_next_target.append((nx, ny))
                elif mine[nx][ny] == '*':
                    break
        else:
            spread(next_next_target)


# 클릭해도 퍼져나가지 않는 곳
def restTarget():
    global cnt
    for i in range(n):
        for j in range(n):
            if mine[i][j] == '.':
                cnt += 1


for tc in range(1, 1 + int(input())):
    n = int(input())
    mine = [list(input()) for _ in range(n)]
    cnt = 0
    dx, dy = [-1, -1, -1, 0, 1, 1, 1, 0], [-1, 0, 1, 1, 1, 0, -1, -1]  
   
    for i in range(n):
        for j in range(n):
            if mine[i][j] == '.':
                clickOrNot(i, j)

    restTarget()
    print('#{} {}'.format(tc, cnt))
