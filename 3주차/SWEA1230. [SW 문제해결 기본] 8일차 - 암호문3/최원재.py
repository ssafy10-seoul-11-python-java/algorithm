class Node():
    value = -1
    next = -1

    def __init__(self, v):
        self.value = v

def insertNode(x, y, s):
    global end
    cur = start
    for _ in range(x):
        cur = cur.next
    next = cur.next
    for i in range(y):
        cur.next = Node(s[i])
        cur = cur.next
    if next is -1:
        end = cur
    cur.next = next

def deleteNode(x, y):
    global end
    cur = start
    for _ in range(x):
        cur = cur.next
    temp = cur
    for i in range(y):
        cur = cur.next
    if cur.next is -1:
        end = temp
    temp.next = cur.next

def addNode(y, s):
    global end
    cur = end
    for i in range(y):
        cur.next = Node(s[i])
        cur = cur.next
    end = cur

for test_case in range(1, 11):
    n = int(input())
    arr = list(map(int, input().split()))
    global end
    start = end = Node(-1)

    cur = start
    for i in range(0, n):
        cur.next = Node(arr[i])
        cur = end = cur.next
    m = int(input())
    cmd = list(input().split())
    l = len(cmd)
    cnt = 0
    while cnt < l:
        if cmd[cnt] is 'I':
            x = int(cmd[cnt + 1])
            y = int(cmd[cnt + 2])
            s = cmd[cnt + 3: cnt + 3 + y]
            insertNode(x, y, s)
            cnt += (y + 3)
        elif cmd[cnt] is 'D':
            x = int(cmd[cnt + 1])
            y = int(cmd[cnt + 2])
            deleteNode(x, y)
            cnt += 3
        elif cmd[cnt] is 'A':
            y = int(cmd[cnt + 1])
            s = cmd[cnt + 2: cnt + 2 + y]
            addNode(y, s)
            cnt += (y + 2)

    cur = start.next
    print("#",test_case,sep="", end=" ")
    for i in range(10):
        print(cur.value, end=" ")
        cur = cur.next
    print()
