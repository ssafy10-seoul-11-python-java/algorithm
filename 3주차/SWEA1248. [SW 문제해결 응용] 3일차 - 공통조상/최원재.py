class Node:
    parent = -1
    left = -1;
    right = -1;
 
    def get_cnt(self):
        if self.left == -1:
            l = 0
        else :
            l = arr[self.left].get_cnt()
        if self.right == -1:
            r = 0
        else :
            r = arr[self.right].get_cnt()
        return l+r+1
 
    def set_child(self, idx):
        if self.left == -1:
            self.left = idx
        else:
            self.right = idx
 
 
def get_height(x):
    cnt = 0
    while(x != 1):
        x = arr[x].parent
        cnt+=1
    return cnt
 
def compare(x, y):
    a = x
    b= y
    height_a = get_height(a)
    height_b = get_height(b)
    if height_a > height_b:
        for i in range(height_a - height_b):
            a = arr[a].parent
    if height_b > height_a:
        for i in range(height_b - height_a):
            b = arr[b].parent
    while(a != b):
        a = arr[a].parent
        b = arr[b].parent
    return a
 
 
T = int(input())
for test_case in range(1, T + 1):
    v, e, a, b = map(int, input().split())
    arr = [Node() for i in range(v+1)]
    line = list(map(int,input().split()))
    for i in range(e):
        x = int(line[i*2])
        y = int(line[i*2 + 1])
        arr[x].set_child(y)
        arr[y].parent = x
    t = compare(a, b)
    print("#",test_case," ",t," ",arr[t].get_cnt(),sep="")
