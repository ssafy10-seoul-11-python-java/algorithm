T = int(input())
 
 
def find_subtree(n):
    global subtree_size
    for k in range(2):
        if tree[n][k]:
            subtree_size += 1
            find_subtree(tree[n][k])
 
 
for time in range(1, T+1):
    # 정점의 수 v, 간선의 수 e, 공통조상 p_1,p_2
    v, E, p_1, p_2 = map(int, input().split())
 
    node = list(map(int, input().split()))
 
    tree = [[0] * 3 for _ in range(v+1)]
 
    # 자식, 자식2,부모
    for i in range(E):
        s, e = node[i * 2], node[i * 2 + 1]
        if tree[s][0]:
            tree[s][1] = e
        else:
            tree[s][0] = e
 
        tree[e][2] = s
 
    a_lst = []
    b_lst = []
 
    # 두 개 노드의 부모노드 찾기
    while True:
        if p_1 != 0:
            p_1 = tree[p_1][2]
            a_lst.append(p_1)
 
        if p_2 != 0:
            p_2 = tree[p_2][2]
            b_lst.append(p_2)
 
        if p_1 == 0 and p_2 == 0:
            break
 
    # 공통부모노드
    res_num = 0
 
    for w in a_lst:
        if res_num != 0:
            break
 
        for e in b_lst:
            if w == e:
                res_num = w
                break
 
    subtree_size = 1
    find_subtree(res_num)
    print(f'#{time} {res_num} {subtree_size}')
