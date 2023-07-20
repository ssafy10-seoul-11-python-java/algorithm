def dfs(r, c):
    if board[r][c] == '.' :
        board[r][c] = 'C';
        for off_r in range(-1,2):
            for off_c in range(-1,2):
                dfs(r+off_r, c+off_c)
    elif board[r][c] == '1':
        board[r][c] = 'C';
 
T = int(input())
                 
for test_case in range(1, T + 1):
    n = int(input())
    board = [['*' for i in range(n + 2)]]
    for i in range(n):
        board.append(list('*' + input() + '*'))
    board.append(['*' for i in range(n + 2)])
     
    for i in range(1,n+1):
        for j in range(1,n+1):
            if board[i][j] == '*':
                for off_i in range(-1,2):
                    for off_j in range(-1,2):
                        if board[i+off_i][j+off_j] != '*':
                            board[i+off_i][j+off_j] = '1'
     
    click = 0
    for i in range(1,n+1):
        for j in range(1,n+1):
            if board[i][j] == '.' :
                dfs(i,j)
                click += 1
             
    for i in range(1,n+1):
        for j in range(1,n+1):
            if board[i][j] == '1' :
                click += 1
     
    print("#{} {}".format(test_case, click))
