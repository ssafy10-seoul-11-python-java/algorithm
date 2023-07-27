def bfs(y, x):

    board[y][x] = '0'
    ret = 1
    q = [(y, x)]

    while q:
        y1, x1 = q.pop()
        nxt = [(y1+1, x1), (y1-1, x1), (y1, x1+1), (y1, x1-1)]
        for y2, x2 in nxt:
            if board[y2][x2] == '1':
                board[y2][x2] = '0'
                ret += 1
                q.append((y2, x2))

    return ret

n = int(input())

board = [['0' for i in range(n + 2)]]
for i in range(n):
    board.append(['0'] + list(input()) + ['0'])
board.append(['0' for i in range(n + 2)])

result = []
for i in range(1, n+1):
    for j in range(1, n+1):
        if board[i][j] == '1':
            result.append(bfs(i, j))

result.sort()
print(len(result))
for i in result:
        print(i)
