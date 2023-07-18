def checkIsOp(data):
    if data in "+-*/": return True
    else: return False
         
class Node:
    def __init__(self, isOp, data, left, right):
        self.isOp = isOp
        self.data = data
        self.left = int(left)
        self.right =int(right)
         
    def cal(self):
        if not self.isOp: return int(self.data)
         
        if self.data == "+": return  nodes[self.left].cal() + nodes[self.right].cal()
        elif self.data == "-": return  nodes[self.left].cal() - nodes[self.right].cal()
        elif self.data == "*": return  nodes[self.left].cal() * nodes[self.right].cal()
        elif self.data == "/": return  nodes[self.left].cal() / nodes[self.right].cal()
 
for test_case in range(1,11):
    n = int(input())
    nodes = [-1]
    for i in range(n):
        line = input().split()
        isOp = checkIsOp(line[1])
        if(isOp): nodes.append(Node(isOp, line[1], line[2], line[3]))
        else: nodes.append(Node(isOp, line[1], 0, 0))
             
    print("#{} {}".format(test_case, int(nodes[1].cal())))
