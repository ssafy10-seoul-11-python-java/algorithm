class Node:
    value = -1;
    left = -1;
    right = -1;
    def get_value(self):
        if(self.value == '+'):
            return node_list[int(self.left)].get_value() + node_list[int(self.right)].get_value()
        elif(self.value == '-'):
            return node_list[int(self.left)].get_value() - node_list[int(self.right)].get_value()
        elif(self.value == '*'):
            return node_list[int(self.left)].get_value() * node_list[int(self.right)].get_value()
        elif(self.value == '/'):
            return node_list[int(self.left)].get_value() / node_list[int(self.right)].get_value()
        else:
            return int(self.value)
 
for test_case in range(1, 11):
    n = int(input())
    node_list = [Node() for j in range(n+1)]
    for i in range(1, n+1):
        v = input().split()
        node_list[int(v[0])].value = v[1]
        if v[1] == '+' or v[1] == '-' or v[1] == '*' or v[1] == '/':
            node_list[i].left = v[2]
            node_list[i].right = v[3]
    print("#",test_case," ",int(node_list[1].get_value()),sep="")
