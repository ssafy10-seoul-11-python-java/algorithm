def app():
    if len(add) != 0:
        if add[-1][1] == '-':
            result = dict[add[-1][2]] - dict[add[-1][3]]
        elif add[-1][1] == '+':
            result = dict[add[-1][2]] + dict[add[-1][3]]
        elif add[-1][1] == '*':
            result = dict[add[-1][2]] * dict[add[-1][3]]
        elif add[-1][1] == '/':
            result = dict[add[-1][2]] / dict[add[-1][3]]
        dict[add[-1][0]] = result
        add.pop()
        app()


for t in range(1, 11):
    N = int(input())  # 정점의 개수
    add = []
    dict = {}
    for _ in range(N):
        a, *b = input().split()
        if b[0] in "+-/*":
            b.insert(0, a)
            add.append(b)
        else:
            dict[a] = int(b[0])
    app()
    result = int(dict['1'])
    print(f'#{t} {result}')